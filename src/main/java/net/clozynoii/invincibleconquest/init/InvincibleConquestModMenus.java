
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.world.inventory.MenuStatsMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuPlanetTakeoverMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuFactionStatsMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuAbilityViltrumiteMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuAbilityTechJacketMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuAbilitySpiderMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuAbilitySpeedsterMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuAbilitySelectionMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuAbilityRobotMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuAbilityPortalMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuAbilityExplodeMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuAbilityCloningMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuAbilityBeastMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuAbilityBasicMenu;
import net.clozynoii.invincibleconquest.world.inventory.MenuAbilityAtomMenu;
import net.clozynoii.invincibleconquest.world.inventory.MENUABILITYBLANKMenu;
import net.clozynoii.invincibleconquest.world.inventory.GalacticMapGUIMenu;
import net.clozynoii.invincibleconquest.world.inventory.FactionJoinViltrumMenu;
import net.clozynoii.invincibleconquest.world.inventory.FactionJoinGDAMenu;
import net.clozynoii.invincibleconquest.world.inventory.FactionJoinCOPMenu;
import net.clozynoii.invincibleconquest.world.inventory.DimensionSelectorMenu;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

public class InvincibleConquestModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, InvincibleConquestMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<MenuStatsMenu>> MENU_STATS = REGISTRY.register("menu_stats", () -> IMenuTypeExtension.create(MenuStatsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuAbilitySelectionMenu>> MENU_ABILITY_SELECTION = REGISTRY.register("menu_ability_selection", () -> IMenuTypeExtension.create(MenuAbilitySelectionMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuAbilityBasicMenu>> MENU_ABILITY_BASIC = REGISTRY.register("menu_ability_basic", () -> IMenuTypeExtension.create(MenuAbilityBasicMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuAbilityViltrumiteMenu>> MENU_ABILITY_VILTRUMITE = REGISTRY.register("menu_ability_viltrumite", () -> IMenuTypeExtension.create(MenuAbilityViltrumiteMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuAbilitySpeedsterMenu>> MENU_ABILITY_SPEEDSTER = REGISTRY.register("menu_ability_speedster", () -> IMenuTypeExtension.create(MenuAbilitySpeedsterMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuAbilitySpiderMenu>> MENU_ABILITY_SPIDER = REGISTRY.register("menu_ability_spider", () -> IMenuTypeExtension.create(MenuAbilitySpiderMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuAbilityCloningMenu>> MENU_ABILITY_CLONING = REGISTRY.register("menu_ability_cloning", () -> IMenuTypeExtension.create(MenuAbilityCloningMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuAbilityExplodeMenu>> MENU_ABILITY_EXPLODE = REGISTRY.register("menu_ability_explode", () -> IMenuTypeExtension.create(MenuAbilityExplodeMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuAbilityPortalMenu>> MENU_ABILITY_PORTAL = REGISTRY.register("menu_ability_portal", () -> IMenuTypeExtension.create(MenuAbilityPortalMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuAbilityBeastMenu>> MENU_ABILITY_BEAST = REGISTRY.register("menu_ability_beast", () -> IMenuTypeExtension.create(MenuAbilityBeastMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuAbilityAtomMenu>> MENU_ABILITY_ATOM = REGISTRY.register("menu_ability_atom", () -> IMenuTypeExtension.create(MenuAbilityAtomMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuAbilityRobotMenu>> MENU_ABILITY_ROBOT = REGISTRY.register("menu_ability_robot", () -> IMenuTypeExtension.create(MenuAbilityRobotMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FactionJoinViltrumMenu>> FACTION_JOIN_VILTRUM = REGISTRY.register("faction_join_viltrum", () -> IMenuTypeExtension.create(FactionJoinViltrumMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FactionJoinGDAMenu>> FACTION_JOIN_GDA = REGISTRY.register("faction_join_gda", () -> IMenuTypeExtension.create(FactionJoinGDAMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FactionJoinCOPMenu>> FACTION_JOIN_COP = REGISTRY.register("faction_join_cop", () -> IMenuTypeExtension.create(FactionJoinCOPMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuFactionStatsMenu>> MENU_FACTION_STATS = REGISTRY.register("menu_faction_stats", () -> IMenuTypeExtension.create(MenuFactionStatsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuPlanetTakeoverMenu>> MENU_PLANET_TAKEOVER = REGISTRY.register("menu_planet_takeover", () -> IMenuTypeExtension.create(MenuPlanetTakeoverMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GalacticMapGUIMenu>> GALACTIC_MAP_GUI = REGISTRY.register("galactic_map_gui", () -> IMenuTypeExtension.create(GalacticMapGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuAbilityTechJacketMenu>> MENU_ABILITY_TECH_JACKET = REGISTRY.register("menu_ability_tech_jacket", () -> IMenuTypeExtension.create(MenuAbilityTechJacketMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MENUABILITYBLANKMenu>> MENUABILITYBLANK = REGISTRY.register("menuabilityblank", () -> IMenuTypeExtension.create(MENUABILITYBLANKMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DimensionSelectorMenu>> DIMENSION_SELECTOR = REGISTRY.register("dimension_selector", () -> IMenuTypeExtension.create(DimensionSelectorMenu::new));
}
