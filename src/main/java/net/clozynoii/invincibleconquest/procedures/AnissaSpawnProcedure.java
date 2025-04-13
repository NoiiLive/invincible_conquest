package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.entity.AnissaEntity;

public class AnissaSpawnProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z))) {
			return false;
		}
		if (!world.getEntitiesOfClass(AnissaEntity.class, AABB.ofSize(new Vec3(x, y, z), 250, 250, 250), e -> true).isEmpty()) {
			return false;
		}
		return true;
	}
}
