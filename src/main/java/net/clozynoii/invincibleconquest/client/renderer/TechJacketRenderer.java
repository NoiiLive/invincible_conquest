
package net.clozynoii.invincibleconquest.client.renderer;

public class TechJacketRenderer extends GeoEntityRenderer<TechJacketEntity> {
	public TechJacketRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new TechJacketModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(TechJacketEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, TechJacketEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

}