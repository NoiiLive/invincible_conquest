
package net.clozynoii.invincibleconquest.client.renderer;

public class HammerSpawnerRenderer extends HumanoidMobRenderer<HammerSpawnerEntity, HumanoidModel<HammerSpawnerEntity>> {
	public HammerSpawnerRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<HammerSpawnerEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(HammerSpawnerEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/blank.png");
	}
}