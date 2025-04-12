package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class HardStunOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(0, 0, 0));
	}
}
