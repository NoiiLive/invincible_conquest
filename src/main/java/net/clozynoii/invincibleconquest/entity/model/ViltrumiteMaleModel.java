package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.ViltrumiteMaleEntity;

public class ViltrumiteMaleModel extends GeoModel<ViltrumiteMaleEntity> {
	@Override
	public ResourceLocation getAnimationResource(ViltrumiteMaleEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/viltrumite_male.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ViltrumiteMaleEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/viltrumite_male.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ViltrumiteMaleEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(ViltrumiteMaleEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
