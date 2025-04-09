package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;

public class BloodDripOnGroundProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, boolean onGround) {
		if (onGround) {
			world.addParticle((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_LAND.get()), x, y, z, 0, 0, 0);
			return true;
		}
		return false;
	}
}
