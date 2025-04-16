package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class GlassBreakOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		int horizontalRadiusSquare = (int) (8 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 30) - 1;
		int verticalRadiusSquare = (int) (8 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 30) - 1;
		int yIterationsSquare = verticalRadiusSquare;
		for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
			for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
				for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
					// Execute the desired statements within the square/cube
					if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("minecraft:glass")))) {
						world.destroyBlock(BlockPos.containing(x + xi, y + i, z + zi), false);
					}
				}
			}
		}
	}
}
