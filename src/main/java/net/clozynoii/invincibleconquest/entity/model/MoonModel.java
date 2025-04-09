package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.MoonEntity;

public class MoonModel extends GeoModel<MoonEntity> {
	@Override
	public ResourceLocation getAnimationResource(MoonEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/moon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MoonEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/moon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MoonEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
