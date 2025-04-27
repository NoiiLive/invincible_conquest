
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.clozynoii.invincibleconquest.client.particle.SteamSmokeParticle;
import net.clozynoii.invincibleconquest.client.particle.SingularPinkCircleParticle;
import net.clozynoii.invincibleconquest.client.particle.SandySmokeParticle;
import net.clozynoii.invincibleconquest.client.particle.RedSandSmokeParticle;
import net.clozynoii.invincibleconquest.client.particle.RedElectrictyParticle;
import net.clozynoii.invincibleconquest.client.particle.PinkSmokeParticle;
import net.clozynoii.invincibleconquest.client.particle.PinkElectricityParticle;
import net.clozynoii.invincibleconquest.client.particle.PinkBurstCircleParticle;
import net.clozynoii.invincibleconquest.client.particle.LargeSmokeParticle;
import net.clozynoii.invincibleconquest.client.particle.LargeExplosionParticle;
import net.clozynoii.invincibleconquest.client.particle.GreenBloodLandParticle;
import net.clozynoii.invincibleconquest.client.particle.GreenBloodDripParticle;
import net.clozynoii.invincibleconquest.client.particle.ExplosionParticle;
import net.clozynoii.invincibleconquest.client.particle.ElectricityParticle;
import net.clozynoii.invincibleconquest.client.particle.DirtySmokeParticle;
import net.clozynoii.invincibleconquest.client.particle.CircleSmallParticle;
import net.clozynoii.invincibleconquest.client.particle.CircleMediumParticle;
import net.clozynoii.invincibleconquest.client.particle.CircleLargeParticle;
import net.clozynoii.invincibleconquest.client.particle.CircleBarrageParticle;
import net.clozynoii.invincibleconquest.client.particle.BurstCircleSmallParticle;
import net.clozynoii.invincibleconquest.client.particle.BurstCircleLargeParticle;
import net.clozynoii.invincibleconquest.client.particle.BloodLandParticle;
import net.clozynoii.invincibleconquest.client.particle.BloodDripParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InvincibleConquestModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(InvincibleConquestModParticleTypes.BURST_CIRCLE_SMALL.get(), BurstCircleSmallParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.LARGE_SMOKE.get(), LargeSmokeParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.BLOOD_DRIP.get(), BloodDripParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.BLOOD_LAND.get(), BloodLandParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.SANDY_SMOKE.get(), SandySmokeParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.STEAM_SMOKE.get(), SteamSmokeParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.DIRTY_SMOKE.get(), DirtySmokeParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.GREEN_BLOOD_DRIP.get(), GreenBloodDripParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.GREEN_BLOOD_LAND.get(), GreenBloodLandParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.RED_SAND_SMOKE.get(), RedSandSmokeParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.EXPLOSION.get(), ExplosionParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.LARGE_EXPLOSION.get(), LargeExplosionParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.CIRCLE_SMALL.get(), CircleSmallParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.CIRCLE_MEDIUM.get(), CircleMediumParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.CIRCLE_LARGE.get(), CircleLargeParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.CIRCLE_BARRAGE.get(), CircleBarrageParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get(), BurstCircleLargeParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.ELECTRICITY.get(), ElectricityParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.RED_ELECTRICTY.get(), RedElectrictyParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.PINK_BURST_CIRCLE.get(), PinkBurstCircleParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.PINK_SMOKE.get(), PinkSmokeParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.PINK_ELECTRICITY.get(), PinkElectricityParticle::provider);
		event.registerSpriteSet(InvincibleConquestModParticleTypes.SINGULAR_PINK_CIRCLE.get(), SingularPinkCircleParticle::provider);
	}
}
