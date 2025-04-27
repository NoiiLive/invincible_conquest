
package net.clozynoii.invincibleconquest.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.clozynoii.invincibleconquest.entity.CloneEntity;

public class CloneRenderer extends HumanoidMobRenderer<CloneEntity, HumanoidModel<CloneEntity>> {
	public CloneRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<CloneEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(CloneEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/blank.png");
	}
}
