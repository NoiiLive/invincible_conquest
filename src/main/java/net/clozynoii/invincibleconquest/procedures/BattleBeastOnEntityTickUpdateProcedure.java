package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.entity.BattleBeastEntity;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import java.util.List;
import java.util.Comparator;

public class BattleBeastOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).isAlive()) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (Math.random() < 0.01) {
						if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(InvincibleConquestModMobEffects.BEAST_SLICES)
								|| entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(InvincibleConquestModMobEffects.BEAST_MOB_TIMERS))) {
							entity.push(0, 2, 0);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 25, 1, 1, 1, 0);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, x, y, z, 5, 1, 1, 1, 0.2);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							InvincibleConquestMod.queueServerWork(5, () -> {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.ACTIVE_AIR_SLAM_CLAW, 25, 0, false, false));
							});
							InvincibleConquestMod.queueServerWork(15, () -> {
								entity.push(0, (-3), 0);
							});
						}
					}
					if (Math.random() < 0.01) {
						if (!(entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(InvincibleConquestModMobEffects.BEAST_MOB_TIMERS))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.BEAST_SLICES, 40, 0, false, false));
						}
					}
					if (Math.random() < 0.01) {
						if (!(entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(InvincibleConquestModMobEffects.BEAST_SLICES))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.BEAST_MOB_TIMERS, 50, 0, false, false));
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get()), x, (y + 1), z, 15, 0.1, 0.1, 0.1, 0);
							if (entity instanceof BattleBeastEntity) {
								((BattleBeastEntity) entity).setAnimation("attack");
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entity == entityiterator)) {
										entityiterator.push(0, 2, 0);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")),
														SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL,
														1, 1, false);
											}
										}
										entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
										entityiterator.getPersistentData().putBoolean("beasttarget", true);
									}
								}
							}
						}
					}
					if (Math.random() < 0.01) {
						if (!(entity instanceof LivingEntity _livEnt34 && _livEnt34.hasEffect(InvincibleConquestModMobEffects.BEAST_MOB_TIMERS))
								|| !(entity instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(InvincibleConquestModMobEffects.BEAST_SLICES))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.DRAG, 50, 0, false, false));
						}
					}
				}
			}
		}
	}
}
