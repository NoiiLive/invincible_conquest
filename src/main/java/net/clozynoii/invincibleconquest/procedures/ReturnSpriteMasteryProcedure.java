package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnSpriteMasteryProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 6 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 0) {
			return 0;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 12 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 6) {
			return 1;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 18 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 12) {
			return 2;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 24 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 18) {
			return 3;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 30 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 24) {
			return 4;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 36 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 30) {
			return 5;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 42 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 36) {
			return 6;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 48 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 42) {
			return 7;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 54 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 48) {
			return 8;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 60 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 54) {
			return 9;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 66 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 60) {
			return 10;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 72 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 66) {
			return 11;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 78 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 72) {
			return 12;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 84 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 78) {
			return 13;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 90 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 84) {
			return 14;
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery <= 100 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityMastery > 90) {
			return 15;
		}
		return 0;
	}
}
