package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnHasAbilityProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("None") && !(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Human")) {
			return true;
		}
		return false;
	}
}
