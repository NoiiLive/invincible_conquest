package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnNameSnowProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList.contains("Snow" + ", ")) {
			return "Ice Age Dimension";
		}
		return "Unknown";
	}
}
