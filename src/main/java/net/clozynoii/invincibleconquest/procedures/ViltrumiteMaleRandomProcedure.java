package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.clozynoii.invincibleconquest.entity.ViltrumiteMaleEntity;

public class ViltrumiteMaleRandomProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		random = Mth.nextInt(RandomSource.create(), 1, 5);
		if (random == 1) {
			if (entity instanceof ViltrumiteMaleEntity animatable)
				animatable.setTexture("viltrumite_male_black");
		} else if (random == 2) {
			if (entity instanceof ViltrumiteMaleEntity animatable)
				animatable.setTexture("viltrumite_male_brown");
		} else if (random == 3) {
			if (entity instanceof ViltrumiteMaleEntity animatable)
				animatable.setTexture("viltrumite_male_blonde");
		} else if (random == 4) {
			if (entity instanceof ViltrumiteMaleEntity animatable)
				animatable.setTexture("viltrumite_male_gray");
		} else if (random == 5) {
			if (entity instanceof ViltrumiteMaleEntity animatable)
				animatable.setTexture("viltrumite_male_white");
		}
	}
}
