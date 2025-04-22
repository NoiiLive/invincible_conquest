package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class TestItemRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlastAbilityProcedure.execute(world, x, y, z, entity);
	}
}
