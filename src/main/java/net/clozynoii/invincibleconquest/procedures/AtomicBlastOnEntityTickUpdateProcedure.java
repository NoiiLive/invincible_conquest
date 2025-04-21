package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.entity.AtomicBlastEntity;

import java.util.List;
import java.util.Comparator;

public class AtomicBlastOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			int horizontalRadiusSphere = (int) (3 + (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 5) - 1;
			int verticalRadiusSphere = (int) (3 + (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 5) - 1;
			int yIterationsSphere = verticalRadiusSphere;
			for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
				for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
					for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
								+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
						if (distanceSq <= 1.0) {
							if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("invincible_conquest:unbreakable")))) {
								if (world instanceof ServerLevel _level)
									FallingBlockEntity.fall(_level, BlockPos.containing(x + xi, y + i, z + zi), (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof AtomicBlastEntity)) {
						if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == entityiterator)) {
							if (entityiterator instanceof LivingEntity) {
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)),
										(float) (7 + (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 5));
								if (!entity.level().isClientSide())
									entity.discard();
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.PINK_SMOKE.get()), (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), 5, 0.1, 0.1, 0.1, 0.2);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.EXPLOSION, (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), 3, 0.1, 0.1, 0.1, 0);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						}
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.PINK_BURST_CIRCLE.get()), x, (y + 1), z, 1, 0.1, 0.1, 0.1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, y, z, 15, 2, 2, 2, 0.2);
			magnitude = Math.sqrt((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().x * (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().x
					+ (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().y * (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().y
					+ (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().z * (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().z);
			vecX = (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().x / magnitude;
			vecY = (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().y / magnitude;
			vecZ = (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().z / magnitude;
			vecX = vecX * 1;
			vecY = vecY * 1;
			vecZ = vecZ * 1;
			entity.push(vecX, vecY, vecZ);
			{
				Entity _ent = entity;
				_ent.setYRot((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getYRot());
				_ent.setXRot((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getXRot());
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle dust 0.95 0.67 0.98 5 ~ ~ ~ 3 3 3 0 25");
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.FALLING_BLOCKS, 5, 0, false, false));
		}
	}
}
