package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.Minecraft;

import net.minecraft.core.registries.BuiltInRegistries; // ✅ NEW NeoForge item registry

import com.mojang.blaze3d.platform.InputConstants;

import java.util.HashMap;

public class AtomEveCreationWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;

		// Check if Enter key (GLFW code 257) is pressed
		if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 257)) {

			// Grab the value from text field "item"
			String rawInput = guistate.containsKey("text:item") ? ((EditBox) guistate.get("text:item")).getValue() : "";

			if (!rawInput.trim().isEmpty()) {
				// Convert "Diamond Sword" → "minecraft:diamond_sword"
				String formatted = rawInput.trim().toLowerCase().replace(" ", "_");
				if (!formatted.contains(":")) {
					formatted = "minecraft:" + formatted;
				}

				// Attempt to parse and fetch the item
				ResourceLocation resLoc = ResourceLocation.tryParse(formatted);
				if (resLoc != null) {
					Item item = BuiltInRegistries.ITEM.get(resLoc);

					if (item != null && item != Items.AIR) {
						ItemStack stack = new ItemStack(item, 1);

						if (entity instanceof ServerPlayer serverPlayer) {
							serverPlayer.getInventory().add(stack);
						}
					} else {
						if (entity instanceof Player player) {
							player.displayClientMessage(Component.literal("Invalid item: " + rawInput), true);
						}
					}
				}

				// Always close GUI after
				if (entity instanceof Player _player)
					_player.closeContainer();
			}
		}
	}
}
