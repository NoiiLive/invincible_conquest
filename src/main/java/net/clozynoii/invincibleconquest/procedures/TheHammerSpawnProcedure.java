package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class TheHammerSpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TheHammerEntity) {
			((TheHammerEntity) entity).setAnimation("beam");
		}
	}
}
