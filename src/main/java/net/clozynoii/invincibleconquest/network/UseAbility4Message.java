
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

import net.clozynoii.invincibleconquest.procedures.KeybindAbility4Procedure;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record UseAbility4Message(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<UseAbility4Message> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "key_use_ability_4"));
	public static final StreamCodec<RegistryFriendlyByteBuf, UseAbility4Message> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, UseAbility4Message message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new UseAbility4Message(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<UseAbility4Message> type() {
		return TYPE;
	}

	public static void handleData(final UseAbility4Message message, final IPayloadContext context) {
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

			KeybindAbility4Procedure.execute(world, x, y, z, entity);
		}
		if (type == 1) {

			KeybindAbility4Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleConquestMod.addNetworkMessage(UseAbility4Message.TYPE, UseAbility4Message.STREAM_CODEC, UseAbility4Message::handleData);
	}
}
