package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnOwnedPlanetProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		if ((entity.level().dimension()) == Level.OVERWORLD) {
			return "Current Owners: " + InvincibleConquestModVariables.MapVariables.get(world).EarthOwner;
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:moon_world"))) {
			return "Current Owners: " + InvincibleConquestModVariables.MapVariables.get(world).MoonOwner;
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:mars_world"))) {
			return "Current Owners: " + InvincibleConquestModVariables.MapVariables.get(world).MarsOwner;
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:viltrum_world"))) {
			return "Current Owners: " + InvincibleConquestModVariables.MapVariables.get(world).ViltrumOwner;
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:talescria_world"))) {
			return "Current Owners: " + InvincibleConquestModVariables.MapVariables.get(world).TalescriaOwner;
		}
		return "Current Owners: " + " None";
	}
}
