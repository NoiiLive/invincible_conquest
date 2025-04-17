
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

import net.clozynoii.invincibleconquest.world.inventory.FactionJoinGDAMenu;
import net.clozynoii.invincibleconquest.procedures.JoinGDAProcedure;
import net.clozynoii.invincibleconquest.procedures.DeclineFactionProcedure;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record FactionJoinGDAButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<FactionJoinGDAButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "faction_join_gda_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FactionJoinGDAButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FactionJoinGDAButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new FactionJoinGDAButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<FactionJoinGDAButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final FactionJoinGDAButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = FactionJoinGDAMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			JoinGDAProcedure.execute(entity);
		}
		if (buttonID == 1) {

			DeclineFactionProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleConquestMod.addNetworkMessage(FactionJoinGDAButtonMessage.TYPE, FactionJoinGDAButtonMessage.STREAM_CODEC, FactionJoinGDAButtonMessage::handleData);
	}
}
