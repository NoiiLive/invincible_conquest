package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.animation.AnimationState;

public class RedSunModel extends GeoModel<RedSunEntity> {
	@Override
	public ResourceLocation getAnimationResource(RedSunEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/planet_earthlike.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RedSunEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/planet_earthlike.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RedSunEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}