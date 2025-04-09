package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;

public class ReturnDescriptionVitalityProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
			return "\u00A76\u00A7l\u00A7nVitality" + "/n" + "\u00A77\u00A7oAffects your health" + "/n" + "\u00A77\u00A7oand regeneration speed" + "/n" + "/n" + "\u00A7e\u00A7l\u00A7nLevel: \u00A7e\u00A7n"
					+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerVitality)
					+ (" (+" + new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) + ")") + "/n" + "\u00A7f+"
					+ new java.text.DecimalFormat("##").format((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerVitality + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
							/ (100 / (double) InvincibleConfigConfiguration.VITHEALTHBOOST.get()))
					+ " \u00A7f\u00A7lHealth" + "/n" + "\u00A7f+"
					+ new java.text.DecimalFormat("##").format((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerVitality + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
							/ (100 / (double) InvincibleConfigConfiguration.VITREGENRATE.get()))
					+ "/sec \u00A7f\u00A7lRegeneration";
		}
		return "\u00A76\u00A7l\u00A7nVitality" + "/n" + "\u00A77\u00A7oAffects your health" + "/n" + "\u00A77\u00A7oand regeneration speed" + "/n" + "/n" + "\u00A7e\u00A7l\u00A7nLevel: \u00A7e\u00A7n"
				+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerVitality) + "/n" + "\u00A7f+"
				+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerVitality / (100 / (double) InvincibleConfigConfiguration.VITHEALTHBOOST.get())) + " \u00A7f\u00A7lHealth" + "/n"
				+ "\u00A7f+" + new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerVitality / (100 / (double) InvincibleConfigConfiguration.VITREGENRATE.get()))
				+ "/sec \u00A7f\u00A7lRegeneration";
	}
}
