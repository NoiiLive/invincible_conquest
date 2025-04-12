
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.clozynoii.invincibleconquest.block.MoonStoneBlock;
import net.clozynoii.invincibleconquest.block.MoonSandBlock;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

public class InvincibleConquestModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(InvincibleConquestMod.MODID);
	public static final DeferredBlock<Block> MOON_SAND = REGISTRY.register("moon_sand", MoonSandBlock::new);
	public static final DeferredBlock<Block> MOON_STONE = REGISTRY.register("moon_stone", MoonStoneBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
