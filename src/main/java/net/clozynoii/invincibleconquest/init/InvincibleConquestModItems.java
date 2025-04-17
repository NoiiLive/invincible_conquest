
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.clozynoii.invincibleconquest.item.ViltrumiteUniformItem;
import net.clozynoii.invincibleconquest.item.SpaceHelmetItem;
import net.clozynoii.invincibleconquest.item.SelectionBookItem;
import net.clozynoii.invincibleconquest.item.RexSplodeSuitItem;
import net.clozynoii.invincibleconquest.item.OmnivincibleSuitItem;
import net.clozynoii.invincibleconquest.item.OmniManSuitItem;
import net.clozynoii.invincibleconquest.item.MultiPaulSuitItem;
import net.clozynoii.invincibleconquest.item.MaulerTwinSuitItem;
import net.clozynoii.invincibleconquest.item.InvincibleSuitVeilItem;
import net.clozynoii.invincibleconquest.item.InvincibleSuitSinisterItem;
import net.clozynoii.invincibleconquest.item.InvincibleSuitMohawkItem;
import net.clozynoii.invincibleconquest.item.InvincibleSuitItem;
import net.clozynoii.invincibleconquest.item.InvincibleSuitDarkItem;
import net.clozynoii.invincibleconquest.item.InvincibleSuitBlueItem;
import net.clozynoii.invincibleconquest.item.GalacticMapItem;
import net.clozynoii.invincibleconquest.item.FlaxanGunItem;
import net.clozynoii.invincibleconquest.item.FlaxanArmorItem;
import net.clozynoii.invincibleconquest.item.DupliKateSuitItem;
import net.clozynoii.invincibleconquest.item.AtomEveSuitItem;
import net.clozynoii.invincibleconquest.item.AngstromOutfitItem;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

