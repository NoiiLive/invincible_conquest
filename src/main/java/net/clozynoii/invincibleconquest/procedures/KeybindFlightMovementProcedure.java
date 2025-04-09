package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class KeybindFlightMovementProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double flightSpeed = 0;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFlying == true) {
			FlightMovementCheckProcedure.execute(entity);
		} else {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.FlightDirection = "";
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
