
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.clozynoii.invincibleconquest.network.UseAbility5Message;
import net.clozynoii.invincibleconquest.network.UseAbility4Message;
import net.clozynoii.invincibleconquest.network.UseAbility3Message;
import net.clozynoii.invincibleconquest.network.UseAbility2Message;
import net.clozynoii.invincibleconquest.network.UseAbility1Message;
import net.clozynoii.invincibleconquest.network.ToggleOutputMessage;
import net.clozynoii.invincibleconquest.network.SwitchBarsMessage;
import net.clozynoii.invincibleconquest.network.StatMenuMessage;
import net.clozynoii.invincibleconquest.network.FollowUpMessage;
import net.clozynoii.invincibleconquest.network.FlightMessage;
import net.clozynoii.invincibleconquest.network.FlightBoostMessage;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class InvincibleConquestModKeyMappings {
	public static final KeyMapping USE_ABILITY_1 = new KeyMapping("key.invincible_conquest.use_ability_1", GLFW.GLFW_KEY_Z, "key.categories.invincible_conquest") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new UseAbility1Message(0, 0));
				UseAbility1Message.pressAction(Minecraft.getInstance().player, 0, 0);
				USE_ABILITY_1_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - USE_ABILITY_1_LASTPRESS);
				PacketDistributor.sendToServer(new UseAbility1Message(1, dt));
				UseAbility1Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_ABILITY_2 = new KeyMapping("key.invincible_conquest.use_ability_2", GLFW.GLFW_KEY_X, "key.categories.invincible_conquest") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new UseAbility2Message(0, 0));
				UseAbility2Message.pressAction(Minecraft.getInstance().player, 0, 0);
				USE_ABILITY_2_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - USE_ABILITY_2_LASTPRESS);
				PacketDistributor.sendToServer(new UseAbility2Message(1, dt));
				UseAbility2Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_ABILITY_3 = new KeyMapping("key.invincible_conquest.use_ability_3", GLFW.GLFW_KEY_C, "key.categories.invincible_conquest") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new UseAbility3Message(0, 0));
				UseAbility3Message.pressAction(Minecraft.getInstance().player, 0, 0);
				USE_ABILITY_3_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - USE_ABILITY_3_LASTPRESS);
				PacketDistributor.sendToServer(new UseAbility3Message(1, dt));
				UseAbility3Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_ABILITY_4 = new KeyMapping("key.invincible_conquest.use_ability_4", GLFW.GLFW_KEY_V, "key.categories.invincible_conquest") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new UseAbility4Message(0, 0));
				UseAbility4Message.pressAction(Minecraft.getInstance().player, 0, 0);
				USE_ABILITY_4_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - USE_ABILITY_4_LASTPRESS);
				PacketDistributor.sendToServer(new UseAbility4Message(1, dt));
				UseAbility4Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_ABILITY_5 = new KeyMapping("key.invincible_conquest.use_ability_5", GLFW.GLFW_KEY_B, "key.categories.invincible_conquest") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new UseAbility5Message(0, 0));
				UseAbility5Message.pressAction(Minecraft.getInstance().player, 0, 0);
				USE_ABILITY_5_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - USE_ABILITY_5_LASTPRESS);
				PacketDistributor.sendToServer(new UseAbility5Message(1, dt));
				UseAbility5Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SWITCH_BARS = new KeyMapping("key.invincible_conquest.switch_bars", GLFW.GLFW_KEY_Y, "key.categories.invincible_conquest") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SWITCH_BARS_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - SWITCH_BARS_LASTPRESS);
				PacketDistributor.sendToServer(new SwitchBarsMessage(1, dt));
				SwitchBarsMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping STAT_MENU = new KeyMapping("key.invincible_conquest.stat_menu", GLFW.GLFW_KEY_G, "key.categories.invincible_conquest") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				STAT_MENU_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - STAT_MENU_LASTPRESS);
				PacketDistributor.sendToServer(new StatMenuMessage(1, dt));
				StatMenuMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FOLLOW_UP = new KeyMapping("key.invincible_conquest.follow_up", GLFW.GLFW_KEY_R, "key.categories.invincible_conquest") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new FollowUpMessage(0, 0));
				FollowUpMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FLIGHT = new KeyMapping("key.invincible_conquest.flight", GLFW.GLFW_KEY_N, "key.categories.invincible_conquest") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				FLIGHT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - FLIGHT_LASTPRESS);
				PacketDistributor.sendToServer(new FlightMessage(1, dt));
				FlightMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TOGGLE_OUTPUT = new KeyMapping("key.invincible_conquest.toggle_output", GLFW.GLFW_KEY_M, "key.categories.invincible_conquest") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ToggleOutputMessage(0, 0));
				ToggleOutputMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				TOGGLE_OUTPUT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - TOGGLE_OUTPUT_LASTPRESS);
				PacketDistributor.sendToServer(new ToggleOutputMessage(1, dt));
				ToggleOutputMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FLIGHT_BOOST = new KeyMapping("key.invincible_conquest.flight_boost", GLFW.GLFW_KEY_SPACE, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new FlightBoostMessage(0, 0));
				FlightBoostMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				FLIGHT_BOOST_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - FLIGHT_BOOST_LASTPRESS);
				PacketDistributor.sendToServer(new FlightBoostMessage(1, dt));
				FlightBoostMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long USE_ABILITY_1_LASTPRESS = 0;
	private static long USE_ABILITY_2_LASTPRESS = 0;
	private static long USE_ABILITY_3_LASTPRESS = 0;
	private static long USE_ABILITY_4_LASTPRESS = 0;
	private static long USE_ABILITY_5_LASTPRESS = 0;
	private static long SWITCH_BARS_LASTPRESS = 0;
	private static long STAT_MENU_LASTPRESS = 0;
	private static long FLIGHT_LASTPRESS = 0;
	private static long TOGGLE_OUTPUT_LASTPRESS = 0;
	private static long FLIGHT_BOOST_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(USE_ABILITY_1);
		event.register(USE_ABILITY_2);
		event.register(USE_ABILITY_3);
		event.register(USE_ABILITY_4);
		event.register(USE_ABILITY_5);
		event.register(SWITCH_BARS);
		event.register(STAT_MENU);
		event.register(FOLLOW_UP);
		event.register(FLIGHT);
		event.register(TOGGLE_OUTPUT);
		event.register(FLIGHT_BOOST);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				USE_ABILITY_1.consumeClick();
				USE_ABILITY_2.consumeClick();
				USE_ABILITY_3.consumeClick();
				USE_ABILITY_4.consumeClick();
				USE_ABILITY_5.consumeClick();
				SWITCH_BARS.consumeClick();
				STAT_MENU.consumeClick();
				FOLLOW_UP.consumeClick();
				FLIGHT.consumeClick();
				TOGGLE_OUTPUT.consumeClick();
				FLIGHT_BOOST.consumeClick();
			}
		}
	}
}
