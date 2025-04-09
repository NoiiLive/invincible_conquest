package net.clozynoii.invincibleconquest.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;

import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

@EventBusSubscriber(modid = InvincibleConquestMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class InvincibleConquestModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModList.get().getModContainerById("invincible_conquest").get().registerConfig(ModConfig.Type.COMMON, InvincibleConfigConfiguration.SPEC, "invincible_conquest.toml");
		});
	}
}
