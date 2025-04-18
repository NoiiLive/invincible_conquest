
package net.clozynoii.invincibleconquest.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.world.inventory.MenuStatsMenu;
import net.clozynoii.invincibleconquest.procedures.RemoveSkillPointsProcedure;
import net.clozynoii.invincibleconquest.procedures.OpenGUIAbilityBasicProcedure;
import net.clozynoii.invincibleconquest.procedures.OpenFactionMenuProcedure;
import net.clozynoii.invincibleconquest.procedures.AddSkillPointsProcedure;
import net.clozynoii.invincibleconquest.procedures.AddPointVitalityProcedure;
import net.clozynoii.invincibleconquest.procedures.AddPointStrengthProcedure;
import net.clozynoii.invincibleconquest.procedures.AddPointStaminaProcedure;
import net.clozynoii.invincibleconquest.procedures.AddPointIntelligenceProcedure;
import net.clozynoii.invincibleconquest.procedures.AddPointFocusProcedure;
import net.clozynoii.invincibleconquest.procedures.AddPointDurabilityProcedure;
import net.clozynoii.invincibleconquest.procedures.AddPointAgilityProcedure;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import java.util.Map;
import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record MenuStatsButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) implements CustomPacketPayload {

	public static final Type<MenuStatsButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "menu_stats_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MenuStatsButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, MenuStatsButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		writeTextState(message.textstate, buffer);
	}, (RegistryFriendlyByteBuf buffer) -> new MenuStatsButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), readTextState(buffer)));
	@Override
	public Type<MenuStatsButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final MenuStatsButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				HashMap<String, String> textstate = message.textstate;
				handleButtonAction(entity, buttonID, x, y, z, textstate);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
		Level world = entity.level();
		HashMap guistate = MenuStatsMenu.guistate;
		// connect EditBox and CheckBox to guistate
		for (Map.Entry<String, String> entry : textstate.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			guistate.put(key, value);
		}
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			RemoveSkillPointsProcedure.execute(entity);
		}
		if (buttonID == 1) {

			AddSkillPointsProcedure.execute(entity);
		}
		if (buttonID == 2) {

			AddPointStrengthProcedure.execute(entity);
		}
		if (buttonID == 3) {

			AddPointDurabilityProcedure.execute(entity);
		}
		if (buttonID == 4) {

			AddPointAgilityProcedure.execute(entity);
		}
		if (buttonID == 5) {

			AddPointStaminaProcedure.execute(entity);
		}
		if (buttonID == 6) {

			AddPointVitalityProcedure.execute(entity);
		}
		if (buttonID == 7) {

			AddPointFocusProcedure.execute(entity);
		}
		if (buttonID == 8) {

			AddPointIntelligenceProcedure.execute(entity);
		}
		if (buttonID == 9) {

			OpenGUIAbilityBasicProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			OpenFactionMenuProcedure.execute(world, x, y, z, entity);
		}
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
		InvincibleConquestMod.addNetworkMessage(MenuStatsButtonMessage.TYPE, MenuStatsButtonMessage.STREAM_CODEC, MenuStatsButtonMessage::handleData);
	}
}
