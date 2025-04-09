package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnOxygenValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format(entity.getAirSupply() / 15);
	}
}
