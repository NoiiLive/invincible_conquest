package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnSpriteStaminaProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 <= 11
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 > 0) {
			return 0;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 <= 22
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 > 11) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 <= 33
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 > 22) {
			return 2;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 <= 44
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 > 33) {
			return 3;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 <= 55
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 > 44) {
			return 4;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 <= 66
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 > 55) {
			return 5;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 <= 77
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 > 66) {
			return 6;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 <= 88
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 > 77) {
			return 7;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 <= 200
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerMaxStamina) * 100 > 88) {
			return 8;
		}
		return 0;
	}
}
