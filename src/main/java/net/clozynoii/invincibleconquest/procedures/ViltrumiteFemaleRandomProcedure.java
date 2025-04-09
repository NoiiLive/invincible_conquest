package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.clozynoii.invincibleconquest.entity.ViltrumiteFemaleEntity;

public class ViltrumiteFemaleRandomProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		random = Mth.nextInt(RandomSource.create(), 1, 5);
		if (random == 1) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_black");
		} else if (random == 2) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_brown");
		} else if (random == 3) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_blonde");
		} else if (random == 4) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_gray");
		} else if (random == 5) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_white");
		}
	}
}
