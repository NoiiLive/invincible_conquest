package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnHostileKillsProcedure {
	public static String execute(LevelAccessor world) {
		return "Lives Taken: " + new java.text.DecimalFormat("##").format(InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken) + "/10";
	}
}
