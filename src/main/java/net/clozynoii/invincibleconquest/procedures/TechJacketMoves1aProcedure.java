package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class TechJacketMoves1aProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown1a == 0) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld == false && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).InputDelay == 0) {
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Energy Projection")) {
					AbilityHeavyAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Tech Jab")) {
					AbilityUppercutProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Nano Slam")) {
					AbilitySlamProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Tech Uppercut")) {
					AbilityDashProcedure.execute(world, x, y, z, entity);
				}
			}
		} else {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld == true) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cAbility On Cooldown!"), true);
			}
		}
	}
}
