package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class HammerSpawnerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("hammerspawnertimer", (entity.getPersistentData().getDouble("hammerspawnertimer") - 1));
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A7l" + new java.text.DecimalFormat("#").format(entity.getPersistentData().getDouble("hammerspawnertimer") / 20) + " \u00A7rSeconds Until Impact.")), true);
			}
		}
	}
}
