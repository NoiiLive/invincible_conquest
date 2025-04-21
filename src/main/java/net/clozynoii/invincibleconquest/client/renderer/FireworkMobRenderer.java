
package net.clozynoii.invincibleconquest.client.renderer;

public class FireworkMobRenderer extends HumanoidMobRenderer<FireworkMobEntity, HumanoidModel<FireworkMobEntity>> {
	public FireworkMobRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<FireworkMobEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(FireworkMobEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/blank.png");
	}
}