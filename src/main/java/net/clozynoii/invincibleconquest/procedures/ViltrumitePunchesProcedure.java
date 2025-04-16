package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class ViltrumitePunchesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite") || (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Beast")) {
			if (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput >= 100) {
				if (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength >= 10) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(InvincibleConquestModMobEffects.STUN);
					if (sourceentity instanceof LivingEntity _entity)
						_entity.removeEffect(InvincibleConquestModMobEffects.STUN);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_SMALL.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.1, 1, 0.1, 0);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 10, 0.1, 0.1, 0.1, 0.1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.POOF, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 0.01, 0.01, 0.01, 0);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.DAMAGE_DESTRUCTION, 50, 0, false, false));
					world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(Blocks.REDSTONE_BLOCK.defaultBlockState()));
					if (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength >= 25) {
						if (Math.random() < 0.8) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.1, 1, 0.1, 0);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.EXPLOSION, (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.1, 1, 0.1, 0);
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.GLASS_BREAK, 1, 0, false, false));
						}
					}
					if (entity instanceof Player) {
						if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFlying) {
							{
								InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
								_vars.PlayerFlying = false;
								_vars.syncPlayerVariables(entity);
							}
							InvincibleConquestMod.queueServerWork(10, () -> {
								{
									InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
									_vars.PlayerFlying = true;
									_vars.syncPlayerVariables(entity);
								}
							});
						}
						entity.getPersistentData().putString("enemytype", "player");
						StrongPunchPlayerKnockbackProcedure.execute(entity, sourceentity);
					} else if (!(entity instanceof Player)) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entity.getX()), (entity.getY()), (entity.getZ()),
									(int) (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength - (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 5), 0.1, 0.1, 0.1, 0);
						entity.getPersistentData().putString("enemytype", "mob");
						StrongPunchMobKnockbackProcedure.execute(entity, sourceentity);
					}
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:basic_hit")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:basic_hit")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:basic_hit")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:basic_hit")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
					entity.getPersistentData().putString("target", (sourceentity.getDisplayName().getString()));
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 10, 0.01, 0.1, 0.01, 0.2);
			}
		}
	}
}
