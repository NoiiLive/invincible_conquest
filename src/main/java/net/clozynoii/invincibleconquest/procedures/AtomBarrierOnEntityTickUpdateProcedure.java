package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class AtomBarrierOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			{
				Entity _ent = entity;
				_ent.teleportTo(((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getX()), ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getY()),
						((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getZ()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getX()), ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getY()),
							((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getZ()), _ent.getYRot(), _ent.getXRot());
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (!(entity instanceof TamableAnimal _tamIsTamedBy && entityiterator instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
							magnitude = Math
									.sqrt(entityiterator.getLookAngle().x * entityiterator.getLookAngle().x + entityiterator.getLookAngle().y * entityiterator.getLookAngle().y + entityiterator.getLookAngle().z * entityiterator.getLookAngle().z);
							vecX = entityiterator.getLookAngle().x / magnitude;
							vecY = entityiterator.getLookAngle().y / magnitude;
							vecZ = entityiterator.getLookAngle().z / magnitude;
							vecX = vecX * (-0.1);
							vecY = vecY * (-0.1);
							vecZ = vecZ * (-0.1);
							entityiterator.push(vecX, vecY, vecZ);
						}
					}
				}
			}
		}
	}
}
