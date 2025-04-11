
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.InvincibleConquestMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class InvincibleConquestModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, InvincibleConquestMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> INVINCIBLE_ARMOR = REGISTRY.register("invincible_armor", () -> CreativeModeTab.builder().title(Component.translatable("item_group.invincible_conquest.invincible_armor"))
			.icon(() -> new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_HELMET.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_BLUE_HELMET.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_BLUE_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_BLUE_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_BLUE_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_SINISTER_HELMET.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_SINISTER_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_SINISTER_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_SINISTER_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_DARK_HELMET.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_DARK_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_DARK_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_DARK_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_MOHAWK_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_MOHAWK_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_MOHAWK_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_VEIL_HELMET.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_VEIL_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_VEIL_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SUIT_VEIL_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.OMNIVINCIBLE_SUIT_HELMET.get());
				tabData.accept(InvincibleConquestModItems.OMNIVINCIBLE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.OMNIVINCIBLE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.OMNIVINCIBLE_SUIT_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.OMNI_MAN_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.OMNI_MAN_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.OMNI_MAN_SUIT_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.VILTRUMITE_UNIFORM_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.VILTRUMITE_UNIFORM_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.VILTRUMITE_UNIFORM_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.ANGSTROM_OUTFIT_HELMET.get());
				tabData.accept(InvincibleConquestModItems.ANGSTROM_OUTFIT_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.ANGSTROM_OUTFIT_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.ANGSTROM_OUTFIT_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.ATOM_EVE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.ATOM_EVE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.ATOM_EVE_SUIT_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.REX_SPLODE_SUIT_HELMET.get());
				tabData.accept(InvincibleConquestModItems.REX_SPLODE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.REX_SPLODE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.REX_SPLODE_SUIT_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.DUPLI_KATE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.DUPLI_KATE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.DUPLI_KATE_SUIT_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.MULTI_PAUL_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.MULTI_PAUL_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.MULTI_PAUL_SUIT_BOOTS.get());
				tabData.accept(InvincibleConquestModItems.MAULER_TWIN_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.MAULER_TWIN_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.FLAXAN_ARMOR_CHESTPLATE.get());
				tabData.accept(InvincibleConquestModItems.FLAXAN_ARMOR_LEGGINGS.get());
				tabData.accept(InvincibleConquestModItems.FLAXAN_ARMOR_BOOTS.get());
			}).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> INVINCIBLE_MOBS = REGISTRY.register("invincible_mobs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.invincible_conquest.invincible_mobs")).icon(() -> new ItemStack(InvincibleConquestModItems.INVINCIBLE_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_BLUE_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_SINISTER_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_MOHAWK_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_MASKLESS_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_VEIL_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.INVINCIBLE_DARK_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.VILTRUMITE_MARK_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.OMNIVINCIBLE_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.OMNI_MAN_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.CONQUEST_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.BATTLE_BEAST_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.ANGSTROM_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.REX_SPLODE_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.ATOM_EVE_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.DUPLI_KATE_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.MULTI_PAUL_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.MAULER_TWIN_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.VILTRUMITE_MALE_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.VILTRUMITE_FEMALE_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.MARTIAN_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.MARTIAN_SPEARMAN_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.FLAXAN_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.FLAXAN_GUNMAN_SPAWN_EGG.get());
				tabData.accept(InvincibleConquestModItems.DINOSAUR_SPAWN_EGG.get());
			}).withTabsBefore(INVINCIBLE_ARMOR.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> INVINCIBLE_ITEMS = REGISTRY.register("invincible_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.invincible_conquest.invincible_items")).icon(() -> new ItemStack(InvincibleConquestModItems.FLAXAN_GUN.get())).displayItems((parameters, tabData) -> {
				tabData.accept(InvincibleConquestModItems.SELECTION_BOOK.get());
				tabData.accept(InvincibleConquestModItems.FLAXAN_GUN.get());
				tabData.accept(InvincibleConquestModItems.GALACTIC_MAP.get());
			}).withTabsBefore(INVINCIBLE_MOBS.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(InvincibleConquestModBlocks.MOON_SAND.get().asItem());
			tabData.accept(InvincibleConquestModBlocks.MOON_STONE.get().asItem());
		}
	}
}
