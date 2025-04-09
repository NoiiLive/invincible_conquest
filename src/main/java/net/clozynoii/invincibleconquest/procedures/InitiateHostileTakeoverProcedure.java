package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class InitiateHostileTakeoverProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("")) {
			InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction;
			InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = 0;
			InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			InvincibleConquestModVariables.MapVariables.get(world).BreakPoints = 0;
			InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken = 0;
			InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken = 0;
			InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			InvincibleConquestModVariables.MapVariables.get(world).HOSTILETimeOccupied = 0;
			InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			InvincibleConquestModVariables.MapVariables.get(world).UnoccupiedTimer = 0;
			InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			if ((entity.level().dimension()) == Level.OVERWORLD) {
				InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover = "Earth";
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).HomeFaction = InvincibleConquestModVariables.MapVariables.get(world).EarthOwner;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			}
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:moon_world"))) {
				InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover = "Moon";
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).HomeFaction = InvincibleConquestModVariables.MapVariables.get(world).MoonOwner;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			}
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:mars_world"))) {
				InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover = "Mars";
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).HomeFaction = InvincibleConquestModVariables.MapVariables.get(world).MarsOwner;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			}
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:viltrum_world"))) {
				InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover = "Viltrum";
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).HomeFaction = InvincibleConquestModVariables.MapVariables.get(world).ViltrumOwner;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			}
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:talescria_world"))) {
				InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover = "Talescria";
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).HomeFaction = InvincibleConquestModVariables.MapVariables.get(world).TalescriaOwner;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			}
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(
						Component.literal(("<> " + InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover + " is being invaded by " + InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("A planet is currently being invaded!"), true);
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
