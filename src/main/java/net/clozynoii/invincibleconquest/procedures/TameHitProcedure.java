package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TameHitProcedure {

    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event.getEntity() != null) {
            execute(event, event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
        if (entity instanceof TamableAnimal tamable && tamable.isTame()) {
            if (sourceentity != null && tamable.getOwner() == sourceentity) {
                if (event instanceof ICancellableEvent cancellable) {
                    cancellable.setCanceled(true); // Cancel only if the attacker is the tamer
                }
            }
        }
    }
}
