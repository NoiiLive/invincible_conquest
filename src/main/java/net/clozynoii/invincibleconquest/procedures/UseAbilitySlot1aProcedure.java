package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class UseAbilitySlot1aProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown1a == 0) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld == false && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).InputDelay == 0) {
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Heavy Attack")) {
					AbilityHeavyAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Uppercut")) {
					AbilityUppercutProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Slam")) {
					AbilitySlamProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Dash")) {
					AbilityDashProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Grab")) {
					AbilityGrabProcedure.execute(world, x, y, z, entity);
				}
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Barrage")) {
				AbilityBarrageProcedure.execute(world, entity);
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
				ViltrumiteAbilitiesProcedure.execute(world, x, y, z, entity);
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Portal")) {
				PortalMovesProcedure.execute(world, x, y, z, entity);
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Speedster")) {
				SpeedsterMovesProcedure.execute(world, x, y, z, entity);
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Beast")) {
				BeastMovesProcedure.execute(world, x, y, z, entity);
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Atom")) {
				AtomicMovesProcedure.execute(world, x, y, z, entity);
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Spider")) {
				SpidermanMovesProcedure.execute(world, x, y, z, entity);
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Explode")) {
				RexSplodeMovesProcedure.execute(world, x, y, z, entity);
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Duplicate")) {
				ReplicateMovesProcedure.execute(world, x, y, z, entity);
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Tech Jacket")) {
				TechJacketMovesProcedure.execute(world, x, y, z, entity);
			}
		} else {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld == true) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cAbility On Cooldown!"), true);
			}
		}
	}
}
