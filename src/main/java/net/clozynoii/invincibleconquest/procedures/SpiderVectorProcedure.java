package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

public class SpiderVectorProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double mag = 0;
		double deltaz = 0;
		double deltax = 0;
		double deltay = 0;
		double dampen = 0;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Spider")) {
			deltax = (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(45)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() - x
					+ entity.getPersistentData().getDouble("SwingBlockX") - x) / 2;
			deltay = (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(45)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - y
					+ entity.getPersistentData().getDouble("SwingBlockY") - y) / 2;
			deltaz = (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(45)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() - z
					+ entity.getPersistentData().getDouble("SwingBlockZ") - z) / 2;
			mag = Math.sqrt(deltax * deltax + deltay * deltay + deltaz * deltaz);
			dampen = Math.sqrt(mag) * 1.6;
			entity.setDeltaMovement(new Vec3((deltax / dampen), (deltay / dampen + 0.4), (deltaz / dampen)));
			entity.fallDistance = 0;
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.NO_FALL, 5, 0, false, false));
		}
	}
}
