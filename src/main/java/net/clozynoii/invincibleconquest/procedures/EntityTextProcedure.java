package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.clozynoii.invincibleconquest.entity.AnissaEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EntityTextProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double textrandom = 0;
		if (entity instanceof AnissaEntity) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.getPersistentData().putDouble("enemytext", (entity.getPersistentData().getDouble("enemytext") + 1));
				if (entity.getPersistentData().getDouble("enemytext") >= Mth.nextInt(RandomSource.create(), 100, 600)) {
					entity.getPersistentData().putDouble("enemytext", 0);
					textrandom = Mth.nextInt(RandomSource.create(), 1, 6);
					if (textrandom == 1) {
						if (!(entity.getPersistentData().getString("existingdialogue")).contains("1")) {
							if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<Anissa> I expected more from a Viltrumite warrior."), false);
							entity.getPersistentData().putString("existingdialogue", (entity.getPersistentData().getString("existingdialogue") + " 1"));
						}
					} else if (textrandom == 2) {
						if (!(entity.getPersistentData().getString("existingdialogue")).contains("2")) {
							if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<Anissa> Pain is a teacher. Learn from it."), false);
							entity.getPersistentData().putString("existingdialogue", (entity.getPersistentData().getString("existingdialogue") + " 2"));
						}
					} else if (textrandom == 3) {
						if (!(entity.getPersistentData().getString("existingdialogue")).contains("3")) {
							if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<Anissa> Why fight for a world that will never accept you?"), false);
							entity.getPersistentData().putString("existingdialogue", (entity.getPersistentData().getString("existingdialogue") + " 3"));
						}
					} else if (textrandom == 4) {
						if (!(entity.getPersistentData().getString("existingdialogue")).contains("4")) {
							if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<Anissa> Your attachments make you weak. Embrace your true nature."), false);
							entity.getPersistentData().putString("existingdialogue", (entity.getPersistentData().getString("existingdialogue") + " 4"));
						}
					} else if (textrandom == 5) {
						if (!(entity.getPersistentData().getString("existingdialogue")).contains("5")) {
							if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<Anissa> You're sickening, TRY HARDER."), false);
							entity.getPersistentData().putString("existingdialogue", (entity.getPersistentData().getString("existingdialogue") + " 5"));
						}
					} else if (textrandom == 6) {
						if (!(entity.getPersistentData().getString("existingdialogue")).contains("6")) {
							if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<Anissa> You're holding back. Typical of one who's gone soft."), false);
							entity.getPersistentData().putString("existingdialogue", (entity.getPersistentData().getString("existingdialogue") + " 6"));
						}
					}
				}
			}
		}
	}
}
