package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnShowEXPProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 0) {
			return true;
		}
		return false;
	}
}
