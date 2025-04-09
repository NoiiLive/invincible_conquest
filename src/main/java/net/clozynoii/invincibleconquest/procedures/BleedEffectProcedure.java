package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;

public class BleedEffectProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("bleedTick") > 0) {
			entity.getPersistentData().putDouble("bleedTick", (entity.getPersistentData().getDouble("bleedTick") - 1));
		} else if (entity.getPersistentData().getDouble("bleedTick") == 0) {
			entity.getPersistentData().putDouble("bleedTick", 15);
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:red_blood"))) || entity instanceof Player) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entity.getX()), (entity.getY() + 1.25), (entity.getZ()), 35, 0.1, 0.1, 0.1, 0.1);
			} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:green_blood")))) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.GREEN_BLOOD_DRIP.get()), (entity.getX()), (entity.getY() + 1.25), (entity.getZ()), 35, 0.1, 0.1, 0.1, 0.1);
			}
			entity.invulnerableTime = 0;
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("invincible_conquest:bleed")))), (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 10));
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:red_blood"))) || entity instanceof Player) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entity.getX()), (entity.getY() + 1.25), (entity.getZ()), 1, 0.1, 0.1, 0.1, 0);
		} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:green_blood")))) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.GREEN_BLOOD_DRIP.get()), (entity.getX()), (entity.getY() + 1.25), (entity.getZ()), 1, 0.1, 0.1, 0.1, 0);
		}
	}
}
