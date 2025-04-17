package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class LaserKnockbackOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("laserknockback", (entity.getPersistentData().getDouble("laserknockback") + 3));
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("laserknockback")) / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					entityiterator.setDeltaMovement(new Vec3(((entity.getX() + entityiterator.getX()) / 5), ((entity.getY() + entityiterator.getY()) / 4), ((entity.getZ() + entityiterator.getZ()) / 5)));
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_SMALL.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1, 2, 2, 2, 0);
				}
			}
		}
	}
}
