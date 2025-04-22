package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.entity.FireworkMobEntity;

import java.util.List;
import java.util.Comparator;

public class FireworkMobOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.push(0, 0.2, 0);
		if ((entity instanceof FireworkMobEntity _datEntI ? _datEntI.getEntityData().get(FireworkMobEntity.DATA_Despawn) : 0) > 0) {
			if (entity instanceof FireworkMobEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FireworkMobEntity.DATA_Despawn, (int) ((entity instanceof FireworkMobEntity _datEntI ? _datEntI.getEntityData().get(FireworkMobEntity.DATA_Despawn) : 0) - 1));
		}
		if ((entity instanceof FireworkMobEntity _datEntI ? _datEntI.getEntityData().get(FireworkMobEntity.DATA_Despawn) : 0) == 0) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.MOB);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.EXPLOSION.get()), x, y, z, 50, 2, 2, 2, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.LARGE_EXPLOSION.get()), x, y, z, 20, 3, 2, 3, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get()), x, y, z, 1, 1, 1, 1, 0);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
						if (!(entityiterator == entity)) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_EXPLOSION)), 20);
						}
					}
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 2, 0.1, 0.1, 0.1, 0);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
					if (!(entityiterator == entity)) {
						if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable")))) {
							entityiterator.push(0, 0.3, 0);
						}
					}
				}
			}
		}
	}
}
