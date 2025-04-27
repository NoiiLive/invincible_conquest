package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class CounterProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

private static void execute(
@Nullable Event event
) {
if (<=0) {}
}
}
