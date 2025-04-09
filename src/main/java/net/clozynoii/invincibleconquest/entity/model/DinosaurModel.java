package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.DinosaurEntity;

public class DinosaurModel extends GeoModel<DinosaurEntity> {
	@Override
	public ResourceLocation getAnimationResource(DinosaurEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/dinosaur.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DinosaurEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/dinosaur.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DinosaurEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(DinosaurEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
