package net.clozynoii.invincibleconquest.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class InvincibleConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Double> LEVELEXP;
	public static final ModConfigSpec.ConfigValue<Double> LEVELSP;
	public static final ModConfigSpec.ConfigValue<Double> BIRTHDAYTIME;
	public static final ModConfigSpec.ConfigValue<Double> STRDAMAGE;
	public static final ModConfigSpec.ConfigValue<Double> STRKNOCKBACK;
	public static final ModConfigSpec.ConfigValue<Double> DURDMGRESISTANCE;
	public static final ModConfigSpec.ConfigValue<Double> DURKBRESISTANCE;
	public static final ModConfigSpec.ConfigValue<Double> AGLMOVEMENTSPEED;
	public static final ModConfigSpec.ConfigValue<Double> AGLATTACKSPEED;
	public static final ModConfigSpec.ConfigValue<Double> STMBONUS;
	public static final ModConfigSpec.ConfigValue<Double> STMDRAIN;
	public static final ModConfigSpec.ConfigValue<Double> VITHEALTHBOOST;
	public static final ModConfigSpec.ConfigValue<Double> VITREGENRATE;
	public static final ModConfigSpec.ConfigValue<Double> FOCCDREDUCE;
	public static final ModConfigSpec.ConfigValue<Double> FOCMOVEDURATION;
	public static final ModConfigSpec.ConfigValue<Double> INTEXPBONUS;
	public static final ModConfigSpec.ConfigValue<Double> VILTRUMITEBOOST;
	public static final ModConfigSpec.ConfigValue<Double> VILTRUMITEMAXBONUS;
	static {
		BUILDER.push("Player (General)");
		LEVELEXP = BUILDER.comment("The amount of EXP the cap is increased by per Level").define("EXP Per Level", (double) 25);
		LEVELSP = BUILDER.comment("The amount of Skill Points gained per Level").define("Skill Point Per Level", (double) 5);
		BIRTHDAYTIME = BUILDER.comment("The time in ticks it takes for a player to age up (24000 = 1 Day)").define("Birthday Time", (double) 24000);
		BUILDER.pop();
		BUILDER.push("Player (Stats)");
		STRDAMAGE = BUILDER.comment("The amount of bonus attack damage that max Strength provides").define("STR Attack Damage", (double) 20);
		STRKNOCKBACK = BUILDER.comment("The amount of attack knockback that max Strength provides").define("STR Knockback", (double) 0.5);
		DURDMGRESISTANCE = BUILDER.comment("The amount of damage resistance that max Durability provides").define("DUR Damage Resistance", (double) 20);
		DURKBRESISTANCE = BUILDER.comment("The amount of knockback resistance that max Durability provides").define("DUR Knockback Resistance", (double) 0.5);
		AGLMOVEMENTSPEED = BUILDER.comment("The amount of bonus movement speed that max Agility provides").define("AGL Movement Speed", (double) 0.3);
		AGLATTACKSPEED = BUILDER.comment("The amount of bonus attack speed that max Agility provides").define("AGL Attack Speed", (double) 2);
		STMBONUS = BUILDER.comment("The amount of extra stamina that max Stamina provides").define("STM Stamina Bonus", (double) 400);
		STMDRAIN = BUILDER.comment("The percentage of stamina drain reduced that max Stamina provides").define("STM Stamina Drain", (double) 25);
		VITHEALTHBOOST = BUILDER.comment("The amount of extra health that max Vitality provides").define("VIT Health Boost", (double) 80);
		VITREGENRATE = BUILDER.comment("The amount of health healed per second that max Vitality provides").define("VIT Regen Rate", (double) 4);
		FOCCDREDUCE = BUILDER.comment("The percentage of cooldown that max Focus reduces").define("FOC Cooldown Reduction", (double) 25);
		FOCMOVEDURATION = BUILDER.comment("The amount of extra seconds a move can last that max Focus provides").define("FOC Move Duration", (double) 5);
		INTEXPBONUS = BUILDER.comment("The percentage of bonus EXP that max Intelligence provides").define("INT EXP Bonus", (double) 25);
		BUILDER.pop();
		BUILDER.push("Abilities (Viltrumite)");
		VILTRUMITEBOOST = BUILDER.comment("The stat boost per year that a Viltrumite ages").define("Viltrumite Age Boost", (double) 1);
		VILTRUMITEMAXBONUS = BUILDER.comment("The maximum stat boost that a Viltrumites age can provide").define("Viltrumite Max Age Bonus", (double) 100);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
