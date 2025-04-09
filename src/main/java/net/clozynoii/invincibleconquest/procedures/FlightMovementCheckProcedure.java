package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import com.mojang.blaze3d.platform.InputConstants;

public class FlightMovementCheckProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_W)) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.FlightDirection = "Forward";
				_vars.syncPlayerVariables(entity);
			}
		} else if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_S)) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.FlightDirection = "Backward";
				_vars.syncPlayerVariables(entity);
			}
		} else if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_A)) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.FlightDirection = "Left";
				_vars.syncPlayerVariables(entity);
			}
		} else if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_D)) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.FlightDirection = "Right";
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.FlightDirection = "";
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
