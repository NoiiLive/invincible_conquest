
package net.clozynoii.invincibleconquest.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.clozynoii.invincibleconquest.entity.AtomBarrierEntity;
import net.clozynoii.invincibleconquest.client.model.Modelatom_barrier;

public class AtomBarrierRenderer extends MobRenderer<AtomBarrierEntity, Modelatom_barrier<AtomBarrierEntity>> {
	public AtomBarrierRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelatom_barrier<AtomBarrierEntity>(context.bakeLayer(Modelatom_barrier.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(AtomBarrierEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/atombarrier.png");
	}
}
