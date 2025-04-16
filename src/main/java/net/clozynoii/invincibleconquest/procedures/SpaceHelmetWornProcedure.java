package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

public class SpaceHelmetWornProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setAirSupply(entity.getAirSupply());
	}
}
