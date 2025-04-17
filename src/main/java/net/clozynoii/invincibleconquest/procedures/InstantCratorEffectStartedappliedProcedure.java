package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

import java.util.List;
import java.util.Comparator;

public class InstantCratorEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		int horizontalRadiusHemiBot = (int) (4 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 20) - 1;
		int verticalRadiusHemiBot = (int) (4 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 20);
		int yIterationsHemiBot = verticalRadiusHemiBot;
		for (int i = -yIterationsHemiBot; i <= 0; i++) {
			if (i == -verticalRadiusHemiBot) {
				continue;
			}
			for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
				for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
							+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
					if (distanceSq <= 1.0) {
						if (!(world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("invincible_conquest:unbreakable")))) {
							world.destroyBlock(BlockPos.containing(x + xi, y + i, z + zi), false);
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.IMPACT_FRAME_EFFECT, 3, 0, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.SMOKE_CIRCLE, 20, 0, false, false));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((15 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 10) / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.EXPLOSION), entity), (float) (25 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 10));
				}
			}
		}
	}
}
