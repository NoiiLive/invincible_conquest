package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.entity.TheHammerEntity;

public class TheHammerSpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TheHammerEntity) {
			((TheHammerEntity) entity).setAnimation("beam");
		}
	}
}
