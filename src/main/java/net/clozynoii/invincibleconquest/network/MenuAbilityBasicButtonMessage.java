
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

import net.clozynoii.invincibleconquest.world.inventory.MenuAbilityBasicMenu;
import net.clozynoii.invincibleconquest.procedures.UnlockUppercutProcedure;
import net.clozynoii.invincibleconquest.procedures.UnlockSlamProcedure;
import net.clozynoii.invincibleconquest.procedures.UnlockHeavyAttackProcedure;
import net.clozynoii.invincibleconquest.procedures.UnlockGrabProcedure;
import net.clozynoii.invincibleconquest.procedures.UnlockDashProcedure;
import net.clozynoii.invincibleconquest.procedures.UnlockBarrageProcedure;
import net.clozynoii.invincibleconquest.procedures.OpenGUIAbilityProcedure;
import net.clozynoii.invincibleconquest.procedures.KeybindStatMenuProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot5bProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot5aProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot4bProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot4aProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot3bProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot3aProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot2bProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot2aProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot1bProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot1aProcedure;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record MenuAbilityBasicButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<MenuAbilityBasicButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "menu_ability_basic_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MenuAbilityBasicButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, MenuAbilityBasicButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new MenuAbilityBasicButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<MenuAbilityBasicButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final MenuAbilityBasicButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = MenuAbilityBasicMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			KeybindStatMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenGUIAbilityProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			GUISkillSlot1aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			GUISkillSlot2aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			GUISkillSlot3aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			GUISkillSlot4aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			GUISkillSlot5aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			GUISkillSlot1bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			GUISkillSlot2bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			GUISkillSlot3bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			GUISkillSlot4bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			GUISkillSlot5bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			UnlockHeavyAttackProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			UnlockBarrageProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			UnlockUppercutProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 15) {

			UnlockSlamProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 16) {

			UnlockDashProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 17) {

			UnlockGrabProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleConquestMod.addNetworkMessage(MenuAbilityBasicButtonMessage.TYPE, MenuAbilityBasicButtonMessage.STREAM_CODEC, MenuAbilityBasicButtonMessage::handleData);
	}
}
