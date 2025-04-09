package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class CMDDisbandFactionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("None")) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals("Leader")) {
				InvincibleConquestModVariables.MapVariables.get(world).FactionIndex = InvincibleConquestModVariables.MapVariables.get(world).FactionIndex.replace(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction + ", ",
						"");
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<> You have disbanded " + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction)), false);
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFaction = "None";
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "None";
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerReputation = 0;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<> You cannot disband this faction."), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("<> You are not in a faction!"), false);
		}
	}
}
