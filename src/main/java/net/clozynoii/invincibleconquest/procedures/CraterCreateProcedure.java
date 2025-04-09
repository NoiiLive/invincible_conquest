package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModGameRules;
import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;

import java.util.List;
import java.util.Comparator;

public class CraterCreateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double outputModifier = 0;
		outputModifier = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput / 100;
		entity.getPersistentData().putDouble("xincrease", 0);
		entity.getPersistentData().putDouble("zincrease", 0);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.SMOKE_CIRCLE, 20, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
		if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_DESTRUCTION) == true) {
			int horizontalRadiusSquare = (int) (2 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier) - 1;
			int verticalRadiusSquare = (int) (2 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier) - 1;
			int yIterationsSquare = verticalRadiusSquare;
			for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
				for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
					for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
						// Execute the desired statements within the square/cube
						if (!(world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("invincible_conquest:unbreakable")))) {
							world.levelEvent(2001, BlockPos.containing(x + xi, y + i, z + zi), Block.getId((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)))));
						}
					}
				}
			}
			int horizontalRadiusSphere = (int) (3 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 30) * outputModifier) - 1;
			int verticalRadiusSphere = (int) (3 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 30) * outputModifier) - 1;
			int yIterationsSphere = verticalRadiusSphere;
			for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
				for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
					for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
								+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
						if (distanceSq <= 1.0) {
							if (!(world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("invincible_conquest:unbreakable")))) {
								if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_BLOCK_DROP) == true) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, x + xi, y + i, z + zi, (new ItemStack((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock())));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
								if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_DESTRUCTION) == true) {
									world.setBlock(BlockPos.containing(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
								}
								if (!(InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("")) {
									if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
										if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Earth") && (entity.level().dimension()) == Level.OVERWORLD) {
											InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken = InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken + 1;
											InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
										}
										if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Moon")
												&& (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:moon_world"))) {
											InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken = InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken + 1;
											InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
										}
										if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Mars")
												&& (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:mars_world"))) {
											InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken = InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken + 1;
											InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
										}
										if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Viltrum")
												&& (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:viltrum_world"))) {
											InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken = InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken + 1;
											InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
										}
										if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Talescria")
												&& (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:talescria_world"))) {
											InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken = InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken + 1;
											InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world
					.getEntitiesOfClass(Entity.class,
							new AABB(_center, _center)
									.inflate((6 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 15) * outputModifier) / 2d),
							e -> true)
					.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable")))) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), entity),
								(float) (10 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
										/ (100 / (double) InvincibleConfigConfiguration.STRDAMAGE.get())) * outputModifier));
					}
				}
			}
		}
	}
}
