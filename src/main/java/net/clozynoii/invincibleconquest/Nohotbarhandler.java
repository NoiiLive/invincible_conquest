package net.clozynoii.invincibleconquest;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;

import java.util.Set;

@EventBusSubscriber(modid = "invincible_conquest", value = Dist.CLIENT)
public class Nohotbarhandler {

    private static final Set<ResourceLocation> HIDDEN_LAYERS = Set.of(
        ResourceLocation.fromNamespaceAndPath("minecraft", "air_level"),
        ResourceLocation.fromNamespaceAndPath("minecraft", "armor_level"),
        ResourceLocation.fromNamespaceAndPath("minecraft", "player_health"),
        ResourceLocation.fromNamespaceAndPath("minecraft", "food_level")
    );

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onRenderGuiLayer(RenderGuiLayerEvent.Pre event) {
        if (!HIDDEN_LAYERS.contains(event.getName())) return;

        Minecraft mc = Minecraft.getInstance();
        Entity entity = mc.player;
        if (entity == null) return;
            event.setCanceled(true);
    }
}
