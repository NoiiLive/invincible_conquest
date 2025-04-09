package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class BarrageTickProcedure {
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
		boolean single = false;
		boolean gate = false;
		double targets = 0;
		double cooldown = 0;
		double reduction = 0;
		double outputModifier = 0;
		double vecZ = 0;
		double vecX = 0;
		double magnitude = 0;
		String ability = "";
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld == true && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Barraging == true) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.Barraging = true;
				_vars.syncPlayerVariables(entity);
			}
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.InputDelay = 99999;
				_vars.syncPlayerVariables(entity);
			}
			outputModifier = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput / 100;
			if (entity instanceof Player _plr0)
				_plr0.resetAttackStrengthTicker();
			if (InvincibleConquestModVariables.WorldVariables.get(world).BarrageCooldown == 0) {
				targets = 0;
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.Barraging = true;
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.InputDelay = 99999;
					_vars.syncPlayerVariables(entity);
				}
				gate = false;
				single = false;
				if (world.isClientSide()) {
					SetupAnimationsProcedure.setAnimationClientside((Player) entity, "barrage", false);
				}
				if (!world.isClientSide()) {
					if (entity instanceof Player)
						PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("barrage", entity.getId(), false));
				}
				if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength * outputModifier >= 50) {
					world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_SMALL.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 0, 0, 0);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("playsound minecraft:entity.generic.explode player " + "@a" + " ~ ~ ~ 0.5 1"));
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle invincible_conquest:circle_barrage ^ ^1.5 ^1.5 0.01 0.01 0.01 0 1 force");
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("playsound invincible_conquest:whoosh player " + "@a" + " ~ ~ ~ 1 1"));
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getX()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getZ()));
					List<Entity> _entfound = world
							.getEntitiesOfClass(Entity.class,
									new AABB(_center, _center).inflate(
											(4 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 50) * outputModifier) / 2d),
									e -> true)
							.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)
								&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable")))) {
							if (gate == false) {
								entityiterator.invulnerableTime = 0;
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), entity),
										(float) (2 + (((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
												/ (100 / (double) InvincibleConfigConfiguration.STRDAMAGE.get())) * outputModifier) / 2));
								if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:red_blood"))) || entityiterator instanceof Player) {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entityiterator.getX()), (entityiterator.getY() + 1.25), (entityiterator.getZ()), 35, 0.1, 0.1, 0.1, 0.1);
								} else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:green_blood")))) {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.GREEN_BLOOD_DRIP.get()), (entityiterator.getX()), (entityiterator.getY() + 1.25), (entityiterator.getZ()), 35, 0.1, 0.1, 0.1, 0.1);
								}
								entityiterator.invulnerableTime = 0;
								entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
								entityiterator.setDeltaMovement(new Vec3(0, 0, 0));
								targets = targets + 1;
								if (targets >= 1 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 50) * outputModifier) {
									gate = true;
								}
							}
							if (single == false) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("playsound invincible_conquest:basic_hit player " + "@a" + " ~ ~ ~ 1 1"));
								single = true;
							}
						}
					}
				}
				InvincibleConquestModVariables.WorldVariables.get(world).BarrageCooldown = 6;
				InvincibleConquestModVariables.WorldVariables.get(world).syncData(world);
			}
			if (InvincibleConquestModVariables.WorldVariables.get(world).BarrageCooldown > 0) {
				InvincibleConquestModVariables.WorldVariables.get(world).BarrageCooldown = InvincibleConquestModVariables.WorldVariables.get(world).BarrageCooldown - 1;
				InvincibleConquestModVariables.WorldVariables.get(world).syncData(world);
			}
		} else if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld == false && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Barraging == true) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.Barraging = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
