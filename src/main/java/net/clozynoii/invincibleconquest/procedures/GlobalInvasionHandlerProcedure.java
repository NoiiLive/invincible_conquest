package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import javax.annotation.Nullable;

import java.util.ArrayList;

@EventBusSubscriber
public class GlobalInvasionHandlerProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		boolean occupied = false;
		if (!(InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("")) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Earth")) {
						if ((entityiterator.level().dimension()) == Level.OVERWORLD) {
							InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied = true;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						}
					}
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Moon")) {
						if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:moon_world"))) {
							InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied = true;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						}
					}
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Mars")) {
						if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:mars_world"))) {
							InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied = true;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						}
					}
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Viltrum")) {
						if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:viltrum_world"))) {
							InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied = true;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						}
					}
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Talescria")) {
						if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:talescria_world"))) {
							InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied = true;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						}
					}
				}
			}
			if (InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied == true) {
				InvincibleConquestModVariables.MapVariables.get(world).HOSTILETimeOccupied = InvincibleConquestModVariables.MapVariables.get(world).HOSTILETimeOccupied + 1;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				if (InvincibleConquestModVariables.MapVariables.get(world).UnoccupiedTimer > 0) {
					InvincibleConquestModVariables.MapVariables.get(world).UnoccupiedTimer = InvincibleConquestModVariables.MapVariables.get(world).UnoccupiedTimer - 1;
					InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				}
			} else if (InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied == false) {
				InvincibleConquestModVariables.MapVariables.get(world).UnoccupiedTimer = InvincibleConquestModVariables.MapVariables.get(world).UnoccupiedTimer + 1;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				if (InvincibleConquestModVariables.MapVariables.get(world).HOSTILETimeOccupied > 0) {
					InvincibleConquestModVariables.MapVariables.get(world).HOSTILETimeOccupied = InvincibleConquestModVariables.MapVariables.get(world).HOSTILETimeOccupied - 1;
					InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken >= 10) {
				InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore + 1;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			}
			if (InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken >= 5000) {
				InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				if (InvincibleConquestModVariables.MapVariables.get(world).BreakPoints < 50) {
					InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore + 1;
					InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
					InvincibleConquestModVariables.MapVariables.get(world).BreakPoints = InvincibleConquestModVariables.MapVariables.get(world).BreakPoints + 1;
					InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (InvincibleConquestModVariables.MapVariables.get(world).HOSTILETimeOccupied >= 1200) {
				InvincibleConquestModVariables.MapVariables.get(world).HOSTILETimeOccupied = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore + 1;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			}
			if (InvincibleConquestModVariables.MapVariables.get(world).UnoccupiedTimer >= 600) {
				InvincibleConquestModVariables.MapVariables.get(world).UnoccupiedTimer = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore - 2;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			}
			if (InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore >= 100) {
				InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).HOSTILETimeOccupied = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).UnoccupiedTimer = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).BreakPoints = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied = false;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Earth")) {
					InvincibleConquestModVariables.MapVariables.get(world).EarthOwner = InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction;
					InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				} else if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Moon")) {
					InvincibleConquestModVariables.MapVariables.get(world).MoonOwner = InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction;
					InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				} else if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Mars")) {
					InvincibleConquestModVariables.MapVariables.get(world).MarsOwner = InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction;
					InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				} else if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Viltrum")) {
					InvincibleConquestModVariables.MapVariables.get(world).ViltrumOwner = InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction;
					InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				} else if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Talescria")) {
					InvincibleConquestModVariables.MapVariables.get(world).TalescriaOwner = InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction;
					InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				}
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Earth")) {
						if ((entityiterator.level().dimension()) == Level.OVERWORLD
								&& (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
							{
								InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
								_vars.PlayerReputation = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation + 100;
								_vars.syncPlayerVariables(entityiterator);
							}
						}
					}
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Moon")) {
						if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:moon_world"))
								&& (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
							{
								InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
								_vars.PlayerReputation = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation + 100;
								_vars.syncPlayerVariables(entityiterator);
							}
						}
					}
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Mars")) {
						if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:mars_world"))
								&& (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
							{
								InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
								_vars.PlayerReputation = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation + 100;
								_vars.syncPlayerVariables(entityiterator);
							}
						}
					}
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Viltrum")) {
						if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:viltrum_world"))
								&& (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
							{
								InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
								_vars.PlayerReputation = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation + 100;
								_vars.syncPlayerVariables(entityiterator);
							}
						}
					}
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Talescria")) {
						if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:talescria_world"))
								&& (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
							{
								InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
								_vars.PlayerReputation = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation + 100;
								_vars.syncPlayerVariables(entityiterator);
							}
						}
					}
				}
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(
							Component.literal(("<> " + InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction + " has successfully taken over " + InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover)), false);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("(+100 Rep to Invading Faction Members)"), false);
				InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover = "";
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).HomeFaction = "";
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction = "";
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			} else if (InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore <= -100) {
				InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).HOSTILETimeOccupied = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).UnoccupiedTimer = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).BreakPoints = 0;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied = false;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Earth")) {
						if ((entityiterator.level().dimension()) == Level.OVERWORLD
								&& (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).HomeFaction)) {
							{
								InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
								_vars.PlayerReputation = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation + 100;
								_vars.syncPlayerVariables(entityiterator);
							}
						}
					}
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Moon")) {
						if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:moon_world"))
								&& (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).HomeFaction)) {
							{
								InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
								_vars.PlayerReputation = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation + 100;
								_vars.syncPlayerVariables(entityiterator);
							}
						}
					}
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Mars")) {
						if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:mars_world"))
								&& (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).HomeFaction)) {
							{
								InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
								_vars.PlayerReputation = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation + 100;
								_vars.syncPlayerVariables(entityiterator);
							}
						}
					}
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Viltrum")) {
						if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:viltrum_world"))
								&& (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).HomeFaction)) {
							{
								InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
								_vars.PlayerReputation = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation + 100;
								_vars.syncPlayerVariables(entityiterator);
							}
						}
					}
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Talescria")) {
						if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:talescria_world"))
								&& (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).HomeFaction)) {
							{
								InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
								_vars.PlayerReputation = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation + 100;
								_vars.syncPlayerVariables(entityiterator);
							}
						}
					}
				}
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(
							Component.literal(("<> " + InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction + " has failed to take over " + InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover)), false);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("(+100 Rep to Home Faction Members)"), false);
				InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover = "";
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).HomeFaction = "";
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction = "";
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
