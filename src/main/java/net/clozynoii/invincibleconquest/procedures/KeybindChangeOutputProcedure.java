package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class KeybindChangeOutputProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).ChangingOutput == false) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.ChangingOutput = true;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).ChangingOutput == true) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.ChangingOutput = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
