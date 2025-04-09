package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class CMDAcceptInviteProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("None")) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).FactionInvites.contains(", " + (new Object() {
				public String getMessage() {
					try {
						return MessageArgument.getMessage(arguments, "name").getString();
					} catch (CommandSyntaxException ignored) {
						return "";
					}
				}
			}).getMessage() + ", ")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.FactionInvites = ", ";
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFaction = (new Object() {
						public String getMessage() {
							try {
								return MessageArgument.getMessage(arguments, "name").getString();
							} catch (CommandSyntaxException ignored) {
								return "";
							}
						}
					}).getMessage();
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "Member";
					_vars.syncPlayerVariables(entity);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<> You have not been invited to this faction."), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("<> Leave your current faction first!"), false);
		}
	}
}
