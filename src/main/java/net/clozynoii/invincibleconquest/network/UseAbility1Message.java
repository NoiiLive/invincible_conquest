
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

import net.clozynoii.invincibleconquest.procedures.KeybindAbility1Procedure;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record UseAbility1Message(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<UseAbility1Message> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "key_use_ability_1"));
	public static final StreamCodec<RegistryFriendlyByteBuf, UseAbility1Message> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, UseAbility1Message message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new UseAbility1Message(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<UseAbility1Message> type() {
		return TYPE;
	}

	public static void handleData(final UseAbility1Message message, final IPayloadContext context) {
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

			KeybindAbility1Procedure.execute(world, x, y, z, entity);
		}
		if (type == 1) {

			KeybindAbility1Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleConquestMod.addNetworkMessage(UseAbility1Message.TYPE, UseAbility1Message.STREAM_CODEC, UseAbility1Message::handleData);
	}
}
