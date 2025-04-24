package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.InvincibleConquestMod;

public class AtomBeamOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		InvincibleConquestMod.queueServerWork(50, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
