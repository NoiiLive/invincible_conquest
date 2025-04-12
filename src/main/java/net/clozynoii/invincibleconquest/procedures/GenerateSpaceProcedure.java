package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModEntities;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

public class GenerateSpaceProcedure {
	public static void execute(LevelAccessor world) {
		if (InvincibleConquestModVariables.MapVariables.get(world).SpaceGenerated == false) {
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
			InvincibleConquestMod.LOGGER.info("Space Generated!");
		}
	}
}
