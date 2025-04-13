package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.animation.AnimationState;

public class ConquestModel extends GeoModel<ConquestEntity> {
	@Override
	public ResourceLocation getAnimationResource(ConquestEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/conquest.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ConquestEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/conquest.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ConquestEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(ConquestEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}