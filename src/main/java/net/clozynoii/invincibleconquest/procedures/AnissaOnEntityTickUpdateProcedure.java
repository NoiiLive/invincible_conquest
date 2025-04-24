package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModEntities;
import net.clozynoii.invincibleconquest.entity.SonicClapEntity;
import net.clozynoii.invincibleconquest.entity.AnissaEntity;

public class AnissaOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).isAlive()) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(InvincibleConquestModMobEffects.CONSTANT_EFFECT_PUNCH) || entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(InvincibleConquestModMobEffects.DRAG)
							|| entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(InvincibleConquestModMobEffects.ANISSA_COMBO)
							|| entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(InvincibleConquestModMobEffects.PAUSE_DIALOGUE))) {
						if (Math.random() < 0.006) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.ANISSA_COMBO, 999999, 0, false, false));
							if (entity instanceof AnissaEntity) {
								((AnissaEntity) entity).setAnimation("anissafullattack");
							}
						}
						if (Math.random() < 0.001) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.DRAG, 30, 0, false, false));
						}
						if (Math.random() < 0.005) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.CONSTANT_EFFECT_PUNCH, 80, 0, false, false));
						}
						if (Math.random() < 0.002) {
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
											AbstractArrow entityToSpawn = new SonicClapEntity(InvincibleConquestModEntities.SONIC_CLAP.get(), level) {
												@Override
												public byte getPierceLevel() {
													return piercing;
												}

												@Override
												protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
													if (knockback > 0) {
														double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
														Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
														if (vec3.lengthSqr() > 0.0) {
															livingEntity.push(vec3.x, 0.1, vec3.z);
														}
													}
												}
											};
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setSilent(true);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 15, 15, (byte) 15);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
							if (entity instanceof AnissaEntity) {
								((AnissaEntity) entity).setAnimation("attack");
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:explode")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:explode")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if (Math.random() < 0.0005) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.PAUSE_DIALOGUE, 40, 0, false, false));
							if (entity instanceof AnissaEntity) {
								((AnissaEntity) entity).setAnimation("idle");
							}
						}
					}
				}
			}
		}
	}
}
