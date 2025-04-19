package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnNameDesertProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList.contains("Desert" + ", ")) {
			return "Desert Wasteland";
		}
		return "Unknown";
	}
}
