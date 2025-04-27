
package net.clozynoii.invincibleconquest.client.renderer;

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