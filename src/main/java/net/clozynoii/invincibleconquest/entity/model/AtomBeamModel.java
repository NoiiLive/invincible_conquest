package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.AtomBeamEntity;

public class AtomBeamModel extends GeoModel<AtomBeamEntity> {
	@Override
	public ResourceLocation getAnimationResource(AtomBeamEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/atomevebeam.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AtomBeamEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/atomevebeam.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AtomBeamEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
