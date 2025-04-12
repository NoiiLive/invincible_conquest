package net.clozynoii.invincibleconquest.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import java.util.function.Supplier;
import java.util.ArrayList;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class InvincibleConquestModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, InvincibleConquestMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		InvincibleConquestMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		InvincibleConquestMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.PlayerStrength = original.PlayerStrength;
			clone.PlayerDurability = original.PlayerDurability;
			clone.PlayerAgility = original.PlayerAgility;
			clone.PlayerStamina = original.PlayerStamina;
			clone.PlayerVitality = original.PlayerVitality;
			clone.PlayerFocus = original.PlayerFocus;
			clone.PlayerIntelligence = original.PlayerIntelligence;
			clone.PlayerSkillPoints = original.PlayerSkillPoints;
			clone.PlayerLevel = original.PlayerLevel;
			clone.PlayerEXP = original.PlayerEXP;
			clone.PlayerEXPCap = original.PlayerEXPCap;
			clone.PlayerAbility = original.PlayerAbility;
			clone.PlayerAge = original.PlayerAge;
			clone.PlayerAbilityMastery = original.PlayerAbilityMastery;
			clone.AddPlayerSkillPoints = original.AddPlayerSkillPoints;
			clone.AgeTimer = original.AgeTimer;
			clone.Ability1a = original.Ability1a;
			clone.Ability2a = original.Ability2a;
			clone.Ability3a = original.Ability3a;
			clone.Ability4a = original.Ability4a;
			clone.Ability5a = original.Ability5a;
			clone.Ability1b = original.Ability1b;
			clone.Ability2b = original.Ability2b;
			clone.Ability3b = original.Ability3b;
			clone.Ability4b = original.Ability4b;
			clone.Ability5b = original.Ability5b;
			clone.AbilityBar = original.AbilityBar;
			clone.JoinedWorld = original.JoinedWorld;
			clone.AgeBoost = original.AgeBoost;
			clone.PlayerMaxStamina = original.PlayerMaxStamina;
			clone.PlayerOutput = original.PlayerOutput;
			clone.NoCooldowns = original.NoCooldowns;
			clone.UnlockedSkills = original.UnlockedSkills;
			clone.PlayerFaction = original.PlayerFaction;
			clone.PlayerFactionRank = original.PlayerFactionRank;
			clone.PlayerReputation = original.PlayerReputation;
			clone.FactionInvites = original.FactionInvites;
			if (!event.isWasDeath()) {
				clone.Cooldown1a = original.Cooldown1a;
				clone.Cooldown2a = original.Cooldown2a;
				clone.Cooldown3a = original.Cooldown3a;
				clone.Cooldown4a = original.Cooldown4a;
				clone.Cooldown5a = original.Cooldown5a;
				clone.Cooldown1b = original.Cooldown1b;
				clone.Cooldown2b = original.Cooldown2b;
				clone.Cooldown3b = original.Cooldown3b;
				clone.Cooldown4b = original.Cooldown4b;
				clone.Cooldown5b = original.Cooldown5b;
				clone.GUISelectedEntry = original.GUISelectedEntry;
				clone.KeyHeld = original.KeyHeld;
				clone.InputDelay = original.InputDelay;
				clone.SelectedMove = original.SelectedMove;
				clone.RegenTimer = original.RegenTimer;
				clone.PlayerCurrentStamina = original.PlayerCurrentStamina;
				clone.StaminaTimer = original.StaminaTimer;
				clone.PlayerFlying = original.PlayerFlying;
				clone.ChangingOutput = original.ChangingOutput;
				clone.FlightDirection = original.FlightDirection;
				clone.Barraging = original.Barraging;
				clone.GrabbedEntity = original.GrabbedEntity;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "invincible_conquest_worldvars";
		public double BarrageCooldown = 0.0;

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			BarrageCooldown = nbt.getDouble("BarrageCooldown");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("BarrageCooldown", BarrageCooldown);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "invincible_conquest_mapvars";
		public double EventTimer = 72000.0;
		public boolean SpaceGenerated = false;
		public String EarthOwner = "Global Defense Agency";
		public String MarsOwner = "Martians";
		public String MoonOwner = "Global Defense Agency";
		public String ViltrumOwner = "Viltrum Empire";
		public String PlanetTakeover = "";
		public String HomeFaction = "";
		public String InvadingFaction = "";
		public double TakeoverScore = 0.0;
		public double HOSTILEBlocksBroken = 0.0;
		public double HOSTILELivesTaken = 0.0;
		public double HOSTILETimeOccupied = 0.0;
		public double UnoccupiedTimer = 0.0;
		public boolean PlanetOccupied = false;
		public String FactionIndex = "None, Global Defense Agency, Guardians of the Globe, Coalition of Planets, Viltrum Empire, Martians, Flaxans, Teen Team, Lizard League, The Order, ";
		public String TalescriaOwner = "Coalition of Planets";
		public double BreakPoints = 0.0;
		public double WaveTimer = 0.0;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			EventTimer = nbt.getDouble("EventTimer");
			SpaceGenerated = nbt.getBoolean("SpaceGenerated");
			EarthOwner = nbt.getString("EarthOwner");
			MarsOwner = nbt.getString("MarsOwner");
			MoonOwner = nbt.getString("MoonOwner");
			ViltrumOwner = nbt.getString("ViltrumOwner");
			PlanetTakeover = nbt.getString("PlanetTakeover");
			HomeFaction = nbt.getString("HomeFaction");
			InvadingFaction = nbt.getString("InvadingFaction");
			TakeoverScore = nbt.getDouble("TakeoverScore");
			HOSTILEBlocksBroken = nbt.getDouble("HOSTILEBlocksBroken");
			HOSTILELivesTaken = nbt.getDouble("HOSTILELivesTaken");
			HOSTILETimeOccupied = nbt.getDouble("HOSTILETimeOccupied");
			UnoccupiedTimer = nbt.getDouble("UnoccupiedTimer");
			PlanetOccupied = nbt.getBoolean("PlanetOccupied");
			FactionIndex = nbt.getString("FactionIndex");
			TalescriaOwner = nbt.getString("TalescriaOwner");
			BreakPoints = nbt.getDouble("BreakPoints");
			WaveTimer = nbt.getDouble("WaveTimer");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("EventTimer", EventTimer);
			nbt.putBoolean("SpaceGenerated", SpaceGenerated);
			nbt.putString("EarthOwner", EarthOwner);
			nbt.putString("MarsOwner", MarsOwner);
			nbt.putString("MoonOwner", MoonOwner);
			nbt.putString("ViltrumOwner", ViltrumOwner);
			nbt.putString("PlanetTakeover", PlanetTakeover);
			nbt.putString("HomeFaction", HomeFaction);
			nbt.putString("InvadingFaction", InvadingFaction);
			nbt.putDouble("TakeoverScore", TakeoverScore);
			nbt.putDouble("HOSTILEBlocksBroken", HOSTILEBlocksBroken);
			nbt.putDouble("HOSTILELivesTaken", HOSTILELivesTaken);
			nbt.putDouble("HOSTILETimeOccupied", HOSTILETimeOccupied);
			nbt.putDouble("UnoccupiedTimer", UnoccupiedTimer);
			nbt.putBoolean("PlanetOccupied", PlanetOccupied);
			nbt.putString("FactionIndex", FactionIndex);
			nbt.putString("TalescriaOwner", TalescriaOwner);
			nbt.putDouble("BreakPoints", BreakPoints);
			nbt.putDouble("WaveTimer", WaveTimer);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public double PlayerStrength = 0.0;
		public double PlayerDurability = 0.0;
		public double PlayerAgility = 0.0;
		public double PlayerStamina = 0.0;
		public double PlayerVitality = 0.0;
		public double PlayerFocus = 0.0;
		public double PlayerIntelligence = 0.0;
		public double PlayerSkillPoints = 5.0;
		public double PlayerLevel = 1.0;
		public double PlayerEXP = 0.0;
		public double PlayerEXPCap = 100.0;
		public String PlayerAbility = "None";
		public double PlayerAge = 18.0;
		public double PlayerAbilityMastery = 0.0;
		public double AddPlayerSkillPoints = 1.0;
		public double AgeTimer = 100.0;
		public double Cooldown1a = 0.0;
		public double Cooldown2a = 0.0;
		public double Cooldown3a = 0.0;
		public double Cooldown4a = 0.0;
		public double Cooldown5a = 0.0;
		public double Cooldown1b = 0.0;
		public double Cooldown2b = 0.0;
		public double Cooldown3b = 0.0;
		public double Cooldown4b = 0.0;
		public double Cooldown5b = 0.0;
		public String Ability1a = "None";
		public String Ability2a = "None";
		public String Ability3a = "None";
		public String Ability4a = "None";
		public String Ability5a = "None";
		public String Ability1b = "None";
		public String Ability2b = "None";
		public String Ability3b = "None";
		public String Ability4b = "None";
		public String Ability5b = "None";
		public String GUISelectedEntry = "";
		public double AbilityBar = 1.0;
		public boolean KeyHeld = false;
		public double InputDelay = 0.0;
		public boolean JoinedWorld = false;
		public String SelectedMove = "";
		public double AgeBoost = 0.0;
		public double RegenTimer = 0.0;
		public double PlayerCurrentStamina = 100.0;
		public double PlayerMaxStamina = 100.0;
		public double StaminaTimer = 0.0;
		public boolean PlayerFlying = false;
		public double PlayerOutput = 100.0;
		public boolean ChangingOutput = false;
		public String FlightDirection = "";
		public boolean NoCooldowns = false;
		public boolean Barraging = false;
		public String UnlockedSkills = "";
		public String PlayerFaction = "None";
		public String PlayerFactionRank = "None";
		public double PlayerReputation = 0.0;
		public String FactionInvites = ", ";
		public String GrabbedEntity = "";

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("PlayerStrength", PlayerStrength);
			nbt.putDouble("PlayerDurability", PlayerDurability);
			nbt.putDouble("PlayerAgility", PlayerAgility);
			nbt.putDouble("PlayerStamina", PlayerStamina);
			nbt.putDouble("PlayerVitality", PlayerVitality);
			nbt.putDouble("PlayerFocus", PlayerFocus);
			nbt.putDouble("PlayerIntelligence", PlayerIntelligence);
			nbt.putDouble("PlayerSkillPoints", PlayerSkillPoints);
			nbt.putDouble("PlayerLevel", PlayerLevel);
			nbt.putDouble("PlayerEXP", PlayerEXP);
			nbt.putDouble("PlayerEXPCap", PlayerEXPCap);
			nbt.putString("PlayerAbility", PlayerAbility);
			nbt.putDouble("PlayerAge", PlayerAge);
			nbt.putDouble("PlayerAbilityMastery", PlayerAbilityMastery);
			nbt.putDouble("AddPlayerSkillPoints", AddPlayerSkillPoints);
			nbt.putDouble("AgeTimer", AgeTimer);
			nbt.putDouble("Cooldown1a", Cooldown1a);
			nbt.putDouble("Cooldown2a", Cooldown2a);
			nbt.putDouble("Cooldown3a", Cooldown3a);
			nbt.putDouble("Cooldown4a", Cooldown4a);
			nbt.putDouble("Cooldown5a", Cooldown5a);
			nbt.putDouble("Cooldown1b", Cooldown1b);
			nbt.putDouble("Cooldown2b", Cooldown2b);
			nbt.putDouble("Cooldown3b", Cooldown3b);
			nbt.putDouble("Cooldown4b", Cooldown4b);
			nbt.putDouble("Cooldown5b", Cooldown5b);
			nbt.putString("Ability1a", Ability1a);
			nbt.putString("Ability2a", Ability2a);
			nbt.putString("Ability3a", Ability3a);
			nbt.putString("Ability4a", Ability4a);
			nbt.putString("Ability5a", Ability5a);
			nbt.putString("Ability1b", Ability1b);
			nbt.putString("Ability2b", Ability2b);
			nbt.putString("Ability3b", Ability3b);
			nbt.putString("Ability4b", Ability4b);
			nbt.putString("Ability5b", Ability5b);
			nbt.putString("GUISelectedEntry", GUISelectedEntry);
			nbt.putDouble("AbilityBar", AbilityBar);
			nbt.putBoolean("KeyHeld", KeyHeld);
			nbt.putDouble("InputDelay", InputDelay);
			nbt.putBoolean("JoinedWorld", JoinedWorld);
			nbt.putString("SelectedMove", SelectedMove);
			nbt.putDouble("AgeBoost", AgeBoost);
			nbt.putDouble("RegenTimer", RegenTimer);
			nbt.putDouble("PlayerCurrentStamina", PlayerCurrentStamina);
			nbt.putDouble("PlayerMaxStamina", PlayerMaxStamina);
			nbt.putDouble("StaminaTimer", StaminaTimer);
			nbt.putBoolean("PlayerFlying", PlayerFlying);
			nbt.putDouble("PlayerOutput", PlayerOutput);
			nbt.putBoolean("ChangingOutput", ChangingOutput);
			nbt.putString("FlightDirection", FlightDirection);
			nbt.putBoolean("NoCooldowns", NoCooldowns);
			nbt.putBoolean("Barraging", Barraging);
			nbt.putString("UnlockedSkills", UnlockedSkills);
			nbt.putString("PlayerFaction", PlayerFaction);
			nbt.putString("PlayerFactionRank", PlayerFactionRank);
			nbt.putDouble("PlayerReputation", PlayerReputation);
			nbt.putString("FactionInvites", FactionInvites);
			nbt.putString("GrabbedEntity", GrabbedEntity);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			PlayerStrength = nbt.getDouble("PlayerStrength");
			PlayerDurability = nbt.getDouble("PlayerDurability");
			PlayerAgility = nbt.getDouble("PlayerAgility");
			PlayerStamina = nbt.getDouble("PlayerStamina");
			PlayerVitality = nbt.getDouble("PlayerVitality");
			PlayerFocus = nbt.getDouble("PlayerFocus");
			PlayerIntelligence = nbt.getDouble("PlayerIntelligence");
			PlayerSkillPoints = nbt.getDouble("PlayerSkillPoints");
			PlayerLevel = nbt.getDouble("PlayerLevel");
			PlayerEXP = nbt.getDouble("PlayerEXP");
			PlayerEXPCap = nbt.getDouble("PlayerEXPCap");
			PlayerAbility = nbt.getString("PlayerAbility");
			PlayerAge = nbt.getDouble("PlayerAge");
			PlayerAbilityMastery = nbt.getDouble("PlayerAbilityMastery");
			AddPlayerSkillPoints = nbt.getDouble("AddPlayerSkillPoints");
			AgeTimer = nbt.getDouble("AgeTimer");
			Cooldown1a = nbt.getDouble("Cooldown1a");
			Cooldown2a = nbt.getDouble("Cooldown2a");
			Cooldown3a = nbt.getDouble("Cooldown3a");
			Cooldown4a = nbt.getDouble("Cooldown4a");
			Cooldown5a = nbt.getDouble("Cooldown5a");
			Cooldown1b = nbt.getDouble("Cooldown1b");
			Cooldown2b = nbt.getDouble("Cooldown2b");
			Cooldown3b = nbt.getDouble("Cooldown3b");
			Cooldown4b = nbt.getDouble("Cooldown4b");
			Cooldown5b = nbt.getDouble("Cooldown5b");
			Ability1a = nbt.getString("Ability1a");
			Ability2a = nbt.getString("Ability2a");
			Ability3a = nbt.getString("Ability3a");
			Ability4a = nbt.getString("Ability4a");
			Ability5a = nbt.getString("Ability5a");
			Ability1b = nbt.getString("Ability1b");
			Ability2b = nbt.getString("Ability2b");
			Ability3b = nbt.getString("Ability3b");
			Ability4b = nbt.getString("Ability4b");
			Ability5b = nbt.getString("Ability5b");
			GUISelectedEntry = nbt.getString("GUISelectedEntry");
			AbilityBar = nbt.getDouble("AbilityBar");
			KeyHeld = nbt.getBoolean("KeyHeld");
			InputDelay = nbt.getDouble("InputDelay");
			JoinedWorld = nbt.getBoolean("JoinedWorld");
			SelectedMove = nbt.getString("SelectedMove");
			AgeBoost = nbt.getDouble("AgeBoost");
			RegenTimer = nbt.getDouble("RegenTimer");
			PlayerCurrentStamina = nbt.getDouble("PlayerCurrentStamina");
			PlayerMaxStamina = nbt.getDouble("PlayerMaxStamina");
			StaminaTimer = nbt.getDouble("StaminaTimer");
			PlayerFlying = nbt.getBoolean("PlayerFlying");
			PlayerOutput = nbt.getDouble("PlayerOutput");
			ChangingOutput = nbt.getBoolean("ChangingOutput");
			FlightDirection = nbt.getString("FlightDirection");
			NoCooldowns = nbt.getBoolean("NoCooldowns");
			Barraging = nbt.getBoolean("Barraging");
			UnlockedSkills = nbt.getString("UnlockedSkills");
			PlayerFaction = nbt.getString("PlayerFaction");
			PlayerFactionRank = nbt.getString("PlayerFactionRank");
			PlayerReputation = nbt.getDouble("PlayerReputation");
			FactionInvites = nbt.getString("FactionInvites");
			GrabbedEntity = nbt.getString("GrabbedEntity");
		}

		public void syncPlayerVariables(Entity entity) {
			if (!entity.level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(entity.level().players())) {
					if (entityiterator instanceof ServerPlayer serverPlayer)
						PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this, entity.getId()));
				}
			}
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data, int target) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> {
			buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess()));
			buffer.writeInt(message.target()); // Write the entity ID to the buffer
		}, (RegistryFriendlyByteBuf buffer) -> {
			var nbt = buffer.readNbt();
			PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables(), buffer.readInt());
			message.data.deserializeNBT(buffer.registryAccess(), nbt);
			return message;
		});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().level().getEntity(message.target()).getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess())))
						.exceptionally(e -> {
							context.connection().disconnect(Component.literal(e.getMessage()));
							return null;
						});
			}
		}
	}
}
