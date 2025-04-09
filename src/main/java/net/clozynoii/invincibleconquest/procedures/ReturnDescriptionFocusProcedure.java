package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;

public class ReturnDescriptionFocusProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
			return "\u00A76\u00A7l\u00A7nFocus" + "/n" + "\u00A77\u00A7oAffects your ability to" + "/n" + "\u00A77\u00A7ouse moves efficiently" + "/n" + "/n" + "\u00A7e\u00A7l\u00A7nLevel: \u00A7e\u00A7n"
					+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus)
					+ (" (+" + new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) + ")") + "/n" + "\u00A7f+"
					+ new java.text.DecimalFormat("##.##").format(
							(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / (100 / (double) InvincibleConfigConfiguration.FOCCDREDUCE.get()))
					+ "% \u00A7f\u00A7lCooldown Reduction" + "/n" + "\u00A7f+"
					+ new java.text.DecimalFormat("##.##").format((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
							/ (100 / (double) InvincibleConfigConfiguration.FOCMOVEDURATION.get()))
					+ "/sec \u00A7f\u00A7lMove Duration";
		}
		return "\u00A76\u00A7l\u00A7nFocus" + "/n" + "\u00A77\u00A7oAffects your ability to" + "/n" + "\u00A77\u00A7ouse moves efficiently" + "/n" + "/n" + "\u00A7e\u00A7l\u00A7nLevel: \u00A7e\u00A7n"
				+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus) + "/n" + "\u00A7f+"
				+ new java.text.DecimalFormat("##.##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus / (100 / (double) InvincibleConfigConfiguration.FOCCDREDUCE.get())) + "% \u00A7f\u00A7lCooldown Reduction"
				+ "/n" + "\u00A7f+" + new java.text.DecimalFormat("##.##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus / (100 / (double) InvincibleConfigConfiguration.FOCMOVEDURATION.get()))
				+ "/sec \u00A7f\u00A7lMove Duration";
	}
}
