package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.MarsEntity;

public class MarsModel extends GeoModel<MarsEntity> {
	@Override
	public ResourceLocation getAnimationResource(MarsEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/planet_earthlike.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MarsEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/planet_earthlike.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MarsEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
