
package net.clozynoii.invincibleconquest.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.procedures.ReturnBarSlot5Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnBarSlot4Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnBarSlot3Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnBarSlot2Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnBarSlot1Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAbilityBar2Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAbilityBar1Procedure;
import net.clozynoii.invincibleconquest.procedures.HideOverlayF1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class AbilityOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
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
			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_bar.png"), 8, h - 34, 0, 0, 110, 26, 110, 26);

			if (ReturnAbilityBar1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_bar_selected.png"), 108, h - 30, 0, 0, 7, 10, 7, 10);
			}
			if (ReturnAbilityBar2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_bar_selected.png"), 108, h - 22, 0, 0, 7, 10, 7, 10);
			}

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), 13, h - 29, Mth.clamp((int) ReturnBarSlot1Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), 31, h - 29, Mth.clamp((int) ReturnBarSlot2Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), 49, h - 29, Mth.clamp((int) ReturnBarSlot3Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), 67, h - 29, Mth.clamp((int) ReturnBarSlot4Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), 85, h - 29, Mth.clamp((int) ReturnBarSlot5Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
