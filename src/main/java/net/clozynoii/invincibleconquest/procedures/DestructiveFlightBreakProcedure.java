package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModGameRules;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModBlocks;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModItems;

import java.util.List;
import java.util.Comparator;

public class DestructiveFlightBreakProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean creativeFlight = false;
		double flightSpeed = 0;
		double outputModifier = 0;
		outputModifier = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput / 100;
		if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_DESTRUCTION) == true) {
			int horizontalRadiusSquare = (int) (2 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 180) * outputModifier) - 1;
			int verticalRadiusSquare = (int) (2 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 180) * outputModifier) - 1;
			int yIterationsSquare = verticalRadiusSquare;
			for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
				for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
					for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
						// Execute the desired statements within the square/cube
						if (!(world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
								(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi)))
								.is(BlockTags.create(ResourceLocation.parse("invincible_conquest:unbreakable")))) {
							world.levelEvent(2001,
									BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
											(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi),
									Block.getId((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
											y + i, (entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi)))));
						}
					}
				}
			}
			if (entity.getLookAngle().y > 0) {
				int horizontalRadiusSphere = (int) (4 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 60) * outputModifier) - 1;
				int verticalRadiusSphere = (int) (4 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 60) * outputModifier) - 1;
				int yIterationsSphere = verticalRadiusSphere;
				for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
					for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
						for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
							double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
									+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
							if (distanceSq <= 1.0) {
								if ((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
										(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi)))
										.is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))) {
									if (Math.random() > 0.75) {
										world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.DIRTY_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
												(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi, 0, 0.05, 0);
									}
								} else if ((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
										(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi))).getBlock() == Blocks.SAND) {
									if (Math.random() > 0.75) {
										world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.SANDY_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
												(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi, 0, 0.05, 0);
									}
								} else if ((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
										(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi))).getBlock() == Blocks.WATER) {
									if (Math.random() > 0.75) {
										world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.STEAM_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
												(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi, 0, 0.05, 0);
									}
								} else if ((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
										(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi))).getBlock() == Blocks.LAVA) {
									if (Math.random() > 0.75) {
										world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.LARGE_EXPLOSION.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
												(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi, 0, 0.05, 0);
									}
								} else if ((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
										(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi))).getBlock() == Blocks.RED_SAND) {
									if (Math.random() > 0.75) {
										world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.RED_SAND_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
												(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi, 0, 0.05, 0);
									}
								} else if ((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
										(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi))).getBlock() == InvincibleConquestModBlocks.MOON_SAND.get()) {
									if (Math.random() > 0.75) {
										world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.STEAM_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
												(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi, 0, 0.05, 0);
									}
								}
								if (!(world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
										(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi)))
										.is(BlockTags.create(ResourceLocation.parse("invincible_conquest:unbreakable")))) {
									if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_BLOCK_DROP) == true) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level,
													(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
													(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi,
													(new ItemStack((world.getBlockState(
															BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
																	(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
																	(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi)))
															.getBlock())));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									}
									if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_DESTRUCTION) == true) {
										world.setBlock(
												BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
														(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
														(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi),
												Blocks.AIR.defaultBlockState(), 3);
									}

								if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_DESTRUCTION) == true) {
									world.setBlock(BlockPos.containing(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
								}
								if (!(InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("")) {
									if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
										if (!(world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi,
										(entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi)))
										.is(BlockTags.create(ResourceLocation.parse("invincible_conquest:natural")))) {
											
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
			} else {
				int horizontalRadiusSphere = (int) (4 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 60) * outputModifier) - 1;
				int verticalRadiusSphere = (int) (4 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 60) * outputModifier) - 1;
				int yIterationsSphere = verticalRadiusSphere;
				for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
					for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
						for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
							double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
									+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
							if (distanceSq <= 1.0) {
								if ((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi)))
										.is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))) {
									if (Math.random() > 0.75) {
										world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.DIRTY_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi, 0, 0.05, 0);
									}
								} else if ((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi))).getBlock() == Blocks.SAND) {
									if (Math.random() > 0.75) {
										world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.SANDY_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi, 0, 0.05, 0);
									}
								} else if ((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi))).getBlock() == Blocks.WATER) {
									if (Math.random() > 0.75) {
										world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.STEAM_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi, 0, 0.05, 0);
									}
								} else if ((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi))).getBlock() == Blocks.LAVA) {
									if (Math.random() > 0.75) {
										world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.LARGE_EXPLOSION.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi, 0, 0.05, 0);
									}
								} else if ((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi))).getBlock() == Blocks.RED_SAND) {
									if (Math.random() > 0.75) {
										world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.RED_SAND_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi, 0, 0.05, 0);
									}
								} else if ((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi))).getBlock() == InvincibleConquestModBlocks.MOON_SAND.get()) {
									if (Math.random() > 0.75) {
										world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.STEAM_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi, 0, 0.05, 0);
									}
								}
								if (!(world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi)))
										.is(BlockTags.create(ResourceLocation.parse("invincible_conquest:unbreakable")))) {
									if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_BLOCK_DROP) == true) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level,
													(entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
													(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi,
													(new ItemStack((world.getBlockState(
															BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
																	(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi)))
															.getBlock())));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									}
									if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_DESTRUCTION) == true) {
										world.setBlock(
												BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
														(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi),
												Blocks.AIR.defaultBlockState(), 3);
									}
									
								if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_DESTRUCTION) == true) {
									world.setBlock(BlockPos.containing(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
								}
								if (!(InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("")) {
									if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
										
									if (!(world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + xi, y + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 100) * outputModifier)) + zi)))
										.is(BlockTags.create(ResourceLocation.parse("invincible_conquest:natural")))) {
											
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
			}
		}
		if (entity.getPersistentData().getDouble("flyParticle") > 0) {
			entity.getPersistentData().putDouble("flyParticle", (entity.getPersistentData().getDouble("flyParticle") - 1));
		} else if (entity.getPersistentData().getDouble("flyParticle") == 0) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0);
			entity.getPersistentData().putDouble("flyParticle", 20);
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable")))) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), entity),
								(float) (3 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100) * outputModifier));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.BLEEDING, 20, 0));
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world
					.getEntitiesOfClass(Entity.class,
							new AABB(_center, _center)
									.inflate((4 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 25) * outputModifier) / 2d),
							e -> true)
					.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable")))) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), entity),
								(float) (1 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100) * outputModifier));
					}
				}
			}
		}
	}
}
