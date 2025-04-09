package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class AddPointFocusProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double leftover_points = 0;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints >= entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AddPlayerSkillPoints
				&& entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus < 100) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AddPlayerSkillPoints > 100) {
				leftover_points = (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AddPlayerSkillPoints) - 100;
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFocus = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AddPlayerSkillPoints - leftover_points;
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerSkillPoints = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints - (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AddPlayerSkillPoints - leftover_points);
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFocus = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AddPlayerSkillPoints;
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerSkillPoints = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints - entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AddPlayerSkillPoints;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints < entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AddPlayerSkillPoints
				&& entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus < 100) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints > 100) {
				leftover_points = (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints) - 100;
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFocus = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints - leftover_points;
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerSkillPoints = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints - (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints - leftover_points);
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFocus = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints;
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerSkillPoints = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints - entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
