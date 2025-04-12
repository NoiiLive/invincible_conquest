
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.potion.StunMobEffect;
import net.clozynoii.invincibleconquest.potion.SmokeCircleMobEffect;
import net.clozynoii.invincibleconquest.potion.NoFallMobEffect;
import net.clozynoii.invincibleconquest.potion.HardStunMobEffect;
import net.clozynoii.invincibleconquest.potion.GlassBreakMobEffect;
import net.clozynoii.invincibleconquest.potion.FallingBlocksMobEffect;
import net.clozynoii.invincibleconquest.potion.DestructiveFlightMobEffect;
import net.clozynoii.invincibleconquest.potion.DamageDestructionMobEffect;
import net.clozynoii.invincibleconquest.potion.CraterMobEffect;
import net.clozynoii.invincibleconquest.potion.BleedingMobEffect;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

public class InvincibleConquestModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, InvincibleConquestMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> STUN = REGISTRY.register("stun", () -> new StunMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> NO_FALL = REGISTRY.register("no_fall", () -> new NoFallMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SMOKE_CIRCLE = REGISTRY.register("smoke_circle", () -> new SmokeCircleMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DESTRUCTIVE_FLIGHT = REGISTRY.register("destructive_flight", () -> new DestructiveFlightMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CRATER = REGISTRY.register("crater", () -> new CraterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> HARD_STUN = REGISTRY.register("hard_stun", () -> new HardStunMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GLASS_BREAK = REGISTRY.register("glass_break", () -> new GlassBreakMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FALLING_BLOCKS = REGISTRY.register("falling_blocks", () -> new FallingBlocksMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DAMAGE_DESTRUCTION = REGISTRY.register("damage_destruction", () -> new DamageDestructionMobEffect());
}
