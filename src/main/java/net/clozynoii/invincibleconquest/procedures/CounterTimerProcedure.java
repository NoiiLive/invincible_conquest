package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CounterTimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).CounterAttack > 0) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.CounterAttack = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).CounterAttack - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
