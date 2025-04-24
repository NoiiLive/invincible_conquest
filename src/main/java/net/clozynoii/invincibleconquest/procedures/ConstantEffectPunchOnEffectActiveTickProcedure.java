package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.entity.ViltrumiteMaleEntity;
import net.clozynoii.invincibleconquest.entity.ViltrumiteFemaleEntity;
import net.clozynoii.invincibleconquest.entity.OmnivincibleEntity;
import net.clozynoii.invincibleconquest.entity.OmniManEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleVeilEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleSinisterEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleMohawkEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleDarkEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleBlueEntity;
import net.clozynoii.invincibleconquest.entity.BattleBeastEntity;
import net.clozynoii.invincibleconquest.entity.AnissaEntity;

import java.util.List;
import java.util.Comparator;

public class ConstantEffectPunchOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			entity.getPersistentData().putDouble("vilpunches", (entity.getPersistentData().getDouble("vilpunches") + 1));
			if (entity.getPersistentData().getDouble("vilpunches") >= 10) {
				{
					Entity _ent = entity;
					_ent.teleportTo(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
								((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), _ent.getYRot(), _ent.getXRot());
				}
				if (entity instanceof InvincibleEntity) {
					if (entity instanceof InvincibleEntity) {
						((InvincibleEntity) entity).setAnimation("attack");
					}
				} else if (entity instanceof BattleBeastEntity) {
					if (entity instanceof BattleBeastEntity) {
						((BattleBeastEntity) entity).setAnimation("attack");
					}
				} else if (entity instanceof OmniManEntity) {
					if (entity instanceof OmniManEntity) {
						((OmniManEntity) entity).setAnimation("attack");
					}
				} else if (entity instanceof ViltrumiteMaleEntity) {
					if (entity instanceof ViltrumiteMaleEntity) {
						((ViltrumiteMaleEntity) entity).setAnimation("attack");
					}
				} else if (entity instanceof ViltrumiteFemaleEntity) {
					if (entity instanceof ViltrumiteFemaleEntity) {
						((ViltrumiteFemaleEntity) entity).setAnimation("attack");
					}
				} else if (entity instanceof InvincibleBlueEntity) {
					if (entity instanceof InvincibleBlueEntity) {
						((InvincibleBlueEntity) entity).setAnimation("attack");
					}
				} else if (entity instanceof InvincibleMohawkEntity) {
					if (entity instanceof InvincibleMohawkEntity) {
						((InvincibleMohawkEntity) entity).setAnimation("attack");
					}
				} else if (entity instanceof InvincibleSinisterEntity) {
					if (entity instanceof InvincibleSinisterEntity) {
						((InvincibleSinisterEntity) entity).setAnimation("attack");
					}
				} else if (entity instanceof InvincibleDarkEntity) {
					if (entity instanceof InvincibleDarkEntity) {
						((InvincibleDarkEntity) entity).setAnimation("attack");
					}
				} else if (entity instanceof InvincibleVeilEntity) {
					if (entity instanceof InvincibleVeilEntity) {
						((InvincibleVeilEntity) entity).setAnimation("attack");
					}
				} else if (entity instanceof OmnivincibleEntity) {
					if (entity instanceof OmnivincibleEntity) {
						((OmnivincibleEntity) entity).setAnimation("attack");
					}
				} else if (entity instanceof AnissaEntity) {
					if (entity instanceof AnissaEntity) {
						((AnissaEntity) entity).setAnimation("attack");
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.DAMAGE_DESTRUCTION, 50, 0));
							world.levelEvent(2001, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Block.getId(Blocks.REDSTONE_BLOCK.defaultBlockState()));
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 15);
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get()), (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), 1, 0.1, 0.1, 0.1, 0);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")),
											SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1,
											false);
								}
							}
							magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
							vecX = entity.getLookAngle().x / magnitude;
							vecY = entity.getLookAngle().y / magnitude;
							vecZ = entity.getLookAngle().z / magnitude;
							vecX = vecX * 5;
							vecY = vecY * 3;
							vecZ = vecZ * 5;
							entityiterator.push(vecX, 2, vecZ);
						}
					}
				}
				entity.getPersistentData().putDouble("vilpunches", 0);
			}
		}
	}
}
