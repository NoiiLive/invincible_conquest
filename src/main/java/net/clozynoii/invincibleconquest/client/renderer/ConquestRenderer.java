
package net.clozynoii.invincibleconquest.client.renderer;

public class ConquestRenderer extends GeoEntityRenderer<ConquestEntity> {
	public ConquestRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ConquestModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(ConquestEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ConquestEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

}