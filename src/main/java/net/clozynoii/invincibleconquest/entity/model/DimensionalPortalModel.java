package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.DimensionalPortalEntity;

public class DimensionalPortalModel extends GeoModel<DimensionalPortalEntity> {
	@Override
	public ResourceLocation getAnimationResource(DimensionalPortalEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/flaxanportal.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DimensionalPortalEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/flaxanportal.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DimensionalPortalEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
