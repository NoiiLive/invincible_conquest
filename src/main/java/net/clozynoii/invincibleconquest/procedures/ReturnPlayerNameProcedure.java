package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnPlayerNameProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getDisplayName().getString();
	}
}
