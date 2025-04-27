package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class AttackCounterTriggerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
Entity entity,
Entity sourceentity ) {
if (
entity == null ||
sourceentity == null ) return ;
if (entity instanceof Player) {if (>0) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\u00A76\u00A7l COUNTER"), true);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")),
SoundSource.NEUTRAL, 1, 1, false);
}
}
if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.shoot")),
SoundSource.NEUTRAL, 1, 2);
} else {
_level.playLocalSound(x, y, z,
BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.shoot")),
SoundSource.NEUTRAL, 1, 2, false);
}
}
if(sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.STUN, 25, 8, false, false));if (world instanceof ServerLevel _level)
_level.sendParticles(ParticleTypes.CRIT, x, (y+1), z, 15, 0.1, 0.1, 0.1, 0.6);if (world instanceof ServerLevel _level)
_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, (y+1), z, 15, 0.1, 0.1, 0.1, 0.6);}}
}
}
