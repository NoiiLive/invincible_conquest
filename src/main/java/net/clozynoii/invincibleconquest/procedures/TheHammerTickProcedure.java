package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class TheHammerTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof TheHammerEntity _datEntI ? _datEntI.getEntityData().get(TheHammerEntity.DATA_Despawn) : 0) > 0) {
			if (entity instanceof TheHammerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(TheHammerEntity.DATA_Despawn, (int) ((entity instanceof TheHammerEntity _datEntI ? _datEntI.getEntityData().get(TheHammerEntity.DATA_Despawn) : 0) - 1));
		} else if ((entity instanceof TheHammerEntity _datEntI ? _datEntI.getEntityData().get(TheHammerEntity.DATA_Despawn) : 0) == 0) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 15, Level.ExplosionInteraction.MOB);
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable")))) {
						entityiterator.invulnerableTime = 0;
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.IN_FIRE)), 7);
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.STUN, 20, 9, false, false));
					}
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.EXPLOSION, x, (y + 1), z, 50, 5, 5, 5, 0);
	}
}
