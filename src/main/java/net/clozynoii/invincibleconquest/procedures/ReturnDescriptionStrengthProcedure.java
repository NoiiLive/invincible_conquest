package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;

public class ReturnDescriptionStrengthProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
			return "\u00A76\u00A7l\u00A7nStrength" + "/n" + "\u00A77\u00A7oAffects the raw power" + "/n" + "\u00A77\u00A7oof your body" + "/n" + "/n" + "\u00A7e\u00A7l\u00A7nLevel: \u00A7e\u00A7n"
					+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength)
					+ (" (+" + new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) + ")") + "/n" + "\u00A7f+"
					+ new java.text.DecimalFormat("##.##").format(
							(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / (100 / (double) InvincibleConfigConfiguration.STRDAMAGE.get()))
					+ " \u00A7f\u00A7lAttack Damage" + "/n" + "\u00A7f+"
					+ new java.text.DecimalFormat("##.##").format((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
							/ (100 / (double) InvincibleConfigConfiguration.STRKNOCKBACK.get()))
					+ " \u00A7f\u00A7lKnockback";
		}
		return "\u00A76\u00A7l\u00A7nStrength" + "/n" + "\u00A77\u00A7oAffects the raw power" + "/n" + "\u00A77\u00A7oof your body" + "/n" + "/n" + "\u00A7e\u00A7l\u00A7nLevel: \u00A7e\u00A7n"
				+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength) + "/n" + "\u00A7f+"
				+ new java.text.DecimalFormat("##.##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / (100 / (double) InvincibleConfigConfiguration.STRDAMAGE.get())) + " \u00A7f\u00A7lAttack Damage" + "/n"
				+ "\u00A7f+" + new java.text.DecimalFormat("##.##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / (100 / (double) InvincibleConfigConfiguration.STRKNOCKBACK.get()))
				+ " \u00A7f\u00A7lKnockback";
	}
}
