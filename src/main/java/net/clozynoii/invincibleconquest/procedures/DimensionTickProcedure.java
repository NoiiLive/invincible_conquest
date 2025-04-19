package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModItems;

import javax.annotation.Nullable;

import java.util.ArrayList;

@EventBusSubscriber
public class DimensionTickProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator instanceof Player) {
				if (!((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:space")))) {
					if (entityiterator.getY() >= 350) {
						if ((entityiterator.level().dimension()) == Level.OVERWORLD) {
							{
								Entity _ent = entityiterator;
								_ent.teleportTo(135, 125, 135);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(135, 125, 135, _ent.getYRot(), _ent.getXRot());
							}
						} else if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:moon_world"))) {
							{
								Entity _ent = entityiterator;
								_ent.teleportTo(150, 125, 150);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(150, 125, 150, _ent.getYRot(), _ent.getXRot());
							}
						} else if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:mars_world"))) {
							{
								Entity _ent = entityiterator;
								_ent.teleportTo(200, 125, 200);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(200, 125, 200, _ent.getYRot(), _ent.getXRot());
							}
						} else if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:viltrum_world"))) {
							{
								Entity _ent = entityiterator;
								_ent.teleportTo(1000, 125, 1000);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(1000, 125, 1000, _ent.getYRot(), _ent.getXRot());
							}
						} else if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:talescria_world"))) {
							{
								Entity _ent = entityiterator;
								_ent.teleportTo(700, 125, 900);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(700, 125, 900, _ent.getYRot(), _ent.getXRot());
							}
						}
						if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:space"));
							if (_player.level().dimension() == destinationType)
								return;
							ServerLevel nextLevel = _player.server.getLevel(destinationType);
							if (nextLevel != null) {
								_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
								_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
								for (MobEffectInstance _effectinstance : _player.getActiveEffects())
									_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
								_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				} else if ((entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:space"))
						|| (entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:moon_world"))
						|| (entityiterator.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:mars_world"))) {
					if (!(entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite") && !(entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Beast")
							&& !(entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Atom") && !(entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Robot")) {
						if (!((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == InvincibleConquestModItems.SPACE_HELMET_HELMET.get())) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DROWN)), 5);
						}
					}
				}
			}
		}
	}
}
