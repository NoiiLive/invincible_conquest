package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnHostileTimeProcedure {
	public static String execute(LevelAccessor world) {
		return "Time Occupied: " + new java.text.DecimalFormat("##").format(InvincibleConquestModVariables.MapVariables.get(world).HOSTILETimeOccupied / 20) + "/60";
	}
}
