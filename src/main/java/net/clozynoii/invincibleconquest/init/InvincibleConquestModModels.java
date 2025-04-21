
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.clozynoii.invincibleconquest.client.model.Modelviltrumite_armor;
import net.clozynoii.invincibleconquest.client.model.Modelveil_invincible_suit;
import net.clozynoii.invincibleconquest.client.model.Modeltech_jacket_armor;
import net.clozynoii.invincibleconquest.client.model.Modelspace_helmet;
import net.clozynoii.invincibleconquest.client.model.Modelrex_splode_suit;
import net.clozynoii.invincibleconquest.client.model.Modelomniman_suit;
import net.clozynoii.invincibleconquest.client.model.Modelmauler_suit;
import net.clozynoii.invincibleconquest.client.model.Modelinvincible_suit_sinister;
import net.clozynoii.invincibleconquest.client.model.Modelinvincible_suit;
import net.clozynoii.invincibleconquest.client.model.Modelflaxan_armor;
import net.clozynoii.invincibleconquest.client.model.Modelclone_twin_suit;
import net.clozynoii.invincibleconquest.client.model.Modelatom_eve_suit;
import net.clozynoii.invincibleconquest.client.model.Modelangstrom_clothes;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class InvincibleConquestModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelclone_twin_suit.LAYER_LOCATION, Modelclone_twin_suit::createBodyLayer);
		event.registerLayerDefinition(Modelmauler_suit.LAYER_LOCATION, Modelmauler_suit::createBodyLayer);
		event.registerLayerDefinition(Modelangstrom_clothes.LAYER_LOCATION, Modelangstrom_clothes::createBodyLayer);
		event.registerLayerDefinition(Modeltech_jacket_armor.LAYER_LOCATION, Modeltech_jacket_armor::createBodyLayer);
		event.registerLayerDefinition(Modelomniman_suit.LAYER_LOCATION, Modelomniman_suit::createBodyLayer);
		event.registerLayerDefinition(Modelspace_helmet.LAYER_LOCATION, Modelspace_helmet::createBodyLayer);
		event.registerLayerDefinition(Modelflaxan_armor.LAYER_LOCATION, Modelflaxan_armor::createBodyLayer);
		event.registerLayerDefinition(Modelinvincible_suit_sinister.LAYER_LOCATION, Modelinvincible_suit_sinister::createBodyLayer);
		event.registerLayerDefinition(Modelrex_splode_suit.LAYER_LOCATION, Modelrex_splode_suit::createBodyLayer);
		event.registerLayerDefinition(Modelviltrumite_armor.LAYER_LOCATION, Modelviltrumite_armor::createBodyLayer);
		event.registerLayerDefinition(Modelinvincible_suit.LAYER_LOCATION, Modelinvincible_suit::createBodyLayer);
		event.registerLayerDefinition(Modelveil_invincible_suit.LAYER_LOCATION, Modelveil_invincible_suit::createBodyLayer);
		event.registerLayerDefinition(Modelatom_eve_suit.LAYER_LOCATION, Modelatom_eve_suit::createBodyLayer);
	}
}
