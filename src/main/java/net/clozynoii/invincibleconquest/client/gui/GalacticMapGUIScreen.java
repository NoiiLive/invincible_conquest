package net.clozynoii.invincibleconquest.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.world.inventory.GalacticMapGUIMenu;
import net.clozynoii.invincibleconquest.procedures.ReturnMapCoordsProcedure;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModScreens.WidgetScreen;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GalacticMapGUIScreen extends AbstractContainerScreen<GalacticMapGUIMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = GalacticMapGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public GalacticMapGUIScreen(GalacticMapGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	public static HashMap<String, String> getEditBoxAndCheckBoxValues() {
		HashMap<String, String> textstate = new HashMap<>();
		if (Minecraft.getInstance().screen instanceof GalacticMapGUIScreen sc) {

		}
		return textstate;
	}

	public HashMap<String, Object> getWidgets() {
		return guistate;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/galactic_map_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -69 && mouseX < leftPos + -57 && mouseY > topPos + -67 && mouseY < topPos + -55)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.galactic_map_gui.tooltip_sun_x0_z0"), mouseX, mouseY);
		if (mouseX > leftPos + -52 && mouseX < leftPos + -44 && mouseY > topPos + -52 && mouseY < topPos + -44)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.galactic_map_gui.tooltip_earth_x135_y135"), mouseX, mouseY);
		if (mouseX > leftPos + -44 && mouseX < leftPos + -40 && mouseY > topPos + -54 && mouseY < topPos + -50)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.galactic_map_gui.tooltip_moon_x150_y150"), mouseX, mouseY);
		if (mouseX > leftPos + -59 && mouseX < leftPos + -51 && mouseY > topPos + -41 && mouseY < topPos + -33)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.galactic_map_gui.tooltip_mars_x200_y200"), mouseX, mouseY);
		if (mouseX > leftPos + 54 && mouseX < leftPos + 62 && mouseY > topPos + 60 && mouseY < topPos + 68)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.galactic_map_gui.tooltip_viltrum_x1000_y1000"), mouseX, mouseY);
		if (mouseX > leftPos + 30 && mouseX < leftPos + 38 && mouseY > topPos + 19 && mouseY < topPos + 27)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.galactic_map_gui.tooltip_talescria_x700_z900"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/galactic_map.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

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

				ReturnMapCoordsProcedure.execute(entity), -84, 87, -1, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
