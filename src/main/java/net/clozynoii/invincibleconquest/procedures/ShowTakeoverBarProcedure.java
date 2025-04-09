package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ShowTakeoverBarProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)
				|| (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).HomeFaction)) {
			return true;
		}
		return false;
	}
}
