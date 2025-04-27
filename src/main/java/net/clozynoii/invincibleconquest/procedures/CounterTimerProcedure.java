package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class CounterTimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

private static void execute(
@Nullable Event event
) {
if (>0) {}
}
}
