package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class CMDCreateFactionProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("None")) {
			if (!((new Object() {
				public String getMessage() {
					try {
						return MessageArgument.getMessage(arguments, "name").getString();
					} catch (CommandSyntaxException ignored) {
						return "";
					}
				}
			}).getMessage()).isEmpty()) {
				if (!(InvincibleConquestModVariables.MapVariables.get(world).FactionIndex).toLowerCase().contains(", " + ((new Object() {
					public String getMessage() {
						try {
							return MessageArgument.getMessage(arguments, "name").getString();
						} catch (CommandSyntaxException ignored) {
							return "";
						}
					}
				}).getMessage()).toLowerCase() + ", ")) {
					if (((new Object() {
						public String getMessage() {
							try {
								return MessageArgument.getMessage(arguments, "name").getString();
							} catch (CommandSyntaxException ignored) {
								return "";
							}
						}
					}).getMessage()).length() < 20) {
						if ((new Object() {
							public String getMessage() {
								try {
									return MessageArgument.getMessage(arguments, "name").getString();
								} catch (CommandSyntaxException ignored) {
									return "";
								}
							}
						}).getMessage().matches("^[A-Za-z ]+$")) {
							InvincibleConquestModVariables.MapVariables.get(world).FactionIndex = InvincibleConquestModVariables.MapVariables.get(world).FactionIndex + "" + (new Object() {
								public String getMessage() {
									try {
										return MessageArgument.getMessage(arguments, "name").getString();
									} catch (CommandSyntaxException ignored) {
										return "";
									}
								}
							}).getMessage() + ", ";
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
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
								_vars.PlayerFactionRank = "Leader";
								_vars.syncPlayerVariables(entity);
							}
							if (!world.isClientSide() && world.getServer() != null)
								world.getServer().getPlayerList().broadcastSystemMessage(
										Component.literal(("<> " + entity.getDisplayName().getString() + " has created the faction, \u00A7l" + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction)), false);
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<> Faction name contains invalid character."), false);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<> Faction name is too long! (Max 20 Characters)"), false);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<> A faction with this name already exists."), false);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<> Faction name cannot be blank."), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("<> Leave your current faction first!"), false);
		}
	}
}
