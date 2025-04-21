
package net.clozynoii.invincibleconquest.client.renderer;

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