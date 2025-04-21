
package net.clozynoii.invincibleconquest.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.clozynoii.invincibleconquest.entity.AtomicBlastEntity;

public class AtomicBlastRenderer extends HumanoidMobRenderer<AtomicBlastEntity, HumanoidModel<AtomicBlastEntity>> {
	public AtomicBlastRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<AtomicBlastEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(AtomicBlastEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/blank.png");
	}
}
