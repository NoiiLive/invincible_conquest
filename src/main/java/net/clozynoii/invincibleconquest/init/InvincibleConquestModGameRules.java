
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class InvincibleConquestModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> SPAWN_INVINCIBLE_MOBS;
	public static GameRules.Key<GameRules.BooleanValue> INVINCIBLE_ABILITY_DESTRUCTION;
	public static GameRules.Key<GameRules.IntegerValue> FLAXAN_TIME_DILATION;
	public static GameRules.Key<GameRules.BooleanValue> INVINCIBLE_ABILITY_BLOCK_DROP;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		SPAWN_INVINCIBLE_MOBS = GameRules.register("spawnInvincibleMobs", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(true));
		INVINCIBLE_ABILITY_DESTRUCTION = GameRules.register("invincibleAbilityDestruction", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		FLAXAN_TIME_DILATION = GameRules.register("flaxanTimeDilation", GameRules.Category.UPDATES, GameRules.IntegerValue.create(2));
		INVINCIBLE_ABILITY_BLOCK_DROP = GameRules.register("invincibleAbilityBlockDrop", GameRules.Category.DROPS, GameRules.BooleanValue.create(false));
	}
}
