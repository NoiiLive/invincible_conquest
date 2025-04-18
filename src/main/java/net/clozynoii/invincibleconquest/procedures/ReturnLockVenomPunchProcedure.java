package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnLockVenomPunchProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean gate = false;
		if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Venom Punch" + ", ")) {
			return true;
		}
		return false;
	}
}
