package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.DupliKateEntity;

public class DupliKateModel extends GeoModel<DupliKateEntity> {
	@Override
	public ResourceLocation getAnimationResource(DupliKateEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/dupli_kate.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DupliKateEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/dupli_kate.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DupliKateEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(DupliKateEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
