package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnNamePreHistoricProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList.contains("Pre Historic" + ", ")) {
			return "Pre Historic";
		}
		return "Unknown";
	}
}
