package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class BarrierEffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.isClientSide()) {
			SetupAnimationsProcedure.setAnimationClientside((Player) entity, "hands", false);
		}
		if (!world.isClientSide()) {
			if (entity instanceof Player)
				PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("hands", entity.getId(), false));
		}
		entity.getPersistentData().putDouble("barriertimer", (entity.getPersistentData().getDouble("barriertimer") + 1));
		if (entity.getPersistentData().getDouble("barriertimer") >= 20 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus) {
			entity.getPersistentData().putDouble("barriertimer", 0);
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DRY_OUT)), (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 10));
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 5) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:heartbeat")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:heartbeat")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), x, (y + 2), z, 5, 0.1, 0.1, 0.1, 0.1);
			}
		}
	}
}
