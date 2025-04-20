
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.entity.WhiteSunEntity;
import net.clozynoii.invincibleconquest.entity.ViltrumiteMarkEntity;
import net.clozynoii.invincibleconquest.entity.ViltrumiteMaleEntity;
import net.clozynoii.invincibleconquest.entity.ViltrumiteFemaleEntity;
import net.clozynoii.invincibleconquest.entity.ViltrumEntity;
import net.clozynoii.invincibleconquest.entity.TheHammerEntity;
import net.clozynoii.invincibleconquest.entity.TalescriaEntity;
import net.clozynoii.invincibleconquest.entity.SunEntity;
import net.clozynoii.invincibleconquest.entity.SonicClapEntity;
import net.clozynoii.invincibleconquest.entity.RoboBallEntity;
import net.clozynoii.invincibleconquest.entity.RexSplodeEntity;
import net.clozynoii.invincibleconquest.entity.RedSunEntity;
import net.clozynoii.invincibleconquest.entity.OrangeSunEntity;
import net.clozynoii.invincibleconquest.entity.OmnivincibleEntity;
import net.clozynoii.invincibleconquest.entity.OmniManEntity;
import net.clozynoii.invincibleconquest.entity.MultiPaulEntity;
import net.clozynoii.invincibleconquest.entity.MoonEntity;
import net.clozynoii.invincibleconquest.entity.MaulerTwinEntity;
import net.clozynoii.invincibleconquest.entity.MartianSpearmanEntity;
import net.clozynoii.invincibleconquest.entity.MartianEntity;
import net.clozynoii.invincibleconquest.entity.MarsEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleVeilEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleSinisterEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleMohawkEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleMasklessEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleDarkEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleBlueEntity;
import net.clozynoii.invincibleconquest.entity.HammerSpawnerEntity;
import net.clozynoii.invincibleconquest.entity.FlaxanPortalEntity;
import net.clozynoii.invincibleconquest.entity.FlaxanGunmanEntity;
import net.clozynoii.invincibleconquest.entity.FlaxanEntity;
import net.clozynoii.invincibleconquest.entity.FlaxanBulletEntity;
import net.clozynoii.invincibleconquest.entity.FireworkMobEntity;
import net.clozynoii.invincibleconquest.entity.ExplosionSmallEntity;
import net.clozynoii.invincibleconquest.entity.ExplosionLargeEntity;
import net.clozynoii.invincibleconquest.entity.EarthEntity;
import net.clozynoii.invincibleconquest.entity.DupliKateEntity;
import net.clozynoii.invincibleconquest.entity.DinosaurEntity;
import net.clozynoii.invincibleconquest.entity.DimensionalPortalEntity;
import net.clozynoii.invincibleconquest.entity.ConquestEntity;
import net.clozynoii.invincibleconquest.entity.CecilEntity;
import net.clozynoii.invincibleconquest.entity.BlueSunEntity;
import net.clozynoii.invincibleconquest.entity.BattleBeastEntity;
import net.clozynoii.invincibleconquest.entity.AtomEveEntity;
import net.clozynoii.invincibleconquest.entity.AnissaEntity;
import net.clozynoii.invincibleconquest.entity.AngstromEntity;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class InvincibleConquestModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, InvincibleConquestMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<InvincibleEntity>> INVINCIBLE = register("invincible",
			EntityType.Builder.<InvincibleEntity>of(InvincibleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<InvincibleBlueEntity>> INVINCIBLE_BLUE = register("invincible_blue",
			EntityType.Builder.<InvincibleBlueEntity>of(InvincibleBlueEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<InvincibleSinisterEntity>> INVINCIBLE_SINISTER = register("invincible_sinister",
			EntityType.Builder.<InvincibleSinisterEntity>of(InvincibleSinisterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<InvincibleMohawkEntity>> INVINCIBLE_MOHAWK = register("invincible_mohawk",
			EntityType.Builder.<InvincibleMohawkEntity>of(InvincibleMohawkEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<InvincibleMasklessEntity>> INVINCIBLE_MASKLESS = register("invincible_maskless",
			EntityType.Builder.<InvincibleMasklessEntity>of(InvincibleMasklessEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<InvincibleVeilEntity>> INVINCIBLE_VEIL = register("invincible_veil",
			EntityType.Builder.<InvincibleVeilEntity>of(InvincibleVeilEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<InvincibleDarkEntity>> INVINCIBLE_DARK = register("invincible_dark",
			EntityType.Builder.<InvincibleDarkEntity>of(InvincibleDarkEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ViltrumiteMarkEntity>> VILTRUMITE_MARK = register("viltrumite_mark",
			EntityType.Builder.<ViltrumiteMarkEntity>of(ViltrumiteMarkEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<OmnivincibleEntity>> OMNIVINCIBLE = register("omnivincible",
			EntityType.Builder.<OmnivincibleEntity>of(OmnivincibleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<DinosaurEntity>> DINOSAUR = register("dinosaur",
			EntityType.Builder.<DinosaurEntity>of(DinosaurEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(3.5f, 5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MartianEntity>> MARTIAN = register("martian",
			EntityType.Builder.<MartianEntity>of(MartianEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MartianSpearmanEntity>> MARTIAN_SPEARMAN = register("martian_spearman",
			EntityType.Builder.<MartianSpearmanEntity>of(MartianSpearmanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlaxanEntity>> FLAXAN = register("flaxan",
			EntityType.Builder.<FlaxanEntity>of(FlaxanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlaxanGunmanEntity>> FLAXAN_GUNMAN = register("flaxan_gunman",
			EntityType.Builder.<FlaxanGunmanEntity>of(FlaxanGunmanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlaxanBulletEntity>> FLAXAN_BULLET = register("flaxan_bullet",
			EntityType.Builder.<FlaxanBulletEntity>of(FlaxanBulletEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<OmniManEntity>> OMNI_MAN = register("omni_man",
			EntityType.Builder.<OmniManEntity>of(OmniManEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<AngstromEntity>> ANGSTROM = register("angstrom",
			EntityType.Builder.<AngstromEntity>of(AngstromEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<RexSplodeEntity>> REX_SPLODE = register("rex_splode",
			EntityType.Builder.<RexSplodeEntity>of(RexSplodeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<AtomEveEntity>> ATOM_EVE = register("atom_eve",
			EntityType.Builder.<AtomEveEntity>of(AtomEveEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<DupliKateEntity>> DUPLI_KATE = register("dupli_kate",
			EntityType.Builder.<DupliKateEntity>of(DupliKateEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<MultiPaulEntity>> MULTI_PAUL = register("multi_paul",
			EntityType.Builder.<MultiPaulEntity>of(MultiPaulEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<BattleBeastEntity>> BATTLE_BEAST = register("battle_beast",
			EntityType.Builder.<BattleBeastEntity>of(BattleBeastEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.8f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<MaulerTwinEntity>> MAULER_TWIN = register("mauler_twin",
			EntityType.Builder.<MaulerTwinEntity>of(MaulerTwinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<ViltrumiteMaleEntity>> VILTRUMITE_MALE = register("viltrumite_male",
			EntityType.Builder.<ViltrumiteMaleEntity>of(ViltrumiteMaleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ViltrumiteFemaleEntity>> VILTRUMITE_FEMALE = register("viltrumite_female",
			EntityType.Builder.<ViltrumiteFemaleEntity>of(ViltrumiteFemaleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<EarthEntity>> EARTH = register("earth",
			EntityType.Builder.<EarthEntity>of(EarthEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(5f, 5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MoonEntity>> MOON = register("moon",
			EntityType.Builder.<MoonEntity>of(MoonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(3f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<MarsEntity>> MARS = register("mars",
			EntityType.Builder.<MarsEntity>of(MarsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(5f, 5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ViltrumEntity>> VILTRUM = register("viltrum",
			EntityType.Builder.<ViltrumEntity>of(ViltrumEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(5f, 5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SunEntity>> SUN = register("sun",
			EntityType.Builder.<SunEntity>of(SunEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(6f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<TalescriaEntity>> TALESCRIA = register("talescria",
			EntityType.Builder.<TalescriaEntity>of(TalescriaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(5f, 5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ConquestEntity>> CONQUEST = register("conquest",
			EntityType.Builder.<ConquestEntity>of(ConquestEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<WhiteSunEntity>> WHITE_SUN = register("white_sun",
			EntityType.Builder.<WhiteSunEntity>of(WhiteSunEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(6f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<TheHammerEntity>> THE_HAMMER = register("the_hammer",
			EntityType.Builder.<TheHammerEntity>of(TheHammerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(2f, 10f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlaxanPortalEntity>> FLAXAN_PORTAL = register("flaxan_portal",
			EntityType.Builder.<FlaxanPortalEntity>of(FlaxanPortalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.7f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<OrangeSunEntity>> ORANGE_SUN = register("orange_sun",
			EntityType.Builder.<OrangeSunEntity>of(OrangeSunEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(6f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<RedSunEntity>> RED_SUN = register("red_sun",
			EntityType.Builder.<RedSunEntity>of(RedSunEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(6f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<BlueSunEntity>> BLUE_SUN = register("blue_sun",
			EntityType.Builder.<BlueSunEntity>of(BlueSunEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(6f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<HammerSpawnerEntity>> HAMMER_SPAWNER = register("hammer_spawner",
			EntityType.Builder.<HammerSpawnerEntity>of(HammerSpawnerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<CecilEntity>> CECIL = register("cecil",
			EntityType.Builder.<CecilEntity>of(CecilEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<AnissaEntity>> ANISSA = register("anissa",
			EntityType.Builder.<AnissaEntity>of(AnissaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ExplosionSmallEntity>> EXPLOSION_SMALL = register("explosion_small",
			EntityType.Builder.<ExplosionSmallEntity>of(ExplosionSmallEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SonicClapEntity>> SONIC_CLAP = register("sonic_clap",
			EntityType.Builder.<SonicClapEntity>of(SonicClapEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RoboBallEntity>> ROBO_BALL = register("robo_ball",
			EntityType.Builder.<RoboBallEntity>of(RoboBallEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<DimensionalPortalEntity>> DIMENSIONAL_PORTAL = register("dimensional_portal",
			EntityType.Builder.<DimensionalPortalEntity>of(DimensionalPortalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ExplosionLargeEntity>> EXPLOSION_LARGE = register("explosion_large",
			EntityType.Builder.<ExplosionLargeEntity>of(ExplosionLargeEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FireworkMobEntity>> FIREWORK_MOB = register("firework_mob",
			EntityType.Builder.<FireworkMobEntity>of(FireworkMobEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		InvincibleEntity.init(event);
		InvincibleBlueEntity.init(event);
		InvincibleSinisterEntity.init(event);
		InvincibleMohawkEntity.init(event);
		InvincibleMasklessEntity.init(event);
		InvincibleVeilEntity.init(event);
		InvincibleDarkEntity.init(event);
		ViltrumiteMarkEntity.init(event);
		OmnivincibleEntity.init(event);
		DinosaurEntity.init(event);
		MartianEntity.init(event);
		MartianSpearmanEntity.init(event);
		FlaxanEntity.init(event);
		FlaxanGunmanEntity.init(event);
		OmniManEntity.init(event);
		AngstromEntity.init(event);
		RexSplodeEntity.init(event);
		AtomEveEntity.init(event);
		DupliKateEntity.init(event);
		MultiPaulEntity.init(event);
		BattleBeastEntity.init(event);
		MaulerTwinEntity.init(event);
		ViltrumiteMaleEntity.init(event);
		ViltrumiteFemaleEntity.init(event);
		EarthEntity.init(event);
		MoonEntity.init(event);
		MarsEntity.init(event);
		ViltrumEntity.init(event);
		SunEntity.init(event);
		TalescriaEntity.init(event);
		ConquestEntity.init(event);
		WhiteSunEntity.init(event);
		TheHammerEntity.init(event);
		FlaxanPortalEntity.init(event);
		OrangeSunEntity.init(event);
		RedSunEntity.init(event);
		BlueSunEntity.init(event);
		HammerSpawnerEntity.init(event);
		CecilEntity.init(event);
		AnissaEntity.init(event);
		RoboBallEntity.init(event);
		DimensionalPortalEntity.init(event);
		FireworkMobEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(INVINCIBLE.get(), InvincibleEntity.createAttributes().build());
		event.put(INVINCIBLE_BLUE.get(), InvincibleBlueEntity.createAttributes().build());
		event.put(INVINCIBLE_SINISTER.get(), InvincibleSinisterEntity.createAttributes().build());
		event.put(INVINCIBLE_MOHAWK.get(), InvincibleMohawkEntity.createAttributes().build());
		event.put(INVINCIBLE_MASKLESS.get(), InvincibleMasklessEntity.createAttributes().build());
		event.put(INVINCIBLE_VEIL.get(), InvincibleVeilEntity.createAttributes().build());
		event.put(INVINCIBLE_DARK.get(), InvincibleDarkEntity.createAttributes().build());
		event.put(VILTRUMITE_MARK.get(), ViltrumiteMarkEntity.createAttributes().build());
		event.put(OMNIVINCIBLE.get(), OmnivincibleEntity.createAttributes().build());
		event.put(DINOSAUR.get(), DinosaurEntity.createAttributes().build());
		event.put(MARTIAN.get(), MartianEntity.createAttributes().build());
		event.put(MARTIAN_SPEARMAN.get(), MartianSpearmanEntity.createAttributes().build());
		event.put(FLAXAN.get(), FlaxanEntity.createAttributes().build());
		event.put(FLAXAN_GUNMAN.get(), FlaxanGunmanEntity.createAttributes().build());
		event.put(OMNI_MAN.get(), OmniManEntity.createAttributes().build());
		event.put(ANGSTROM.get(), AngstromEntity.createAttributes().build());
		event.put(REX_SPLODE.get(), RexSplodeEntity.createAttributes().build());
		event.put(ATOM_EVE.get(), AtomEveEntity.createAttributes().build());
		event.put(DUPLI_KATE.get(), DupliKateEntity.createAttributes().build());
		event.put(MULTI_PAUL.get(), MultiPaulEntity.createAttributes().build());
		event.put(BATTLE_BEAST.get(), BattleBeastEntity.createAttributes().build());
		event.put(MAULER_TWIN.get(), MaulerTwinEntity.createAttributes().build());
		event.put(VILTRUMITE_MALE.get(), ViltrumiteMaleEntity.createAttributes().build());
		event.put(VILTRUMITE_FEMALE.get(), ViltrumiteFemaleEntity.createAttributes().build());
		event.put(EARTH.get(), EarthEntity.createAttributes().build());
		event.put(MOON.get(), MoonEntity.createAttributes().build());
		event.put(MARS.get(), MarsEntity.createAttributes().build());
		event.put(VILTRUM.get(), ViltrumEntity.createAttributes().build());
		event.put(SUN.get(), SunEntity.createAttributes().build());
		event.put(TALESCRIA.get(), TalescriaEntity.createAttributes().build());
		event.put(CONQUEST.get(), ConquestEntity.createAttributes().build());
		event.put(WHITE_SUN.get(), WhiteSunEntity.createAttributes().build());
		event.put(THE_HAMMER.get(), TheHammerEntity.createAttributes().build());
		event.put(FLAXAN_PORTAL.get(), FlaxanPortalEntity.createAttributes().build());
		event.put(ORANGE_SUN.get(), OrangeSunEntity.createAttributes().build());
		event.put(RED_SUN.get(), RedSunEntity.createAttributes().build());
		event.put(BLUE_SUN.get(), BlueSunEntity.createAttributes().build());
		event.put(HAMMER_SPAWNER.get(), HammerSpawnerEntity.createAttributes().build());
		event.put(CECIL.get(), CecilEntity.createAttributes().build());
		event.put(ANISSA.get(), AnissaEntity.createAttributes().build());
		event.put(ROBO_BALL.get(), RoboBallEntity.createAttributes().build());
		event.put(DIMENSIONAL_PORTAL.get(), DimensionalPortalEntity.createAttributes().build());
		event.put(FIREWORK_MOB.get(), FireworkMobEntity.createAttributes().build());
	}
}
