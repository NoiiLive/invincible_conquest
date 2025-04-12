package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
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
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StrongFlyingMobsCombatProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:strongflying")))) {
			if (sourceentity instanceof InvincibleEntity) {
				if (sourceentity instanceof InvincibleEntity) {
					((InvincibleEntity) sourceentity).setAnimation("attack");
				}
			} else if (sourceentity instanceof BattleBeastEntity) {
				if (sourceentity instanceof BattleBeastEntity) {
					((BattleBeastEntity) sourceentity).setAnimation("attack");
				}
			} else if (sourceentity instanceof OmniManEntity) {
				if (sourceentity instanceof OmniManEntity) {
					((OmniManEntity) sourceentity).setAnimation("attack");
				}
			} else if (sourceentity instanceof ViltrumiteMaleEntity) {
				if (sourceentity instanceof ViltrumiteMaleEntity) {
					((ViltrumiteMaleEntity) sourceentity).setAnimation("attack");
				}
			} else if (sourceentity instanceof ViltrumiteFemaleEntity) {
				if (sourceentity instanceof ViltrumiteFemaleEntity) {
					((ViltrumiteFemaleEntity) sourceentity).setAnimation("attack");
				}
			} else if (sourceentity instanceof InvincibleBlueEntity) {
				if (sourceentity instanceof InvincibleBlueEntity) {
					((InvincibleBlueEntity) sourceentity).setAnimation("attack");
				}
			} else if (sourceentity instanceof InvincibleMohawkEntity) {
				if (sourceentity instanceof InvincibleMohawkEntity) {
					((InvincibleMohawkEntity) sourceentity).setAnimation("attack");
				}
			} else if (sourceentity instanceof InvincibleSinisterEntity) {
				if (sourceentity instanceof InvincibleSinisterEntity) {
					((InvincibleSinisterEntity) sourceentity).setAnimation("attack");
				}
			} else if (sourceentity instanceof InvincibleDarkEntity) {
				if (sourceentity instanceof InvincibleDarkEntity) {
					((InvincibleDarkEntity) sourceentity).setAnimation("attack");
				}
			} else if (sourceentity instanceof InvincibleVeilEntity) {
				if (sourceentity instanceof InvincibleVeilEntity) {
					((InvincibleVeilEntity) sourceentity).setAnimation("attack");
				}
			} else if (sourceentity instanceof OmnivincibleEntity) {
				if (sourceentity instanceof OmnivincibleEntity) {
					((OmnivincibleEntity) sourceentity).setAnimation("attack");
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.DAMAGE_DESTRUCTION, 50, 0));
			entity.getPersistentData().putString("target", (sourceentity.getDisplayName().getString()));
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 19);
			world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(Blocks.REDSTONE_BLOCK.defaultBlockState()));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get()), (entity.getX()), (entity.getY() + 0.1), (entity.getZ()), 1, 0.1, 0.1, 0.1, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:basic_hit")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:basic_hit")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.PlayerFlying = false;
				_vars.syncPlayerVariables(entity);
			}
			InvincibleConquestMod.queueServerWork(5, () -> {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFlying = true;
					_vars.syncPlayerVariables(entity);
				}
			});
			magnitude = Math.sqrt(sourceentity.getLookAngle().x * sourceentity.getLookAngle().x + sourceentity.getLookAngle().y * sourceentity.getLookAngle().y + sourceentity.getLookAngle().z * sourceentity.getLookAngle().z);
			vecX = sourceentity.getLookAngle().x / magnitude;
			vecY = sourceentity.getLookAngle().y / magnitude;
			vecZ = sourceentity.getLookAngle().z / magnitude;
			vecX = vecX * (4 - entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability / 40);
			vecY = vecY * 4;
			vecZ = vecZ * (4 - entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability / 40);
			entity.push(vecX, vecY, vecZ);
		}
	}
}
