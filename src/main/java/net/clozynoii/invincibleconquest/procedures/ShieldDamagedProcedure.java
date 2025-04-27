package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.entity.AtomShieldEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ShieldDamagedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getDirectEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		execute(null, world, x, y, z, entity, immediatesourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (entity instanceof AtomShieldEntity) {
			if (!(entity instanceof TamableAnimal _tamIsTamedBy && immediatesourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
				world.levelEvent(2001,
						new BlockPos(
								immediatesourceentity.level()
										.clip(new ClipContext(immediatesourceentity.getEyePosition(1f), immediatesourceentity.getEyePosition(1f).add(immediatesourceentity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
												immediatesourceentity))
										.getBlockPos().getX(),
								immediatesourceentity.level()
										.clip(new ClipContext(immediatesourceentity.getEyePosition(1f), immediatesourceentity.getEyePosition(1f).add(immediatesourceentity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
												immediatesourceentity))
										.getBlockPos().getY(),
								immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1f), immediatesourceentity.getEyePosition(1f).add(immediatesourceentity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE,
										ClipContext.Fluid.NONE, immediatesourceentity)).getBlockPos().getZ()),
						Block.getId(Blocks.PINK_STAINED_GLASS.defaultBlockState()));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.hit")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.hit")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.hit")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.hit")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.break")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.break")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
			}
		}
	}
}
