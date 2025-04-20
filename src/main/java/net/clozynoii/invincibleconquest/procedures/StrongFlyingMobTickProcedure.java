package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.entity.ViltrumiteMaleEntity;
import net.clozynoii.invincibleconquest.entity.ViltrumiteFemaleEntity;
import net.clozynoii.invincibleconquest.entity.OmnivincibleEntity;
import net.clozynoii.invincibleconquest.entity.OmniManEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleVeilEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleSinisterEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleMohawkEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleDarkEntity;
import net.clozynoii.invincibleconquest.entity.InvincibleBlueEntity;
import net.clozynoii.invincibleconquest.entity.BattleBeastEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StrongFlyingMobTickProcedure {
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
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:strongflying")))) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity instanceof InvincibleEntity) {
					if (entity instanceof InvincibleEntity) {
						((InvincibleEntity) entity).setAnimation("swim");
					}
				} else if (entity instanceof BattleBeastEntity) {
					if (entity instanceof BattleBeastEntity) {
						((BattleBeastEntity) entity).setAnimation("swim");
					}
				} else if (entity instanceof OmniManEntity) {
					if (entity instanceof OmniManEntity) {
						((OmniManEntity) entity).setAnimation("swim");
					}
				} else if (entity instanceof ViltrumiteMaleEntity) {
					if (entity instanceof ViltrumiteMaleEntity) {
						((ViltrumiteMaleEntity) entity).setAnimation("swim");
					}
				} else if (entity instanceof ViltrumiteFemaleEntity) {
					if (entity instanceof ViltrumiteFemaleEntity) {
						((ViltrumiteFemaleEntity) entity).setAnimation("swim");
					}
				} else if (entity instanceof InvincibleBlueEntity) {
					if (entity instanceof InvincibleBlueEntity) {
						((InvincibleBlueEntity) entity).setAnimation("swim");
					}
				} else if (entity instanceof InvincibleMohawkEntity) {
					if (entity instanceof InvincibleMohawkEntity) {
						((InvincibleMohawkEntity) entity).setAnimation("swim");
					}
				} else if (entity instanceof InvincibleSinisterEntity) {
					if (entity instanceof InvincibleSinisterEntity) {
						((InvincibleSinisterEntity) entity).setAnimation("swim");
					}
				} else if (entity instanceof InvincibleDarkEntity) {
					if (entity instanceof InvincibleDarkEntity) {
						((InvincibleDarkEntity) entity).setAnimation("swim");
					}
				} else if (entity instanceof InvincibleVeilEntity) {
					if (entity instanceof InvincibleVeilEntity) {
						((InvincibleVeilEntity) entity).setAnimation("swim");
					}
				} else if (entity instanceof OmnivincibleEntity) {
					if (entity instanceof OmnivincibleEntity) {
						((OmnivincibleEntity) entity).setAnimation("swim");
					}
				}
				if (entity instanceof Player _plr && !(_plr.isFallFlying())) {
					_plr.startFallFlying();
				}
				entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) / 2),
						(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY()) / 2), (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) / 2)));
				entity.getPersistentData().putDouble("strongflyingtimer", (entity.getPersistentData().getDouble("strongflyingtimer") + 1));
				if (entity.getPersistentData().getDouble("strongflyingtimer") >= 30) {
					entity.getPersistentData().putDouble("strongflyingtimer", 0);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get()), x, (y + 1), z, 1, 0.1, 0.1, 0.1, 0);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.sonic_boom")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.sonic_boom")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) / 1),
							(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY()) / 1), (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) / 1)));
				}
			}
		}
	}
}
