package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BarrierHitCancelProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event.getEntity() != null) {
            execute(event, event.getEntity());
        }
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity == null)
            return;

        if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(InvincibleConquestModMobEffects.BARRIER_EFFECT)) {
            if (event instanceof ICancellableEvent _cancellable) {
                _cancellable.setCanceled(true);
            }
        }
    }
}
