package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnHostileBreakProcedure {
	public static String execute(LevelAccessor world) {
		if (InvincibleConquestModVariables.MapVariables.get(world).BreakPoints == 50) {
			return "Blocks Broken: MAX";
		}
		return "Blocks Broken: " + new java.text.DecimalFormat("##").format(InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken) + "/5000";
	}
}
