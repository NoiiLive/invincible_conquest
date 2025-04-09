package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class RemoveSkillPointsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AddPlayerSkillPoints > 1) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.AddPlayerSkillPoints = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AddPlayerSkillPoints - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
