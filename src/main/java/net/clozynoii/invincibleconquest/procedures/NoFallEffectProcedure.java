package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

public class NoFallEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.fallDistance = 0;
	}
}
