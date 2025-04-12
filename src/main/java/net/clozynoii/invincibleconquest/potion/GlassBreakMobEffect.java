
package net.clozynoii.invincibleconquest.potion;

public class GlassBreakMobEffect extends MobEffect {
	public GlassBreakMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		GlassBreakOnEffectActiveTickProcedure.execute();
		return super.applyEffectTick(entity, amplifier);
	}
}