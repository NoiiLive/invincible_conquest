package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class LaserDestructionOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		degree = Math.toRadians(entity.getYRot());
		xRadius = entity.getPersistentData().getDouble("xincrease");
		zRadius = entity.getPersistentData().getDouble("zincrease");
		for (int index0 = 0; index0 < 36; index0++) {
			x_pos = x + Math.cos(degree) * xRadius;
			y_pos = y + 0.1;
			z_pos = z + Math.sin(degree) * zRadius;
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x_pos, y_pos, z_pos, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x_pos, y_pos, z_pos, 3, 0.1, 0.1, 0.1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.LARGE_SMOKE.get()), x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.ELECTRICITY.get()), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.EXPLOSION.get()), x_pos, y_pos, z_pos, 15, 0.1, 0.1, 0.1, 0);
			degree = degree + Math.toRadians(5);
		}
		degree = Math.toRadians(entity.getYRot());
		xRadius = entity.getPersistentData().getDouble("xdecrease");
		zRadius = entity.getPersistentData().getDouble("zdecrease");
		for (int index1 = 0; index1 < 36; index1++) {
			x_pos = x + Math.cos(degree) * xRadius;
			y_pos = y + 0.1;
			z_pos = z + Math.sin(degree) * zRadius;
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x_pos, y_pos, z_pos, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x_pos, y_pos, z_pos, 3, 0.1, 0.1, 0.1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.LARGE_SMOKE.get()), x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.ELECTRICITY.get()), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.EXPLOSION.get()), x_pos, y_pos, z_pos, 15, 0.1, 0.1, 0.1, 0);
			degree = degree + Math.toRadians(5);
		}
		entity.getPersistentData().putDouble("xincrease", (entity.getPersistentData().getDouble("xincrease") + 3));
		entity.getPersistentData().putDouble("zincrease", (entity.getPersistentData().getDouble("zincrease") + 3));
		entity.getPersistentData().putDouble("zdecrease", (entity.getPersistentData().getDouble("zdecrease") - 3));
		entity.getPersistentData().putDouble("xdecrease", (entity.getPersistentData().getDouble("xdecrease") - 3));
	}
}
