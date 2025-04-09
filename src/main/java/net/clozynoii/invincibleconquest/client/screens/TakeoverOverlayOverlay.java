
package net.clozynoii.invincibleconquest.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.procedures.ShowTakeoverBarProcedure;
import net.clozynoii.invincibleconquest.procedures.ShowHostileGoalsProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnTakeoverScoreProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnHostileTimeProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnHostileKillsProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnHostileBreakProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnFactionBattleProcedure;

@EventBusSubscriber({Dist.CLIENT})
public class TakeoverOverlayOverlay {
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
		if (ShowTakeoverBarProcedure.execute(world, entity)) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnTakeoverScoreProcedure.execute(world), 6, 58, -10066330, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnTakeoverScoreProcedure.execute(world), 5, 57, -1, false);
			if (ShowHostileGoalsProcedure.execute(world, entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnHostileKillsProcedure.execute(world), 6, 73, -10066330, false);
			if (ShowHostileGoalsProcedure.execute(world, entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnHostileKillsProcedure.execute(world), 5, 72, -1, false);
			if (ShowHostileGoalsProcedure.execute(world, entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnHostileBreakProcedure.execute(world), 6, 88, -10066330, false);
			if (ShowHostileGoalsProcedure.execute(world, entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnHostileBreakProcedure.execute(world), 5, 87, -1, false);
			if (ShowHostileGoalsProcedure.execute(world, entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnHostileTimeProcedure.execute(world), 6, 103, -10066330, false);
			if (ShowHostileGoalsProcedure.execute(world, entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnHostileTimeProcedure.execute(world), 5, 102, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnFactionBattleProcedure.execute(world), 6, 43, -10066330, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnFactionBattleProcedure.execute(world), 5, 42, -1, false);
		}
	}
}
