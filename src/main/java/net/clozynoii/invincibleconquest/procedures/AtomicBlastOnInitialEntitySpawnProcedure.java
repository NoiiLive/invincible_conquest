package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class AtomicBlastOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		InvincibleConquestMod.queueServerWork(100, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
