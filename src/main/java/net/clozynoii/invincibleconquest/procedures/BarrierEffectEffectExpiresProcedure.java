package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.entity.AtomShieldEntity;

import java.util.Comparator;

public class BarrierEffectEffectExpiresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.isClientSide()) {
			SetupAnimationsProcedure.setAnimationClientside((Player) entity, "reset", false);
		}
		if (!world.isClientSide()) {
			if (entity instanceof Player)
				PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("reset", entity.getId(), false));
		}
		if (!world.getEntitiesOfClass(AtomShieldEntity.class, AABB.ofSize(new Vec3(x, y, z), 25, 25, 25), e -> true).isEmpty()) {
			if (!((Entity) world.getEntitiesOfClass(AtomShieldEntity.class, AABB.ofSize(new Vec3(x, y, z), 25, 25, 25), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
				((Entity) world.getEntitiesOfClass(AtomShieldEntity.class, AABB.ofSize(new Vec3(x, y, z), 25, 25, 25), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, x, (y + 1), z, 15, 0.1, 0.1, 0.1, (-0.4));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, (y + 1), z, 15, 0.1, 0.1, 0.1, (-0.4));
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
		}
	}
}
