package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DimensionCollectionProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Portal")) {
			if ((entity.level().dimension()) == Level.END) {
				if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList.contains("End" + ", ")) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.DimensionList = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList + "End" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7lCollected The End"), true);
				}
			}
			if ((entity.level().dimension()) == Level.NETHER) {
				if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList.contains("Nether" + ", ")) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.DimensionList = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList + "Nether" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7lCollected The Nether"), true);
				}
			}
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:desert_wasteland"))) {
				if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList.contains("Desert" + ", ")) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.DimensionList = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList + "Desert" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7lCollected Desert Wasteland"), true);
				}
			}
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:apocalypse_dimension"))) {
				if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList.contains("Apocalyptic" + ", ")) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.DimensionList = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList + "Apocalyptic" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7lCollected Apocalyptic Dimension"), true);
				}
			}
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:ice_age_dimension"))) {
				if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList.contains("Snow" + ", ")) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.DimensionList = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList + "Snow" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7lCollected Ice Age Dimension"), true);
				}
			}
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:flaxan_dimension"))) {
				if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList.contains("Flaxan" + ", ")) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.DimensionList = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList + "Flaxan" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7lCollected The Flaxan Dimension"), true);
				}
			}
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:pre_historic"))) {
				if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList.contains("Pre Historic" + ", ")) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.DimensionList = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList + "Pre Historic" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7lCollected The Pre Historic Dimension"), true);
				}
			}
		}
	}
}
