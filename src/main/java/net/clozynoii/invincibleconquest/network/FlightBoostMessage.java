
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

import net.clozynoii.invincibleconquest.procedures.KeybindFlightBoostProcedure;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record FlightBoostMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<FlightBoostMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "key_flight_boost"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FlightBoostMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FlightBoostMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new FlightBoostMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<FlightBoostMessage> type() {
		return TYPE;
	}

	public static void handleData(final FlightBoostMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			KeybindFlightBoostProcedure.execute(entity);
		}
		if (type == 1) {

			KeybindFlightBoostProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleConquestMod.addNetworkMessage(FlightBoostMessage.TYPE, FlightBoostMessage.STREAM_CODEC, FlightBoostMessage::handleData);
	}
}
