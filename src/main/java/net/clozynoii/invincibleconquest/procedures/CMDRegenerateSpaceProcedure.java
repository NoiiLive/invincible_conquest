package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModEntities;
import net.clozynoii.invincibleconquest.entity.WhiteSunEntity;
import net.clozynoii.invincibleconquest.entity.ViltrumEntity;
import net.clozynoii.invincibleconquest.entity.TalescriaEntity;
import net.clozynoii.invincibleconquest.entity.SunEntity;
import net.clozynoii.invincibleconquest.entity.RedSunEntity;
import net.clozynoii.invincibleconquest.entity.OrangeSunEntity;
import net.clozynoii.invincibleconquest.entity.MoonEntity;
import net.clozynoii.invincibleconquest.entity.MarsEntity;
import net.clozynoii.invincibleconquest.entity.EarthEntity;
import net.clozynoii.invincibleconquest.entity.BlueSunEntity;

public class CMDRegenerateSpaceProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:space"))) {
			if (world instanceof ServerLevel _server) {
				for (Entity entityiterator : _server.getAllEntities()) {
					if (entityiterator instanceof SunEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof RedSunEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof OrangeSunEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof WhiteSunEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof BlueSunEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof EarthEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof MoonEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof MarsEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof ViltrumEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof TalescriaEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
			InvincibleConquestModVariables.MapVariables.get(world).SpaceGenerated = true;
			InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleConquestModEntities.SUN.get().spawn(_level, new BlockPos(0, 75, 0), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleConquestModEntities.WHITE_SUN.get().spawn(_level, new BlockPos(1100, 75, 1100), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleConquestModEntities.ORANGE_SUN.get().spawn(_level, new BlockPos(800, 75, 800), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleConquestModEntities.EARTH.get().spawn(_level, new BlockPos(135, 75, 135), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleConquestModEntities.MOON.get().spawn(_level, new BlockPos(150, 90, 150), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleConquestModEntities.MARS.get().spawn(_level, new BlockPos(200, 75, 200), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleConquestModEntities.VILTRUM.get().spawn(_level, new BlockPos(1000, 75, 1000), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleConquestModEntities.TALESCRIA.get().spawn(_level, new BlockPos(700, 75, 900), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Space Regenerated!"), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Run this command in Space."), false);
		}
	}
}
