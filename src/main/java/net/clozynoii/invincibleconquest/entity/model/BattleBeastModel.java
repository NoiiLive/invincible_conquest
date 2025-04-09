package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.BattleBeastEntity;

public class BattleBeastModel extends GeoModel<BattleBeastEntity> {
	@Override
	public ResourceLocation getAnimationResource(BattleBeastEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/battle_beast.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BattleBeastEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/battle_beast.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BattleBeastEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(BattleBeastEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
