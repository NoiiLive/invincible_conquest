package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HostileInvasionBreakProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover).equals("")) {
			if (entity instanceof Player) {
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals(InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction)) {
					InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken = InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken + 1;
					InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
				}
			}
		}
	}
}
