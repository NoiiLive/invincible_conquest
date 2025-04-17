package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class SpaceHelmetWornProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setAirSupply(entity.getAirSupply());
	}
}
