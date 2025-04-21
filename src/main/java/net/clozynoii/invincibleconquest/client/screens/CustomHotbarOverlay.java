
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

import net.clozynoii.invincibleconquest.procedures.ReturnSpriteStaminaProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSpriteHealthProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnShowStaminaProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnShowHealthProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnPlayerAbilityIconProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnOxygenValueProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnHungerValueProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnArmorValueProcedure;
import net.clozynoii.invincibleconquest.procedures.HideOverlayF1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class CustomHotbarOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
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
			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/overlay_hotbar.png"), -5, 1, 0, 0, 148, 44, 148, 44);

			if (ReturnShowHealthProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/sprite_health.png"), -5, 1, Mth.clamp((int) ReturnSpriteHealthProcedure.execute(entity) * 148, 0, 1332), 0, 148, 44, 1480, 44);
			}
			if (ReturnShowStaminaProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/sprite_stamina.png"), -5, 1, Mth.clamp((int) ReturnSpriteStaminaProcedure.execute(entity) * 148, 0, 1184), 0, 148, 44, 1332, 44);
			}

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/icons_sprite.png"), 12, 12, Mth.clamp((int) ReturnPlayerAbilityIconProcedure.execute(entity) * 16, 0, 176), 0, 16, 16, 192, 16);

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnArmorValueProcedure.execute(entity), 50, 30, -10066330, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnArmorValueProcedure.execute(entity), 49, 29, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnHungerValueProcedure.execute(entity), 75, 30, -10066330, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnHungerValueProcedure.execute(entity), 74, 29, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnOxygenValueProcedure.execute(entity), 100, 30, -10066330, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnOxygenValueProcedure.execute(entity), 99, 29, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
