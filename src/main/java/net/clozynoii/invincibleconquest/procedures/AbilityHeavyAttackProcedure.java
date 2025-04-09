package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
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
import net.minecraft.commands.functions.CommandFunction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;

import java.util.Optional;
import java.util.List;
import java.util.Comparator;

public class AbilityHeavyAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean single = false;
		boolean gate = false;
		String ability = "";
		double vecZ = 0;
		double vecX = 0;
		double cooldown = 0;
		double magnitude = 0;
		double targets = 0;
		double outputModifier = 0;
		double reduction = 0;
		gate = false;
		targets = 0;
		reduction = 60
				* ((((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100) * (double) InvincibleConfigConfiguration.FOCCDREDUCE.get()) / 100);
		cooldown = 60 - reduction;
		magnitude = 0;
		ability = "Heavy Attack";
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).NoCooldowns == false) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 1 || entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals(ability)) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.Cooldown1a = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2a).equals(ability)) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.Cooldown2a = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3a).equals(ability)) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.Cooldown3a = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4a).equals(ability)) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.Cooldown4a = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5a).equals(ability)) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.Cooldown5a = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1b).equals(ability)) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.Cooldown1b = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2b).equals(ability)) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.Cooldown2b = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3b).equals(ability)) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.Cooldown3b = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4b).equals(ability)) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.Cooldown4b = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5b).equals(ability)) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.Cooldown5b = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.InputDelay = 15;
			_vars.syncPlayerVariables(entity);
		}
		outputModifier = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput / 100;
		if (world.isClientSide()) {
			SetupAnimationsProcedure.setAnimationClientside((Player) entity, "heavy", true);
		}
		if (!world.isClientSide()) {
			if (entity instanceof Player)
				PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("heavy", entity.getId(), true));
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				Optional<CommandFunction<CommandSourceStack>> _fopt = _ent.getServer().getFunctions().get(ResourceLocation.parse("invincible_conquest:heavy_attack_function"));
				if (_fopt.isPresent())
					_ent.getServer().getFunctions().execute(_fopt.get(), _ent.createCommandSourceStack());
			}
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength * outputModifier >= 50) {
			world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_SMALL.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 0, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("playsound minecraft:entity.generic.explode player " + "@a" + " ~ ~ ~ 0.7 1"));
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("playsound invincible_conquest:whoosh player " + "@a" + " ~ ~ ~ 1 1"));
		magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
		vecX = entity.getLookAngle().x / magnitude;
		vecZ = entity.getLookAngle().z / magnitude;
		vecX = vecX
				* (1 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / (50 / (double) InvincibleConfigConfiguration.STRKNOCKBACK.get()))
						* outputModifier);
		vecZ = vecZ
				* (1 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / (50 / (double) InvincibleConfigConfiguration.STRKNOCKBACK.get()))
						* outputModifier);
		{
			final Vec3 _center = new Vec3(
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getX()),
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getY()),
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getZ()));
			List<Entity> _entfound = world
					.getEntitiesOfClass(Entity.class,
							new AABB(_center, _center)
									.inflate((4 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 50) * outputModifier) / 2d),
							e -> true)
					.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)
						&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable")))) {
					if (gate == false) {
						entityiterator.invulnerableTime = 0;
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), entity),
								(float) (5 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
										/ (100 / (double) InvincibleConfigConfiguration.STRDAMAGE.get())) * outputModifier));
						entityiterator.invulnerableTime = 0;
						if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:red_blood"))) || entityiterator instanceof Player) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entityiterator.getX()), (entityiterator.getY() + 1.25), (entityiterator.getZ()), 50, 0.1, 0.1, 0.1, 0.1);
						} else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:green_blood")))) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.GREEN_BLOOD_DRIP.get()), (entityiterator.getX()), (entityiterator.getY() + 1.25), (entityiterator.getZ()), 50, 0.1, 0.1, 0.1, 0.1);
						}
						entityiterator.push(vecX, 0.25, vecZ);
						targets = targets + 1;
						if (targets >= 1 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 50) * outputModifier) {
							gate = true;
						}
					}
					if (single == false) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("playsound invincible_conquest:basic_hit player " + "@a" + " ~ ~ ~ 1 1"));
						single = true;
					}
				}
			}
		}
	}
}
