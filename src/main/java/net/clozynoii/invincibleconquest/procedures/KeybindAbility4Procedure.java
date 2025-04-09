package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

public class KeybindAbility4Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld == false) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.KeyHeld = true;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld == true) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.KeyHeld = false;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(InvincibleConquestModMobEffects.STUN))) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 1) {
				UseAbilitySlot4aProcedure.execute(world, x, y, z, entity);
			} else if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
				UseAbilitySlot4bProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
