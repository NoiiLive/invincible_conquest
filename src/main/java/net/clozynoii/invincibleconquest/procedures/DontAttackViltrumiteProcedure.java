package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class DontAttackViltrumiteProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player) {
			if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Viltrum Empire")) {
				return false;
			}
		}
		return true;
	}
}
