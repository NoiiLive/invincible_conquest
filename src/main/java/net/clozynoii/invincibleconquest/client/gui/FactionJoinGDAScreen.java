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
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.world.inventory.FactionJoinGDAMenu;
import net.clozynoii.invincibleconquest.network.FactionJoinGDAButtonMessage;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModScreens.WidgetScreen;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FactionJoinGDAScreen extends AbstractContainerScreen<FactionJoinGDAMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = FactionJoinGDAMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_join;
	Button button_decline;

	public FactionJoinGDAScreen(FactionJoinGDAMenu container, Inventory inventory, Component text) {
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
		if (Minecraft.getInstance().screen instanceof FactionJoinGDAScreen sc) {

		}
		return textstate;
	}

	public HashMap<String, Object> getWidgets() {
		return guistate;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/faction_join_gda.png");

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

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/menu_join_gda.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

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
	}

	@Override
	public void init() {
		super.init();
		button_join = Button.builder(Component.translatable("gui.invincible_conquest.faction_join_gda.button_join"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FactionJoinGDAButtonMessage(0, x, y, z, getEditBoxAndCheckBoxValues()));
				FactionJoinGDAButtonMessage.handleButtonAction(entity, 0, x, y, z, getEditBoxAndCheckBoxValues());
			}
		}).bounds(this.leftPos + -75, this.topPos + 3, 71, 20).build();
		guistate.put("button:button_join", button_join);
		this.addRenderableWidget(button_join);
		button_decline = Button.builder(Component.translatable("gui.invincible_conquest.faction_join_gda.button_decline"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FactionJoinGDAButtonMessage(1, x, y, z, getEditBoxAndCheckBoxValues()));
				FactionJoinGDAButtonMessage.handleButtonAction(entity, 1, x, y, z, getEditBoxAndCheckBoxValues());
			}
		}).bounds(this.leftPos + 2, this.topPos + 3, 72, 20).build();
		guistate.put("button:button_decline", button_decline);
		this.addRenderableWidget(button_decline);
	}
}
