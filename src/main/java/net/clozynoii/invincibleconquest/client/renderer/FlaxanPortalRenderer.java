
package net.clozynoii.invincibleconquest.client.renderer;

public class FlaxanPortalRenderer extends GeoEntityRenderer<FlaxanPortalEntity> {
	public FlaxanPortalRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FlaxanPortalModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(FlaxanPortalEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, FlaxanPortalEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 2f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(FlaxanPortalEntity entityLivingBaseIn) {
		return 0.0F;
	}
}