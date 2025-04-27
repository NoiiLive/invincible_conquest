package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.entity.AtomShieldEntity;

import javax.annotation.Nullable;
import java.util.Comparator;

@EventBusSubscriber
public class PassiveShieldTargetingProcedure {
    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Pre event) {
        execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;

        if (entity instanceof Mob mob) {
            // Check if there is a cooldown active
            if (mob.getPersistentData().getInt("forced_target_cooldown") > 0) {
                // Decrease the cooldown each tick
                mob.getPersistentData().putInt("forced_target_cooldown", mob.getPersistentData().getInt("forced_target_cooldown") - 1);
                return; // Skip retargeting while cooldown active
            }

            // Normal behavior if no cooldown
            if (mob.getTarget() instanceof Player player && player.hasEffect(InvincibleConquestModMobEffects.BARRIER_EFFECT)) {
                // Find the closest AtomShieldEntity
                Entity barrierEntity = world.getEntitiesOfClass(AtomShieldEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z)))
                        .findFirst()
                        .orElse(null);

                if (barrierEntity instanceof LivingEntity target) {
                    mob.setTarget(target); // Redirect to barrier mob
                    mob.getPersistentData().putInt("forced_target_cooldown", 40); // 2 seconds of forced targeting (40 ticks)
                }
            }
        }
    }
}
