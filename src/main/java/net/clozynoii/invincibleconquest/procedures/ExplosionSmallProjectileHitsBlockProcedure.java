package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class ExplosionSmallProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable")))) {
						entityiterator.invulnerableTime = 0;
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_EXPLOSION), entity), 15);
					}
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.EXPLOSION.get()), x, y, z, 15, 0.5, 0.5, 0.5, 0);
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 2, Level.ExplosionInteraction.MOB);
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
