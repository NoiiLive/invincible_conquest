package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;

import javax.annotation.Nullable;

import java.util.ArrayList;

@EventBusSubscriber
public class GlobalCooldownHandlerProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeTimer > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.AgeTimer = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeTimer - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			} else if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeTimer == 0) {
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Age Up " + new java.text.DecimalFormat("##").format(entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAge) + " > "
							+ new java.text.DecimalFormat("##").format(entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAge + 1))), true);
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerAge = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAge + 1;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.AgeTimer = (double) InvincibleConfigConfiguration.BIRTHDAYTIME.get();
					_vars.syncPlayerVariables(entityiterator);
				}
			}
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).RegenTimer > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.RegenTimer = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).RegenTimer - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			} else if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).RegenTimer == 0) {
				if (entityiterator.isAlive()) {
					if ((entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.setHealth((float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
									+ Math.round((entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerVitality + entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
											/ (100 / (double) InvincibleConfigConfiguration.VITREGENRATE.get()))));
					} else {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.setHealth((float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
									+ Math.round(entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerVitality / (100 / (double) InvincibleConfigConfiguration.VITREGENRATE.get()))));
					}
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.RegenTimer = 20;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).StaminaTimer > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.StaminaTimer = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).StaminaTimer - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			} else if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).StaminaTimer == 0) {
				if ((entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.PlayerCurrentStamina = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina + 1
								+ Math.round((entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina + entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
										/ (100 / (double) InvincibleConfigConfiguration.STMDRAIN.get()));
						_vars.syncPlayerVariables(entityiterator);
					}
				} else {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.PlayerCurrentStamina = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina + 1
								+ Math.round(entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina / (100 / (double) InvincibleConfigConfiguration.STMDRAIN.get()));
						_vars.syncPlayerVariables(entityiterator);
					}
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.StaminaTimer = 20;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown1a > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.Cooldown1a = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown1a - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown2a > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.Cooldown2a = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown2a - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown3a > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.Cooldown3a = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown3a - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown4a > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.Cooldown4a = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown4a - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown5a > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.Cooldown5a = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown5a - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown1b > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.Cooldown1b = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown1b - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown2b > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.Cooldown2b = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown2b - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown3b > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.Cooldown3b = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown3b - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown4b > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.Cooldown4b = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown4b - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
			if (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown5b > 0) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.Cooldown5b = entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown5b - 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
		}
	}
}
