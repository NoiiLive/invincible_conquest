package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CMDSetAgeProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
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
			_vars.PlayerAge = DoubleArgumentType.getDouble(arguments, "amount");
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
			_player.displayClientMessage(Component.literal(("Age has been changed to " + new java.text.DecimalFormat("##").format(DoubleArgumentType.getDouble(arguments, "amount")))), true);
	}
}
