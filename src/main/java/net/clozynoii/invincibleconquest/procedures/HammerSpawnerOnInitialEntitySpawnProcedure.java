package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class HammerSpawnerOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("hammerspawnertimer", 200);
		InvincibleConquestMod.queueServerWork(200, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleConquestModEntities.THE_HAMMER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
		});
	}
}
