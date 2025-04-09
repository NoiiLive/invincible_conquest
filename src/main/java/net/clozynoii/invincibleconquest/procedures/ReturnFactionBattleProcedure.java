package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnFactionBattleProcedure {
	public static String execute(LevelAccessor world) {
		return "\u00A7l" + InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction + " vs " + InvincibleConquestModVariables.MapVariables.get(world).HomeFaction;
	}
}
