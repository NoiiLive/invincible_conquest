package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.MultiPaulEntity;

public class MultiPaulModel extends GeoModel<MultiPaulEntity> {
	@Override
	public ResourceLocation getAnimationResource(MultiPaulEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/multi_paul.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MultiPaulEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/multi_paul.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MultiPaulEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(MultiPaulEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
