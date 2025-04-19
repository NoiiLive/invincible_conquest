
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.procedures.TitanLeapEffectEffectExpiresProcedure;
import net.clozynoii.invincibleconquest.procedures.LaserDestructionEffectExpiresProcedure;
import net.clozynoii.invincibleconquest.procedures.CloudCircleEffectExpiresProcedure;
import net.clozynoii.invincibleconquest.potion.TitanLeapEffectMobEffect;
import net.clozynoii.invincibleconquest.potion.StunMobEffect;
import net.clozynoii.invincibleconquest.potion.SmokeCircleMobEffect;
import net.clozynoii.invincibleconquest.potion.SlicingCircleMobEffect;
import net.clozynoii.invincibleconquest.potion.RobotBallControlMobEffect;
import net.clozynoii.invincibleconquest.potion.NoFallMobEffect;
import net.clozynoii.invincibleconquest.potion.LaserKnockbackMobEffect;
import net.clozynoii.invincibleconquest.potion.LaserDestructionMobEffect;
import net.clozynoii.invincibleconquest.potion.InstantCratorMobEffect;
import net.clozynoii.invincibleconquest.potion.ImpactFrameEffectMobEffect;
import net.clozynoii.invincibleconquest.potion.GlassBreakMobEffect;
import net.clozynoii.invincibleconquest.potion.FallingBlocksMobEffect;
import net.clozynoii.invincibleconquest.potion.DragMobEffect;
import net.clozynoii.invincibleconquest.potion.DestructiveFlightMobEffect;
import net.clozynoii.invincibleconquest.potion.DamageDestructionMobEffect;
import net.clozynoii.invincibleconquest.potion.CraterMobEffect;
import net.clozynoii.invincibleconquest.potion.CloudCircleMobEffect;
import net.clozynoii.invincibleconquest.potion.BulletSlamMobEffect;
import net.clozynoii.invincibleconquest.potion.BleedingMobEffect;
import net.clozynoii.invincibleconquest.potion.BeastSlicesMobEffect;
import net.clozynoii.invincibleconquest.potion.BeastMobTimersMobEffect;
import net.clozynoii.invincibleconquest.potion.ActiveAirSlamClawMobEffect;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

@EventBusSubscriber
public class InvincibleConquestModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, InvincibleConquestMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> STUN = REGISTRY.register("stun", () -> new StunMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> NO_FALL = REGISTRY.register("no_fall", () -> new NoFallMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SMOKE_CIRCLE = REGISTRY.register("smoke_circle", () -> new SmokeCircleMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DESTRUCTIVE_FLIGHT = REGISTRY.register("destructive_flight", () -> new DestructiveFlightMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CRATER = REGISTRY.register("crater", () -> new CraterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GLASS_BREAK = REGISTRY.register("glass_break", () -> new GlassBreakMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FALLING_BLOCKS = REGISTRY.register("falling_blocks", () -> new FallingBlocksMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DAMAGE_DESTRUCTION = REGISTRY.register("damage_destruction", () -> new DamageDestructionMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LASER_DESTRUCTION = REGISTRY.register("laser_destruction", () -> new LaserDestructionMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> IMPACT_FRAME_EFFECT = REGISTRY.register("impact_frame_effect", () -> new ImpactFrameEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LASER_KNOCKBACK = REGISTRY.register("laser_knockback", () -> new LaserKnockbackMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BEAST_SLICES = REGISTRY.register("beast_slices", () -> new BeastSlicesMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DRAG = REGISTRY.register("drag", () -> new DragMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BEAST_MOB_TIMERS = REGISTRY.register("beast_mob_timers", () -> new BeastMobTimersMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ACTIVE_AIR_SLAM_CLAW = REGISTRY.register("active_air_slam_claw", () -> new ActiveAirSlamClawMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CLOUD_CIRCLE = REGISTRY.register("cloud_circle", () -> new CloudCircleMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SLICING_CIRCLE = REGISTRY.register("slicing_circle", () -> new SlicingCircleMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TITAN_LEAP_EFFECT = REGISTRY.register("titan_leap_effect", () -> new TitanLeapEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BULLET_SLAM = REGISTRY.register("bullet_slam", () -> new BulletSlamMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> INSTANT_CRATOR = REGISTRY.register("instant_crator", () -> new InstantCratorMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ROBOT_BALL_CONTROL = REGISTRY.register("robot_ball_control", () -> new RobotBallControlMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(LASER_DESTRUCTION)) {
			LaserDestructionEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(CLOUD_CIRCLE)) {
			CloudCircleEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(SLICING_CIRCLE)) {
			CloudCircleEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(TITAN_LEAP_EFFECT)) {
			TitanLeapEffectEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		}
	}
}
