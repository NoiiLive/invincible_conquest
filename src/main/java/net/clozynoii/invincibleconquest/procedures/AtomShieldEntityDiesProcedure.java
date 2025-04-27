package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.bus.api.Event;

public class AtomShieldEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, x, (y + 1), z, 15, 0.1, 0.1, 0.1, 0.5);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, (y + 1), z, 15, 0.1, 0.1, 0.1, 0.5);
			int horizontalRadiusSquare = (int) 2 - 1;
			int verticalRadiusSquare = (int) 2 - 1;
			int yIterationsSquare = verticalRadiusSquare;
			for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
				for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
					for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
						// Execute the desired statements within the square/cube
						world.levelEvent(2001, BlockPos.containing(x + xi, y + i, z + zi), Block.getId(Blocks.PINK_STAINED_GLASS_PANE.defaultBlockState()));
					}
				}
			}
			if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _entity)
				_entity.removeEffect(InvincibleConquestModMobEffects.DELETED_MOD_ELEMENT);
		}
	}
}
