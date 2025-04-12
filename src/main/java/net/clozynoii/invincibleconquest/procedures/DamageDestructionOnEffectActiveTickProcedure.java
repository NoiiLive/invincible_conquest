package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

public class DamageDestructionOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("pointdestimer", (entity.getPersistentData().getDouble("pointdestimer") + 1));
		if (entity.getPersistentData().getDouble("pointdestimer") >= 10) {
			int horizontalRadiusSphere = (int) 3 - 1;
			int verticalRadiusSphere = (int) 3 - 1;
			int yIterationsSphere = verticalRadiusSphere;
			for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
				for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
					for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
								+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
						if (distanceSq <= 1.0) {
							if (!(world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("invincible_conquest:unbreakable")))) {
								if (world instanceof ServerLevel _level)
									FallingBlockEntity.fall(_level, BlockPos.containing(x + xi, y + i, z + zi), (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))));
								entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.EXPLOSION)), 6);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.EXPLOSION, x + xi, y + i, z + zi, 1, 0.1, 0.1, 0.1, 0);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + xi, y + i, z + zi, 3, 0.1, 0.1, 0.1, 0.2);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.POOF, x + xi, y + i, z + zi, 5, 0.1, 0.1, 0.1, 0.1);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.PLAYERS, (float) 0.06, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.PLAYERS, (float) 0.06, 1, false);
									}
								}
								world.destroyBlock(BlockPos.containing(x + xi, y + i, z + zi), false);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 2, false, false));
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.FALLING_BLOCKS, 2, 0, false, false));
								if (entity instanceof LivingEntity _entity)
									_entity.removeEffect(InvincibleConquestModMobEffects.DAMAGE_DESTRUCTION);
							}
						}
					}
				}
			}
		}
	}
}
