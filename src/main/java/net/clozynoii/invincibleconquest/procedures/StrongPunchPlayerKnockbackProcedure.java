package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class StrongPunchPlayerKnockbackProcedure {
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
		vecX = vecX * (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength - entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability);
		vecY = vecY * (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength - entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability);
		vecZ = vecZ * (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength - entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability);
		entity.push(vecX, vecY, vecZ);
		if (sourceentity.getXRot() >= 70) {
			magnitude = Math.sqrt(sourceentity.getLookAngle().x * sourceentity.getLookAngle().x + sourceentity.getLookAngle().y * sourceentity.getLookAngle().y + sourceentity.getLookAngle().z * sourceentity.getLookAngle().z);
			vecX = sourceentity.getLookAngle().x / magnitude;
			vecY = sourceentity.getLookAngle().y / magnitude;
			vecZ = sourceentity.getLookAngle().z / magnitude;
			vecX = vecX * 0;
			vecY = vecY * sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength;
			vecZ = vecZ * 0;
			entity.push(0, ((-2) - entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 20), 0);
		} else if (sourceentity.getXRot() == -90) {
			magnitude = Math.sqrt(sourceentity.getLookAngle().x * sourceentity.getLookAngle().x + sourceentity.getLookAngle().y * sourceentity.getLookAngle().y + sourceentity.getLookAngle().z * sourceentity.getLookAngle().z);
			vecX = sourceentity.getLookAngle().x / magnitude;
			vecY = sourceentity.getLookAngle().y / magnitude;
			vecZ = sourceentity.getLookAngle().z / magnitude;
			vecX = vecX * 0;
			vecY = vecY * 2;
			vecZ = vecZ * 0;
			entity.push(vecX, ((2 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 20) - entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability / 10), vecZ);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.CRATER, 40, 0, false, false));
		}
	}
}
