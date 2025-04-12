package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.animation.AnimationState;

public class BlueSunModel extends GeoModel<BlueSunEntity> {
	@Override
	public ResourceLocation getAnimationResource(BlueSunEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/planet_earthlike.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlueSunEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/planet_earthlike.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlueSunEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}