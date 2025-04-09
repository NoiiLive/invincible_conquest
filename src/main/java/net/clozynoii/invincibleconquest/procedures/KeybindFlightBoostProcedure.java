package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

public class KeybindFlightBoostProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double flightSpeed = 0;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFlying == true) {
			if (entity.isSprinting()) {
				if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength >= 25) {
					if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(InvincibleConquestModMobEffects.DESTRUCTIVE_FLIGHT))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.DESTRUCTIVE_FLIGHT, 999999, 0, false, false));
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(InvincibleConquestModMobEffects.DESTRUCTIVE_FLIGHT);
					}
				}
			}
		}
	}
}
