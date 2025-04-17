package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class BeastSlicesOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		entity.getPersistentData().putDouble("beastslicetimer", (entity.getPersistentData().getDouble("beastslicetimer") + 1));
		if (entity.getPersistentData().getDouble("beastslicetimer") >= 15) {
			entity.getPersistentData().putDouble("beastslicetimer", 0);
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
			vecX = entity.getLookAngle().x / magnitude;
			vecY = entity.getLookAngle().y / magnitude;
			vecZ = entity.getLookAngle().z / magnitude;
			vecX = vecX * 1.5;
			vecY = vecY * 1.5;
			vecZ = vecZ * 1.5;
			entity.push(vecX, vecY, vecZ);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, (y + 0.1), z, 5, 0.1, 0.1, 0.1, 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CRIT, x, y, z, 3, 1, 1, 1, 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SWEEP_ATTACK, x, (y + 1), z, 10, 1, 1, 1, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), entity), (float) (9 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 15));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:blood_explosion")),
										SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:blood_explosion")), SoundSource.NEUTRAL, 1,
										1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SWEEP_ATTACK, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 2, 1, 1, 1, 0);
						world.levelEvent(2001, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Block.getId(Blocks.REDSTONE_BLOCK.defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), 15, 0.3, 0.1, 0.3, 0.2);
					}
				}
			}
		}
	}
}