public class InvincibleConquestModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(InvincibleConquestMod.MODID);
	public static final DeferredItem<Item> SELECTION_BOOK = REGISTRY.register("selection_book", SelectionBookItem::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_HELMET = REGISTRY.register("invincible_suit_helmet", InvincibleSuitItem.Helmet::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_CHESTPLATE = REGISTRY.register("invincible_suit_chestplate", InvincibleSuitItem.Chestplate::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_LEGGINGS = REGISTRY.register("invincible_suit_leggings", InvincibleSuitItem.Leggings::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_BOOTS = REGISTRY.register("invincible_suit_boots", InvincibleSuitItem.Boots::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_BLUE_HELMET = REGISTRY.register("invincible_suit_blue_helmet", InvincibleSuitBlueItem.Helmet::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_BLUE_CHESTPLATE = REGISTRY.register("invincible_suit_blue_chestplate", InvincibleSuitBlueItem.Chestplate::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_BLUE_LEGGINGS = REGISTRY.register("invincible_suit_blue_leggings", InvincibleSuitBlueItem.Leggings::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_BLUE_BOOTS = REGISTRY.register("invincible_suit_blue_boots", InvincibleSuitBlueItem.Boots::new);
	public static final DeferredItem<Item> OMNI_MAN_SUIT_CHESTPLATE = REGISTRY.register("omni_man_suit_chestplate", OmniManSuitItem.Chestplate::new);
	public static final DeferredItem<Item> OMNI_MAN_SUIT_LEGGINGS = REGISTRY.register("omni_man_suit_leggings", OmniManSuitItem.Leggings::new);
	public static final DeferredItem<Item> OMNI_MAN_SUIT_BOOTS = REGISTRY.register("omni_man_suit_boots", OmniManSuitItem.Boots::new);
	public static final DeferredItem<Item> VILTRUMITE_UNIFORM_CHESTPLATE = REGISTRY.register("viltrumite_uniform_chestplate", ViltrumiteUniformItem.Chestplate::new);
	public static final DeferredItem<Item> VILTRUMITE_UNIFORM_LEGGINGS = REGISTRY.register("viltrumite_uniform_leggings", ViltrumiteUniformItem.Leggings::new);
	public static final DeferredItem<Item> VILTRUMITE_UNIFORM_BOOTS = REGISTRY.register("viltrumite_uniform_boots", ViltrumiteUniformItem.Boots::new);
	public static final DeferredItem<Item> REX_SPLODE_SUIT_HELMET = REGISTRY.register("rex_splode_suit_helmet", RexSplodeSuitItem.Helmet::new);
	public static final DeferredItem<Item> REX_SPLODE_SUIT_CHESTPLATE = REGISTRY.register("rex_splode_suit_chestplate", RexSplodeSuitItem.Chestplate::new);
	public static final DeferredItem<Item> REX_SPLODE_SUIT_LEGGINGS = REGISTRY.register("rex_splode_suit_leggings", RexSplodeSuitItem.Leggings::new);
	public static final DeferredItem<Item> REX_SPLODE_SUIT_BOOTS = REGISTRY.register("rex_splode_suit_boots", RexSplodeSuitItem.Boots::new);
	public static final DeferredItem<Item> ANGSTROM_OUTFIT_HELMET = REGISTRY.register("angstrom_outfit_helmet", AngstromOutfitItem.Helmet::new);
	public static final DeferredItem<Item> ANGSTROM_OUTFIT_CHESTPLATE = REGISTRY.register("angstrom_outfit_chestplate", AngstromOutfitItem.Chestplate::new);
	public static final DeferredItem<Item> ANGSTROM_OUTFIT_LEGGINGS = REGISTRY.register("angstrom_outfit_leggings", AngstromOutfitItem.Leggings::new);
	public static final DeferredItem<Item> ANGSTROM_OUTFIT_BOOTS = REGISTRY.register("angstrom_outfit_boots", AngstromOutfitItem.Boots::new);
	public static final DeferredItem<Item> DUPLI_KATE_SUIT_CHESTPLATE = REGISTRY.register("dupli_kate_suit_chestplate", DupliKateSuitItem.Chestplate::new);
	public static final DeferredItem<Item> DUPLI_KATE_SUIT_LEGGINGS = REGISTRY.register("dupli_kate_suit_leggings", DupliKateSuitItem.Leggings::new);
	public static final DeferredItem<Item> DUPLI_KATE_SUIT_BOOTS = REGISTRY.register("dupli_kate_suit_boots", DupliKateSuitItem.Boots::new);
	public static final DeferredItem<Item> MULTI_PAUL_SUIT_CHESTPLATE = REGISTRY.register("multi_paul_suit_chestplate", MultiPaulSuitItem.Chestplate::new);
	public static final DeferredItem<Item> MULTI_PAUL_SUIT_LEGGINGS = REGISTRY.register("multi_paul_suit_leggings", MultiPaulSuitItem.Leggings::new);
	public static final DeferredItem<Item> MULTI_PAUL_SUIT_BOOTS = REGISTRY.register("multi_paul_suit_boots", MultiPaulSuitItem.Boots::new);
	public static final DeferredItem<Item> MAULER_TWIN_SUIT_CHESTPLATE = REGISTRY.register("mauler_twin_suit_chestplate", MaulerTwinSuitItem.Chestplate::new);
	public static final DeferredItem<Item> MAULER_TWIN_SUIT_LEGGINGS = REGISTRY.register("mauler_twin_suit_leggings", MaulerTwinSuitItem.Leggings::new);
	public static final DeferredItem<Item> FLAXAN_ARMOR_CHESTPLATE = REGISTRY.register("flaxan_armor_chestplate", FlaxanArmorItem.Chestplate::new);
	public static final DeferredItem<Item> FLAXAN_ARMOR_LEGGINGS = REGISTRY.register("flaxan_armor_leggings", FlaxanArmorItem.Leggings::new);
	public static final DeferredItem<Item> FLAXAN_ARMOR_BOOTS = REGISTRY.register("flaxan_armor_boots", FlaxanArmorItem.Boots::new);
	public static final DeferredItem<Item> FLAXAN_GUN = REGISTRY.register("flaxan_gun", FlaxanGunItem::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_SINISTER_HELMET = REGISTRY.register("invincible_suit_sinister_helmet", InvincibleSuitSinisterItem.Helmet::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_SINISTER_CHESTPLATE = REGISTRY.register("invincible_suit_sinister_chestplate", InvincibleSuitSinisterItem.Chestplate::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_SINISTER_LEGGINGS = REGISTRY.register("invincible_suit_sinister_leggings", InvincibleSuitSinisterItem.Leggings::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_SINISTER_BOOTS = REGISTRY.register("invincible_suit_sinister_boots", InvincibleSuitSinisterItem.Boots::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_VEIL_HELMET = REGISTRY.register("invincible_suit_veil_helmet", InvincibleSuitVeilItem.Helmet::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_VEIL_CHESTPLATE = REGISTRY.register("invincible_suit_veil_chestplate", InvincibleSuitVeilItem.Chestplate::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_VEIL_LEGGINGS = REGISTRY.register("invincible_suit_veil_leggings", InvincibleSuitVeilItem.Leggings::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_VEIL_BOOTS = REGISTRY.register("invincible_suit_veil_boots", InvincibleSuitVeilItem.Boots::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_DARK_HELMET = REGISTRY.register("invincible_suit_dark_helmet", InvincibleSuitDarkItem.Helmet::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_DARK_CHESTPLATE = REGISTRY.register("invincible_suit_dark_chestplate", InvincibleSuitDarkItem.Chestplate::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_DARK_LEGGINGS = REGISTRY.register("invincible_suit_dark_leggings", InvincibleSuitDarkItem.Leggings::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_DARK_BOOTS = REGISTRY.register("invincible_suit_dark_boots", InvincibleSuitDarkItem.Boots::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_MOHAWK_CHESTPLATE = REGISTRY.register("invincible_suit_mohawk_chestplate", InvincibleSuitMohawkItem.Chestplate::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_MOHAWK_LEGGINGS = REGISTRY.register("invincible_suit_mohawk_leggings", InvincibleSuitMohawkItem.Leggings::new);
	public static final DeferredItem<Item> INVINCIBLE_SUIT_MOHAWK_BOOTS = REGISTRY.register("invincible_suit_mohawk_boots", InvincibleSuitMohawkItem.Boots::new);
	public static final DeferredItem<Item> INVINCIBLE_SPAWN_EGG = REGISTRY.register("invincible_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.INVINCIBLE, -2488, -13712144, new Item.Properties()));
	public static final DeferredItem<Item> INVINCIBLE_BLUE_SPAWN_EGG = REGISTRY.register("invincible_blue_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.INVINCIBLE_BLUE, -13604698, -14079186, new Item.Properties()));
	public static final DeferredItem<Item> INVINCIBLE_SINISTER_SPAWN_EGG = REGISTRY.register("invincible_sinister_spawn_egg",
			() -> new DeferredSpawnEggItem(InvincibleConquestModEntities.INVINCIBLE_SINISTER, -330923, -14079445, new Item.Properties()));
	public static final DeferredItem<Item> INVINCIBLE_MOHAWK_SPAWN_EGG = REGISTRY.register("invincible_mohawk_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.INVINCIBLE_MOHAWK, -14342875, -11764340, new Item.Properties()));
	public static final DeferredItem<Item> INVINCIBLE_MASKLESS_SPAWN_EGG = REGISTRY.register("invincible_maskless_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.INVINCIBLE_MASKLESS, -2488, -13712144, new Item.Properties()));
	public static final DeferredItem<Item> INVINCIBLE_VEIL_SPAWN_EGG = REGISTRY.register("invincible_veil_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.INVINCIBLE_VEIL, -13712144, -2488, new Item.Properties()));
	public static final DeferredItem<Item> INVINCIBLE_DARK_SPAWN_EGG = REGISTRY.register("invincible_dark_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.INVINCIBLE_DARK, -11764340, -14342875, new Item.Properties()));
	public static final DeferredItem<Item> VILTRUMITE_MARK_SPAWN_EGG = REGISTRY.register("viltrumite_mark_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.VILTRUMITE_MARK, -1, -6710887, new Item.Properties()));
	public static final DeferredItem<Item> OMNIVINCIBLE_SUIT_HELMET = REGISTRY.register("omnivincible_suit_helmet", OmnivincibleSuitItem.Helmet::new);
	public static final DeferredItem<Item> OMNIVINCIBLE_SUIT_CHESTPLATE = REGISTRY.register("omnivincible_suit_chestplate", OmnivincibleSuitItem.Chestplate::new);
	public static final DeferredItem<Item> OMNIVINCIBLE_SUIT_LEGGINGS = REGISTRY.register("omnivincible_suit_leggings", OmnivincibleSuitItem.Leggings::new);
	public static final DeferredItem<Item> OMNIVINCIBLE_SUIT_BOOTS = REGISTRY.register("omnivincible_suit_boots", OmnivincibleSuitItem.Boots::new);
	public static final DeferredItem<Item> OMNIVINCIBLE_SPAWN_EGG = REGISTRY.register("omnivincible_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.OMNIVINCIBLE, -1, -3853517, new Item.Properties()));
	public static final DeferredItem<Item> ATOM_EVE_SUIT_CHESTPLATE = REGISTRY.register("atom_eve_suit_chestplate", AtomEveSuitItem.Chestplate::new);
	public static final DeferredItem<Item> ATOM_EVE_SUIT_LEGGINGS = REGISTRY.register("atom_eve_suit_leggings", AtomEveSuitItem.Leggings::new);
	public static final DeferredItem<Item> ATOM_EVE_SUIT_BOOTS = REGISTRY.register("atom_eve_suit_boots", AtomEveSuitItem.Boots::new);
	public static final DeferredItem<Item> DINOSAUR_SPAWN_EGG = REGISTRY.register("dinosaur_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.DINOSAUR, -7510963, -12045526, new Item.Properties()));
	public static final DeferredItem<Item> MARTIAN_SPAWN_EGG = REGISTRY.register("martian_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.MARTIAN, -7760529, -1312519, new Item.Properties()));
	public static final DeferredItem<Item> MARTIAN_SPEARMAN_SPAWN_EGG = REGISTRY.register("martian_spearman_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.MARTIAN_SPEARMAN, -7760529, -918532, new Item.Properties()));
	public static final DeferredItem<Item> FLAXAN_SPAWN_EGG = REGISTRY.register("flaxan_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.FLAXAN, -12427647, -7879821, new Item.Properties()));
	public static final DeferredItem<Item> FLAXAN_GUNMAN_SPAWN_EGG = REGISTRY.register("flaxan_gunman_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.FLAXAN_GUNMAN, -12427647, -7879821, new Item.Properties()));
	public static final DeferredItem<Item> OMNI_MAN_SPAWN_EGG = REGISTRY.register("omni_man_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.OMNI_MAN, -1576451, -1947571, new Item.Properties()));
	public static final DeferredItem<Item> ANGSTROM_SPAWN_EGG = REGISTRY.register("angstrom_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.ANGSTROM, -14408152, -8974060, new Item.Properties()));
	public static final DeferredItem<Item> REX_SPLODE_SPAWN_EGG = REGISTRY.register("rex_splode_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.REX_SPLODE, -4303820, -1453499, new Item.Properties()));
	public static final DeferredItem<Item> ATOM_EVE_SPAWN_EGG = REGISTRY.register("atom_eve_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.ATOM_EVE, -406311, -424808, new Item.Properties()));
	public static final DeferredItem<Item> DUPLI_KATE_SPAWN_EGG = REGISTRY.register("dupli_kate_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.DUPLI_KATE, -4279071, -12503722, new Item.Properties()));
	public static final DeferredItem<Item> MULTI_PAUL_SPAWN_EGG = REGISTRY.register("multi_paul_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.MULTI_PAUL, -12503722, -4279071, new Item.Properties()));
	public static final DeferredItem<Item> BATTLE_BEAST_SPAWN_EGG = REGISTRY.register("battle_beast_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.BATTLE_BEAST, -1576451, -14013905, new Item.Properties()));
	public static final DeferredItem<Item> MAULER_TWIN_SPAWN_EGG = REGISTRY.register("mauler_twin_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.MAULER_TWIN, -9594700, -1971472, new Item.Properties()));
	public static final DeferredItem<Item> VILTRUMITE_MALE_SPAWN_EGG = REGISTRY.register("viltrumite_male_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.VILTRUMITE_MALE, -1641998, -7759976, new Item.Properties()));
	public static final DeferredItem<Item> VILTRUMITE_FEMALE_SPAWN_EGG = REGISTRY.register("viltrumite_female_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.VILTRUMITE_FEMALE, -1641998, -7759976, new Item.Properties()));
	public static final DeferredItem<Item> MOON_SAND = block(InvincibleConquestModBlocks.MOON_SAND);
	public static final DeferredItem<Item> MOON_STONE = block(InvincibleConquestModBlocks.MOON_STONE);
	public static final DeferredItem<Item> GALACTIC_MAP = REGISTRY.register("galactic_map", GalacticMapItem::new);
	public static final DeferredItem<Item> CONQUEST_SPAWN_EGG = REGISTRY.register("conquest_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.CONQUEST, -1576451, -6245708, new Item.Properties()));
	public static final DeferredItem<Item> CECIL_SPAWN_EGG = REGISTRY.register("cecil_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.CECIL, -13222305, -4474953, new Item.Properties()));
	public static final DeferredItem<Item> ANISSA_SPAWN_EGG = REGISTRY.register("anissa_spawn_egg", () -> new DeferredSpawnEggItem(InvincibleConquestModEntities.ANISSA, -1641998, -7759976, new Item.Properties()));
	public static final DeferredItem<Item> SPACE_HELMET_HELMET = REGISTRY.register("space_helmet_helmet", SpaceHelmetItem.Helmet::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
