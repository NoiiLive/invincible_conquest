
package net.clozynoii.invincibleconquest.world.inventory;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.procedures.AtomEveCreationWhileThisGUIIsOpenTickProcedure;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMenus;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class AtomEveCreationMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;

	public AtomEveCreationMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(InvincibleConquestModMenus.ATOM_EVE_CREATION.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(0);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		return ItemStack.EMPTY;
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
	public static record AtomEveCreationSyncMessage(int mode, int x, int y, int z, HashMap<String, String> textstate) implements CustomPacketPayload {

		public static final Type<AtomEveCreationSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "atom_eve_creation_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, AtomEveCreationSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AtomEveCreationSyncMessage message) -> {
			buffer.writeInt(message.mode);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			writeTextState(message.textstate, buffer);
		}, (RegistryFriendlyByteBuf buffer) -> new AtomEveCreationSyncMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), readTextState(buffer)));
		@Override
		public Type<AtomEveCreationSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final AtomEveCreationSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.SERVERBOUND) {
				context.enqueueWork(() -> {
					Player entity = context.player();
					int mode = message.mode;
					int x = message.x;
					int y = message.y;
					int z = message.z;
					HashMap<String, String> textstate = message.textstate;
					handleSyncAction(entity, mode, x, y, z, textstate);
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

		public static void handleSyncAction(Player entity, int mode, int x, int y, int z, HashMap<String, String> textstate) {
			Level world = entity.level();
			HashMap guistate = AtomEveCreationMenu.guistate;
			// connect EditBox and CheckBox to guistate
			for (Map.Entry<String, String> entry : textstate.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				guistate.put(key, value);
			}
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(new BlockPos(x, y, z)))
				return;
			//code
			if (mode == 0)
				AtomEveCreationWhileThisGUIIsOpenTickProcedure.execute(entity, guistate);
		}

		private static void writeTextState(HashMap<String, String> map, RegistryFriendlyByteBuf buffer) {
			buffer.writeInt(map.size());
			for (Map.Entry<String, String> entry : map.entrySet()) {
				writeComponent(buffer, Component.literal(entry.getKey()));
				writeComponent(buffer, Component.literal(entry.getValue()));
			}
		}

		private static HashMap<String, String> readTextState(RegistryFriendlyByteBuf buffer) {
			int size = buffer.readInt();
			HashMap<String, String> map = new HashMap<>();
			for (int i = 0; i < size; i++) {
				String key = readComponent(buffer).getString();
				String value = readComponent(buffer).getString();
				map.put(key, value);
			}
			return map;
		}

		private static Component readComponent(RegistryFriendlyByteBuf buffer) {
			return ComponentSerialization.TRUSTED_STREAM_CODEC.decode(buffer);
		}

		private static void writeComponent(RegistryFriendlyByteBuf buffer, Component component) {
			ComponentSerialization.TRUSTED_STREAM_CODEC.encode(buffer, component);
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			InvincibleConquestMod.addNetworkMessage(AtomEveCreationSyncMessage.TYPE, AtomEveCreationSyncMessage.STREAM_CODEC, AtomEveCreationSyncMessage::handleData);
		}
	}
}
