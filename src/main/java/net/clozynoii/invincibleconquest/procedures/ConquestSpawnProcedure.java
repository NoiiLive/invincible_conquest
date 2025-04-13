package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class ConquestSpawnProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z))) {
			return false;
		}
		if (!world.getEntitiesOfClass(ConquestEntity.class, AABB.ofSize(new Vec3(x, y, z), 250, 250, 250), e -> true).isEmpty()) {
			return false;
		}
		return true;
	}
}
