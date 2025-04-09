package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HostileInvasionKillProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!(InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("")) {
			if (sourceentity instanceof Player) {
				if ((entity.level().dimension()) == Level.OVERWORLD) {
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Earth")) {
						if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction) && entity instanceof Player) {
							InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore + 5;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						} else if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).HomeFaction) && entity instanceof Player) {
							InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore - 10;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
							InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied = false;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						} else if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
							InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken = InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken + 1;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						}
					}
				} else if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:moon_world"))) {
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Moon")) {
						if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction) && entity instanceof Player) {
							InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore + 5;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						} else if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).HomeFaction) && entity instanceof Player) {
							InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore - 10;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
							InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied = false;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						} else if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
							InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken = InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken + 1;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						}
					}
				} else if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:mars_world"))) {
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Mars")) {
						if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction) && entity instanceof Player) {
							InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore + 5;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						} else if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).HomeFaction) && entity instanceof Player) {
							InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore - 10;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
							InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied = false;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						} else if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
							InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken = InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken + 1;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						}
					}
				} else if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:viltrum_world"))) {
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Viltrum")) {
						if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction) && entity instanceof Player) {
							InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore + 5;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						} else if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).HomeFaction) && entity instanceof Player) {
							InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore - 10;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
							InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied = false;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						} else if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
							InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken = InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken + 1;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						}
					}
				} else if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:talescria_world"))) {
					if ((InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("Talescria")) {
						if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction) && entity instanceof Player) {
							InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore + 5;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						} else if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).HomeFaction) && entity instanceof Player) {
							InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore = InvincibleConquestModVariables.MapVariables.get(world).TakeoverScore - 10;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
							InvincibleConquestModVariables.MapVariables.get(world).PlanetOccupied = false;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						} else if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
							InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken = InvincibleConquestModVariables.MapVariables.get(world).HOSTILELivesTaken + 1;
							InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
						}
					}
				}
			}
		}
	}
}
