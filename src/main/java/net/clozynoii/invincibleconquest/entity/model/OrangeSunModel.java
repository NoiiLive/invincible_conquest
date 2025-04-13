package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.OrangeSunEntity;

public class OrangeSunModel extends GeoModel<OrangeSunEntity> {
	@Override
	public ResourceLocation getAnimationResource(OrangeSunEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/planet_earthlike.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OrangeSunEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/planet_earthlike.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OrangeSunEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
