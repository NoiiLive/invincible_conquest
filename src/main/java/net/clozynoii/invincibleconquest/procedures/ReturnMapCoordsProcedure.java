package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnMapCoordsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Current Coords: " + "x" + new java.text.DecimalFormat("##").format(entity.getX()) + ", z" + new java.text.DecimalFormat("##").format(entity.getZ());
	}
}
