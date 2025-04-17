package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class StrongPunchMobKnockbackProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		magnitude = Math.sqrt(sourceentity.getLookAngle().x * sourceentity.getLookAngle().x + sourceentity.getLookAngle().y * sourceentity.getLookAngle().y + sourceentity.getLookAngle().z * sourceentity.getLookAngle().z);
		vecX = sourceentity.getLookAngle().x / magnitude;
		vecY = sourceentity.getLookAngle().y / magnitude;
		vecZ = sourceentity.getLookAngle().z / magnitude;
		vecX = vecX * (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 10);
		vecY = vecY * (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 10);
		vecZ = vecZ * (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 10);
		entity.push(vecX, vecY, vecZ);
	}
}
