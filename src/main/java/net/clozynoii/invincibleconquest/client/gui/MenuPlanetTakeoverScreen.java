package net.clozynoii.invincibleconquest.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.clozynoii.invincibleconquest.world.inventory.MenuPlanetTakeoverMenu;
import net.clozynoii.invincibleconquest.procedures.ReturnOwnedPlanetProcedure;
import net.clozynoii.invincibleconquest.network.MenuPlanetTakeoverButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MenuPlanetTakeoverScreen extends AbstractContainerScreen<MenuPlanetTakeoverMenu> {
	private final static HashMap<String, Object> guistate = MenuPlanetTakeoverMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_hostile;
	Button button_passive;
	Button button_decline;

	public MenuPlanetTakeoverScreen(MenuPlanetTakeoverMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/menu_planet_takeover.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/menu_take_planet.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				ReturnOwnedPlanetProcedure.execute(world, entity), -82, 38, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_hostile = Button.builder(Component.translatable("gui.invincible_conquest.menu_planet_takeover.button_hostile"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MenuPlanetTakeoverButtonMessage(0, x, y, z));
				MenuPlanetTakeoverButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -77, this.topPos + 1, 49, 20).build();
		guistate.put("button:button_hostile", button_hostile);
		this.addRenderableWidget(button_hostile);
		button_passive = Button.builder(Component.translatable("gui.invincible_conquest.menu_planet_takeover.button_passive"), e -> {
		}).bounds(this.leftPos + 27, this.topPos + 1, 49, 20).build();
		guistate.put("button:button_passive", button_passive);
		this.addRenderableWidget(button_passive);
		button_decline = Button.builder(Component.translatable("gui.invincible_conquest.menu_planet_takeover.button_decline"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MenuPlanetTakeoverButtonMessage(2, x, y, z));
				MenuPlanetTakeoverButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + -25, this.topPos + 1, 49, 20).build();
		guistate.put("button:button_decline", button_decline);
		this.addRenderableWidget(button_decline);
	}
}
