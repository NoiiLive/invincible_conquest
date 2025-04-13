
package net.clozynoii.invincibleconquest.client.renderer;

public class OrangeSunRenderer extends GeoEntityRenderer<OrangeSunEntity> {
	public OrangeSunRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new OrangeSunModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(OrangeSunEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, OrangeSunEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 10f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

}