
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.clozynoii.invincibleconquest.client.renderer.WhiteSunRenderer;
import net.clozynoii.invincibleconquest.client.renderer.ViltrumiteMarkRenderer;
import net.clozynoii.invincibleconquest.client.renderer.ViltrumiteMaleRenderer;
import net.clozynoii.invincibleconquest.client.renderer.ViltrumiteFemaleRenderer;
import net.clozynoii.invincibleconquest.client.renderer.ViltrumRenderer;
import net.clozynoii.invincibleconquest.client.renderer.TheHammerRenderer;
import net.clozynoii.invincibleconquest.client.renderer.TalescriaRenderer;
import net.clozynoii.invincibleconquest.client.renderer.SunRenderer;
import net.clozynoii.invincibleconquest.client.renderer.RexSplodeRenderer;
import net.clozynoii.invincibleconquest.client.renderer.RedSunRenderer;
import net.clozynoii.invincibleconquest.client.renderer.OrangeSunRenderer;
import net.clozynoii.invincibleconquest.client.renderer.OmnivincibleRenderer;
import net.clozynoii.invincibleconquest.client.renderer.OmniManRenderer;
import net.clozynoii.invincibleconquest.client.renderer.MultiPaulRenderer;
import net.clozynoii.invincibleconquest.client.renderer.MoonRenderer;
import net.clozynoii.invincibleconquest.client.renderer.MaulerTwinRenderer;
import net.clozynoii.invincibleconquest.client.renderer.MartianSpearmanRenderer;
import net.clozynoii.invincibleconquest.client.renderer.MartianRenderer;
import net.clozynoii.invincibleconquest.client.renderer.MarsRenderer;
import net.clozynoii.invincibleconquest.client.renderer.InvincibleVeilRenderer;
import net.clozynoii.invincibleconquest.client.renderer.InvincibleSinisterRenderer;
import net.clozynoii.invincibleconquest.client.renderer.InvincibleRenderer;
import net.clozynoii.invincibleconquest.client.renderer.InvincibleMohawkRenderer;
import net.clozynoii.invincibleconquest.client.renderer.InvincibleMasklessRenderer;
import net.clozynoii.invincibleconquest.client.renderer.InvincibleDarkRenderer;
import net.clozynoii.invincibleconquest.client.renderer.InvincibleBlueRenderer;
import net.clozynoii.invincibleconquest.client.renderer.HammerSpawnerRenderer;
import net.clozynoii.invincibleconquest.client.renderer.FlaxanRenderer;
import net.clozynoii.invincibleconquest.client.renderer.FlaxanPortalRenderer;
import net.clozynoii.invincibleconquest.client.renderer.FlaxanGunmanRenderer;
import net.clozynoii.invincibleconquest.client.renderer.EarthRenderer;
import net.clozynoii.invincibleconquest.client.renderer.DupliKateRenderer;
import net.clozynoii.invincibleconquest.client.renderer.DinosaurRenderer;
import net.clozynoii.invincibleconquest.client.renderer.ConquestRenderer;
import net.clozynoii.invincibleconquest.client.renderer.BlueSunRenderer;
import net.clozynoii.invincibleconquest.client.renderer.BattleBeastRenderer;
import net.clozynoii.invincibleconquest.client.renderer.AtomEveRenderer;
import net.clozynoii.invincibleconquest.client.renderer.AngstromRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InvincibleConquestModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(InvincibleConquestModEntities.INVINCIBLE.get(), InvincibleRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.INVINCIBLE_BLUE.get(), InvincibleBlueRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.INVINCIBLE_SINISTER.get(), InvincibleSinisterRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.INVINCIBLE_MOHAWK.get(), InvincibleMohawkRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.INVINCIBLE_MASKLESS.get(), InvincibleMasklessRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.INVINCIBLE_VEIL.get(), InvincibleVeilRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.INVINCIBLE_DARK.get(), InvincibleDarkRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.VILTRUMITE_MARK.get(), ViltrumiteMarkRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.OMNIVINCIBLE.get(), OmnivincibleRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.DINOSAUR.get(), DinosaurRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.MARTIAN.get(), MartianRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.MARTIAN_SPEARMAN.get(), MartianSpearmanRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.FLAXAN.get(), FlaxanRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.FLAXAN_GUNMAN.get(), FlaxanGunmanRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.FLAXAN_BULLET.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.OMNI_MAN.get(), OmniManRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.ANGSTROM.get(), AngstromRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.REX_SPLODE.get(), RexSplodeRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.ATOM_EVE.get(), AtomEveRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.DUPLI_KATE.get(), DupliKateRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.MULTI_PAUL.get(), MultiPaulRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.BATTLE_BEAST.get(), BattleBeastRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.MAULER_TWIN.get(), MaulerTwinRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.VILTRUMITE_MALE.get(), ViltrumiteMaleRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.VILTRUMITE_FEMALE.get(), ViltrumiteFemaleRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.EARTH.get(), EarthRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.MOON.get(), MoonRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.MARS.get(), MarsRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.VILTRUM.get(), ViltrumRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.SUN.get(), SunRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.TALESCRIA.get(), TalescriaRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.CONQUEST.get(), ConquestRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.WHITE_SUN.get(), WhiteSunRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.THE_HAMMER.get(), TheHammerRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.FLAXAN_PORTAL.get(), FlaxanPortalRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.ORANGE_SUN.get(), OrangeSunRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.RED_SUN.get(), RedSunRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.BLUE_SUN.get(), BlueSunRenderer::new);
		event.registerEntityRenderer(InvincibleConquestModEntities.HAMMER_SPAWNER.get(), HammerSpawnerRenderer::new);
	}
}
