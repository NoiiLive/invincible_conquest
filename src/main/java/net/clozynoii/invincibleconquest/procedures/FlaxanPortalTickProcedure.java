package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class FlaxanPortalTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof FlaxanPortalEntity _datEntI ? _datEntI.getEntityData().get(FlaxanPortalEntity.DATA_Despawn) : 0) > 0) {
			if (entity instanceof FlaxanPortalEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlaxanPortalEntity.DATA_Despawn, (int) ((entity instanceof FlaxanPortalEntity _datEntI ? _datEntI.getEntityData().get(FlaxanPortalEntity.DATA_Despawn) : 0) - 1));
		} else if ((entity instanceof FlaxanPortalEntity _datEntI ? _datEntI.getEntityData().get(FlaxanPortalEntity.DATA_Despawn) : 0) == 0) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
						ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:deleted_mod_element"));
						if (_player.level().dimension() == destinationType)
							return;
						ServerLevel nextLevel = _player.server.getLevel(destinationType);
						if (nextLevel != null) {
							_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
							_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
							_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
							for (MobEffectInstance _effectinstance : _player.getActiveEffects())
								_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
							_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.END_ROD, x, (y + 1), z, 1, 0.1, 0.1, 0.1, 0.1);
				}
			}
		}
	}
}
