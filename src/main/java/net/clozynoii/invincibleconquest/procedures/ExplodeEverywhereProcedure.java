package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class ExplodeEverywhereProcedure {
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
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Explode")) {
			if (entity.getPersistentData().getDouble("rexSPLODE") > 1) {
				entity.getPersistentData().putDouble("rexSPLODE", (entity.getPersistentData().getDouble("rexSPLODE") - 1));
			}
		}
	}
}
