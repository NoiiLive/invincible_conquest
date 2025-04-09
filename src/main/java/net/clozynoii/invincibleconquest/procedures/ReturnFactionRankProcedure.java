package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnFactionRankProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Rank: " + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank;
	}
}
