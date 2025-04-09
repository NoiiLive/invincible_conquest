package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class PlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double outputModifier = 0;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).InputDelay > 0) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.InputDelay = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).InputDelay - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina > entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.PlayerCurrentStamina = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina < 0) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.PlayerCurrentStamina = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP >= entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.PlayerEXP = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP - entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap;
				_vars.syncPlayerVariables(entity);
			}
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.PlayerLevel = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerLevel + 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.PlayerSkillPoints = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints + (double) InvincibleConfigConfiguration.LEVELSP.get();
				_vars.syncPlayerVariables(entity);
			}
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.PlayerEXPCap = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap + (double) InvincibleConfigConfiguration.LEVELEXP.get();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Level Up " + new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerLevel - 1) + " > "
						+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerLevel))), true);
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAge - 18 > (double) InvincibleConfigConfiguration.VILTRUMITEMAXBONUS.get()) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.AgeBoost = (double) InvincibleConfigConfiguration.VILTRUMITEMAXBONUS.get();
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.AgeBoost = (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAge - 18) * (double) InvincibleConfigConfiguration.VILTRUMITEBOOST.get();
					_vars.syncPlayerVariables(entity);
				}
			}
		} else {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.AgeBoost = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).ChangingOutput == true) {
			if (entity.getPersistentData().getDouble("outputChange") > 0) {
				entity.getPersistentData().putDouble("outputChange", (entity.getPersistentData().getDouble("outputChange") - 1));
			} else if (entity.getPersistentData().getDouble("outputChange") == 0) {
				entity.getPersistentData().putDouble("outputChange", 5);
				if (entity.isShiftKeyDown()) {
					if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput > 0) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.PlayerOutput = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput - 10;
							_vars.syncPlayerVariables(entity);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Output > " + new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput))), true);
					}
				} else {
					if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput < 100) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.PlayerOutput = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput + 10;
							_vars.syncPlayerVariables(entity);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Output > " + new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput))), true);
					}
				}
			}
		}
		if (entity.isAlive()) {
			outputModifier = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput / 100;
			if (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
				_livingEntity16.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((1
						+ ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / (100 / (double) InvincibleConfigConfiguration.STRDAMAGE.get()))
								* outputModifier));
			if (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
				_livingEntity18.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(
						(((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / (100 / (double) InvincibleConfigConfiguration.STRKNOCKBACK.get()))
								* outputModifier));
			if (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.ARMOR))
				_livingEntity20.getAttribute(Attributes.ARMOR).setBaseValue(Math.round((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
						/ (100 / (double) InvincibleConfigConfiguration.DURDMGRESISTANCE.get())));
			if (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS))
				_livingEntity22.getAttribute(Attributes.ARMOR_TOUGHNESS)
						.setBaseValue(Math.round((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
								/ (100 / (double) InvincibleConfigConfiguration.DURDMGRESISTANCE.get())));
			if (entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
				_livingEntity24.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue((((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
						/ (100 / (double) InvincibleConfigConfiguration.DURKBRESISTANCE.get())) * outputModifier));
			if (entity instanceof LivingEntity _livingEntity26 && _livingEntity26.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
				_livingEntity26.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((0.1 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAgility + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
						/ (100 / (double) InvincibleConfigConfiguration.AGLMOVEMENTSPEED.get())) * outputModifier));
			if (entity instanceof LivingEntity _livingEntity28 && _livingEntity28.getAttributes().hasAttribute(NeoForgeMod.SWIM_SPEED))
				_livingEntity28.getAttribute(NeoForgeMod.SWIM_SPEED).setBaseValue((1 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAgility + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
						/ (100 / (double) InvincibleConfigConfiguration.AGLMOVEMENTSPEED.get())) * 2 * outputModifier));
			if (entity instanceof LivingEntity _livingEntity30 && _livingEntity30.getAttributes().hasAttribute(Attributes.SAFE_FALL_DISTANCE))
				_livingEntity30.getAttribute(Attributes.SAFE_FALL_DISTANCE).setBaseValue((3 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAgility + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
						/ (100 / (double) InvincibleConfigConfiguration.AGLMOVEMENTSPEED.get())) * 10));
			if (entity instanceof LivingEntity _livingEntity32 && _livingEntity32.getAttributes().hasAttribute(Attributes.ATTACK_SPEED))
				_livingEntity32.getAttribute(Attributes.ATTACK_SPEED).setBaseValue((4 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAgility + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
						/ (100 / (double) InvincibleConfigConfiguration.AGLATTACKSPEED.get())) * outputModifier));
			if (entity instanceof LivingEntity _livingEntity34 && _livingEntity34.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity34.getAttribute(Attributes.MAX_HEALTH)
						.setBaseValue((20 + Math.round((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerVitality + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
								/ (100 / (double) InvincibleConfigConfiguration.VITHEALTHBOOST.get()))));
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20, 0, false, false));
			}
			if (Math.round((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
					/ (100 / (double) InvincibleConfigConfiguration.DURDMGRESISTANCE.get())) >= 2) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 2, false, false));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20,
							(int) Math.round((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
									/ (100 / (double) InvincibleConfigConfiguration.DURDMGRESISTANCE.get())),
							false, false));
			}
		}
		if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("None")) {
			if (!InvincibleConquestModVariables.MapVariables.get(world).FactionIndex.contains(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction)) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFaction = "None";
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "None";
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerReputation = 0;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Faction not found or disbanded!"), true);
			}
		}
		if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).GrabbedEntity).equals("")) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getStringUUID()).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).GrabbedEntity)) {
						if (entityiterator.isAlive()) {
							if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFlying == true && entity.isSprinting()) {
								if (entity instanceof LivingEntity _livEnt44 && _livEnt44.hasEffect(InvincibleConquestModMobEffects.DESTRUCTIVE_FLIGHT)) {
									{
										Entity _ent = entityiterator;
										_ent.teleportTo(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport(
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.getY()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()),
													_ent.getYRot(), _ent.getXRot());
									}
								} else {
									{
										Entity _ent = entityiterator;
										_ent.teleportTo(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(9)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(9)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport(
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(9)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.getY()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(9)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()),
													_ent.getYRot(), _ent.getXRot());
									}
								}
							} else {
								{
									Entity _ent = entityiterator;
									_ent.teleportTo(
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getX()),
											(entity.getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getZ()));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()),
												_ent.getYRot(), _ent.getXRot());
								}
							}
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("Grabbing " + entityiterator.getDisplayName().getString())), true);
						} else {
							{
								InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
								_vars.GrabbedEntity = "";
								_vars.syncPlayerVariables(entity);
							}
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("No longer grabbing entity"), true);
						}
					}
				}
			}
		}
	}
}
