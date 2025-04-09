package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnAddPointStaminaProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints > 0 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina < 100) {
			return true;
		}
		return false;
	}
}
