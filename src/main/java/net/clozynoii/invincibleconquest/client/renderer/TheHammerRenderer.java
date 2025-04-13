
package net.clozynoii.invincibleconquest.client.renderer;

public class TheHammerRenderer extends GeoEntityRenderer<TheHammerEntity> {
	public TheHammerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new TheHammerModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(TheHammerEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, TheHammerEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(TheHammerEntity entityLivingBaseIn) {
		return 0.0F;
	}
}