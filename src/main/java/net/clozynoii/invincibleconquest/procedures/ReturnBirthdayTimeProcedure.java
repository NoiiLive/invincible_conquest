package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnBirthdayTimeProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
			return "\u00A7fBirthday in \u00A7f\u00A7l" + new java.text.DecimalFormat("##.##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeTimer / 24000) + " \u00A7fDay(s)" + "/n" + "/n"
					+ "\u00A7e\u00A7l\u00A7nAge Stat Increase" + "/n" + "\u00A7f+" + new java.text.DecimalFormat("##.##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) + " \u00A7f\u00A7lTo All Stats";
		}
		return "\u00A7fBirthday in \u00A7f\u00A7l" + new java.text.DecimalFormat("##.##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeTimer / 24000) + " \u00A7fDay(s)";
	}
}
