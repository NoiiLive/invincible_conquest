package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnAbilityTabNameProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility + " Abilities";
	}
}
