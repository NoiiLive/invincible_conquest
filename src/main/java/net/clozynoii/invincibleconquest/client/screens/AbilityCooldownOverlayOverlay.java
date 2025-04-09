
package net.clozynoii.invincibleconquest.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.procedures.ReturnCooldownOverlay5Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnCooldownOverlay4Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnCooldownOverlay3Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnCooldownOverlay2Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnCooldownOverlay1Procedure;
import net.clozynoii.invincibleconquest.procedures.HideOverlayF1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class AbilityCooldownOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.LOW)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (HideOverlayF1Procedure.execute()) {
			if (ReturnCooldownOverlay1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_cooldown.png"), 13, h - 29, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldownOverlay2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_cooldown.png"), 31, h - 29, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldownOverlay3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_cooldown.png"), 49, h - 29, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldownOverlay4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_cooldown.png"), 67, h - 29, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldownOverlay5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_cooldown.png"), 85, h - 29, 0, 0, 16, 16, 16, 16);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
