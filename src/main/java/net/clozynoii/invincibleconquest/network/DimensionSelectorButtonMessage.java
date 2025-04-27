
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
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.world.inventory.DimensionSelectorMenu;
import net.clozynoii.invincibleconquest.procedures.SelectDimensionSnowProcedure;
import net.clozynoii.invincibleconquest.procedures.SelectDimensionRandomProcedure;
import net.clozynoii.invincibleconquest.procedures.SelectDimensionPreHistoricProcedure;
import net.clozynoii.invincibleconquest.procedures.SelectDimensionOverworldProcedure;
import net.clozynoii.invincibleconquest.procedures.SelectDimensionNetherProcedure;
import net.clozynoii.invincibleconquest.procedures.SelectDimensionFlaxanProcedure;
import net.clozynoii.invincibleconquest.procedures.SelectDimensionEndProcedure;
import net.clozynoii.invincibleconquest.procedures.SelectDimensionDesertProcedure;
import net.clozynoii.invincibleconquest.procedures.SelectDimensionApocalypticProcedure;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record DimensionSelectorButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<DimensionSelectorButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "dimension_selector_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, DimensionSelectorButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, DimensionSelectorButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new DimensionSelectorButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<DimensionSelectorButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final DimensionSelectorButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = DimensionSelectorMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SelectDimensionRandomProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SelectDimensionOverworldProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			SelectDimensionNetherProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SelectDimensionEndProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SelectDimensionApocalypticProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			SelectDimensionDesertProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			SelectDimensionSnowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			SelectDimensionFlaxanProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			SelectDimensionPreHistoricProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleConquestMod.addNetworkMessage(DimensionSelectorButtonMessage.TYPE, DimensionSelectorButtonMessage.STREAM_CODEC, DimensionSelectorButtonMessage::handleData);
	}
}
