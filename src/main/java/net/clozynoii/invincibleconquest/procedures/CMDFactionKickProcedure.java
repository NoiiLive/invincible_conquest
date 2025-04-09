package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class CMDFactionKickProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("None")) {
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
						if (((new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "name");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals("Officer") || ((new Object() {
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
								_vars.PlayerFaction = "None";
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
								_vars.PlayerFactionRank = "None";
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
								_vars.PlayerReputation = 0;
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
								_player.displayClientMessage(Component.literal("<> You have been kicked from your faction."), false);
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<> You cannot kick someone the same, or higher, ranked than you."), false);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<> Player is not in your faction!"), false);
					}
				} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals("Officer")) {
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
								_vars.PlayerFaction = "None";
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
								_vars.PlayerFactionRank = "None";
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
								_vars.PlayerReputation = 0;
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
								_player.displayClientMessage(Component.literal("<> You have been kicked from your faction."), false);
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<> You cannot kick someone the same, or higher, ranked than you."), false);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<> Player is not in your faction!"), false);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<> You cannot kick other players."), false);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<> You cannot kick yourself."), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("<> You are not in a faction!"), false);
		}
	}
}
