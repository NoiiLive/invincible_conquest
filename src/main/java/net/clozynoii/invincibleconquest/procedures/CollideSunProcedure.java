package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class CollideSunProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		sourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.IN_FIRE)), 25);
		sourceentity.igniteForSeconds(15);
	}
}
