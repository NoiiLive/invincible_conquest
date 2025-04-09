package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerEXPGainProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double expTotal = 0;
		if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
			if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
				expTotal = Math.ceil((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)
						* ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerIntelligence + sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
								/ (double) InvincibleConfigConfiguration.INTEXPBONUS.get()));
			} else {
				expTotal = Math.ceil((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)
						+ (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerIntelligence / (double) InvincibleConfigConfiguration.INTEXPBONUS.get()));
			}
			{
				InvincibleConquestModVariables.PlayerVariables _vars = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.PlayerEXP = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerEXP + expTotal;
				_vars.syncPlayerVariables(sourceentity);
			}
			if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals("None")) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 100) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.PlayerReputation = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation + Math.round((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 100);
						_vars.syncPlayerVariables(sourceentity);
					}
				}
			}
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("+" + new java.text.DecimalFormat("##").format(expTotal) + " EXP")), true);
			InvincibleConquestMod.queueServerWork(20, () -> {
				if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals("None")) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("+" + (new java.text.DecimalFormat("##").format(Math.round((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 100))) + " Reputation")), true);
				}
			});
		}
	}
}
