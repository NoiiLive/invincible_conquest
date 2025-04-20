package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class WebShooterAbilityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Web Shooter")) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld) {
				if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(InvincibleConquestModMobEffects.DELETED_MOD_ELEMENT))) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:whoosh")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:whoosh")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				} else if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(InvincibleConquestModMobEffects.DELETED_MOD_ELEMENT)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(InvincibleConquestModMobEffects.DELETED_MOD_ELEMENT);
					entity.push((entity.getDeltaMovement().x()), 0.7, (entity.getDeltaMovement().z()));
				}
			} else if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("WIP"), false);
			}
		}
	}
}
