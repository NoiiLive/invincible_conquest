
package net.clozynoii.invincibleconquest.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.clozynoii.invincibleconquest.InvincibleConquestMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record FollowUpMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<FollowUpMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "key_follow_up"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FollowUpMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FollowUpMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new FollowUpMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<FollowUpMessage> type() {
		return TYPE;
	}

	public static void handleData(final FollowUpMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleConquestMod.addNetworkMessage(FollowUpMessage.TYPE, FollowUpMessage.STREAM_CODEC, FollowUpMessage::handleData);
	}
}
