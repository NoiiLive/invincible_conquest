package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.FlaxanPortalEntity;

public class FlaxanPortalModel extends GeoModel<FlaxanPortalEntity> {
	@Override
	public ResourceLocation getAnimationResource(FlaxanPortalEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/flaxanportal.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FlaxanPortalEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/flaxanportal.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FlaxanPortalEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
