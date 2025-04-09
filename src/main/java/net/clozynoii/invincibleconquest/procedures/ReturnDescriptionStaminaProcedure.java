package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;

public class ReturnDescriptionStaminaProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
			return "\u00A76\u00A7l\u00A7nStamina" + "/n" + "\u00A77\u00A7oAffects your ability to use" + "/n" + "\u00A77\u00A7omoves for long durations" + "/n" + "/n" + "\u00A7e\u00A7l\u00A7nLevel: \u00A7e\u00A7n"
					+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina)
					+ (" (+" + new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) + ")") + "/n" + "\u00A7f+"
					+ new java.text.DecimalFormat("##").format(
							(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / (100 / (double) InvincibleConfigConfiguration.STMBONUS.get()))
					+ " \u00A7f\u00A7lStamina" + "/n" + "\u00A7f-"
					+ new java.text.DecimalFormat("##.##").format(
							(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / (100 / (double) InvincibleConfigConfiguration.STMDRAIN.get()))
					+ "% \u00A7f\u00A7lStamina Drain";
		}
		return "\u00A76\u00A7l\u00A7nStamina" + "/n" + "\u00A77\u00A7oAffects your ability to use" + "/n" + "\u00A77\u00A7omoves for long durations" + "/n" + "/n" + "\u00A7e\u00A7l\u00A7nLevel: \u00A7e\u00A7n"
				+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina) + "/n" + "\u00A7f+"
				+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina / (100 / (double) InvincibleConfigConfiguration.STMBONUS.get())) + " \u00A7f\u00A7lStamina" + "/n" + "\u00A7f-"
				+ new java.text.DecimalFormat("##.##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina / (100 / (double) InvincibleConfigConfiguration.STMDRAIN.get())) + "% \u00A7f\u00A7lStamina Drain";
	}
}
