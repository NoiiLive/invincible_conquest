package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnCooldownOverlay4Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 1) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown4a > 0) {
				return true;
			}
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown4b > 0) {
				return true;
			}
		}
		return false;
	}
}
