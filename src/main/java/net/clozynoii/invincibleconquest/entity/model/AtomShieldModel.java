package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.AtomShieldEntity;

public class AtomShieldModel extends GeoModel<AtomShieldEntity> {
	@Override
	public ResourceLocation getAnimationResource(AtomShieldEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/atombarrier.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AtomShieldEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/atombarrier.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AtomShieldEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
