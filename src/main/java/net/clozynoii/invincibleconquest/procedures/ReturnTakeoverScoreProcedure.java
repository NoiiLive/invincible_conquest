package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnTakeoverScoreProcedure {
	public static String execute(LevelAccessor world) {
		return InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover + " Takeover: " + new java.text.DecimalFormat("##").format(InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore) + "%";
	}
}
