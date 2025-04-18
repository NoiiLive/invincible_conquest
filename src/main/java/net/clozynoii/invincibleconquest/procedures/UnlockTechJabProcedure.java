package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class UnlockTechJabProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean gate = false;
		gate = false;
		if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Tech Jab" + ", ") && gate == false) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints >= 1) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerSkillPoints = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints - 1;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("playsound minecraft:entity.experience_orb.pickup master " + entity.getDisplayName().getString() + " ~ ~ ~ 0.7 1"));
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.UnlockedSkills = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).UnlockedSkills + "Tech Jab" + ", ";
					_vars.syncPlayerVariables(entity);
				}
				gate = true;
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("playsound enchant.thorns.hit master " + entity.getDisplayName().getString() + " ~ ~ ~ 0.7 1"));
				gate = true;
			}
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Tech Jab" + ", ") && gate == false) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.GUISelectedEntry = "Tech Jab";
				_vars.syncPlayerVariables(entity);
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("playsound minecraft:item.book.put master " + entity.getDisplayName().getString() + " ~ ~ ~ 2 1"));
			gate = true;
		}
	}
}
