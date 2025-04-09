package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnSpriteEXPProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 6
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 0) {
			return 0;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 12
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 6) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 18
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 12) {
			return 2;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 24
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 18) {
			return 3;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 30
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 24) {
			return 4;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 36
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 30) {
			return 5;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 42
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 36) {
			return 6;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 48
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 42) {
			return 7;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 54
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 48) {
			return 8;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 60
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 54) {
			return 9;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 66
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 60) {
			return 10;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 72
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 66) {
			return 11;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 78
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 72) {
			return 12;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 84
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 78) {
			return 13;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 90
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 84) {
			return 14;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 <= 100
				&& (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP / entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXPCap) * 100 > 90) {
			return 15;
		}
		return 0;
	}
}
