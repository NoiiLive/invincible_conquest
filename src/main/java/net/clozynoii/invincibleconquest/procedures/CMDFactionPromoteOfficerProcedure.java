package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class CMDFactionPromoteOfficerProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("None")) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals("Leader")) {
				if (((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "name");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction)) {
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
						}.getEntity()).getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals("Member")) {
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
								_vars.PlayerFactionRank = "Officer";
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
								_player.displayClientMessage(Component.literal("<> You have been promoted to Officer!"), false);
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<> Player is already an Officer."), false);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<> You cannot promote yourself to Officer."), false);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<> Player is not in your faction!"), false);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<> You cannot promote other players."), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("<> You are not in a faction!"), false);
		}
	}
}
