package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class CMDFactionInviteProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("None")) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals("Leader") || (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals("Officer")) {
				if (!((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "name");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()) == entity)) {
					if (((new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "name");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("None")) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = (new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "name");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()).getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.FactionInvites = (new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "name");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()).getData(InvincibleConquestModVariables.PLAYER_VARIABLES).FactionInvites + "" + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction + ", ";
							_vars.syncPlayerVariables((new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "name");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()));
						}
						if ((new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "name");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("<> " + entity.getDisplayName().getString() + " has invited you to join " + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction)), false);
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<> Player is already in a faction!"), false);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<> You cannot invite yourself."), false);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<> You cannot invite other players."), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("<> You are not in a faction!"), false);
		}
	}
}
