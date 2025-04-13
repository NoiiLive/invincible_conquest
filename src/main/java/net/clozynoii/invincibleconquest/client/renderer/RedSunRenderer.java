
package net.clozynoii.invincibleconquest.client.renderer;

public class RedSunRenderer extends GeoEntityRenderer<RedSunEntity> {
	public RedSunRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new RedSunModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(RedSunEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, RedSunEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 10f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

}