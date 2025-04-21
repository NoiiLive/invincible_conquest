package net.clozynoii.invincibleconquest.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.clozynoii.invincibleconquest.world.inventory.DimensionSelectorMenu;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockedSnowProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockedPreHistoricProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockedNetherProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockedFlaxanProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockedEndProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockedDesertProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockedApocalypticProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnNameSnowProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnNamePreHistoricProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnNameNetherProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnNameFlaxanProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnNameEndProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnNameDesertProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnNameApocalypticProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockedSnowProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockedPreHistoricProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockedNetherProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockedFlaxanProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockedEndProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockedDesertProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockedApocalypticProcedure;
import net.clozynoii.invincibleconquest.network.DimensionSelectorButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class DimensionSelectorScreen extends AbstractContainerScreen<DimensionSelectorMenu> {
	private final static HashMap<String, Object> guistate = DimensionSelectorMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_blank16x;
	ImageButton imagebutton_blank22x;
	ImageButton imagebutton_blank22x1;
	ImageButton imagebutton_blank22x2;
	ImageButton imagebutton_blank22x3;
	ImageButton imagebutton_blank22x4;
	ImageButton imagebutton_blank22x5;
	ImageButton imagebutton_blank22x6;
	ImageButton imagebutton_blank22x7;

	public DimensionSelectorScreen(DimensionSelectorMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/dimension_selector.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -26 && mouseX < leftPos + -2 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.literal(ReturnNameNetherProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 0 && mouseX < leftPos + 24 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.literal(ReturnNameEndProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 26 && mouseX < leftPos + 50 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.literal(ReturnNameApocalypticProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 52 && mouseX < leftPos + 76 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.literal(ReturnNameDesertProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + -78 && mouseX < leftPos + -54 && mouseY > topPos + 60 && mouseY < topPos + 84)
			guiGraphics.renderTooltip(font, Component.literal(ReturnNameSnowProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + -51 && mouseX < leftPos + -27 && mouseY > topPos + 60 && mouseY < topPos + 84)
			guiGraphics.renderTooltip(font, Component.literal(ReturnNameFlaxanProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + -26 && mouseX < leftPos + -2 && mouseY > topPos + 60 && mouseY < topPos + 84)
			guiGraphics.renderTooltip(font, Component.literal(ReturnNamePreHistoricProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + -52 && mouseX < leftPos + -28 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.dimension_selector.tooltip_the_overworld"), mouseX, mouseY);
		if (mouseX > leftPos + -79 && mouseX < leftPos + -55 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.dimension_selector.tooltip_random"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/menu_empty.png"), this.leftPos + -213, this.topPos + -37, 0, 0, 427, 240, 427, 240);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + -77, this.topPos + 37, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + -51, this.topPos + 37, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + -25, this.topPos + 37, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + 1, this.topPos + 37, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + 27, this.topPos + 37, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + 53, this.topPos + 37, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + -77, this.topPos + 62, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + -51, this.topPos + 62, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + -25, this.topPos + 62, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + -74, this.topPos + 40, 0, 0, 16, 16, 16, 16);

		if (ReturnLockedNetherProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + -22, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnLockedEndProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + 4, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnLockedApocalypticProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + 30, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnLockedDesertProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + 56, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnLockedSnowProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + -74, this.topPos + 65, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnLockedFlaxanProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + -48, this.topPos + 65, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnLockedPreHistoricProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + -22, this.topPos + 65, 0, 0, 16, 16, 16, 16);
		}

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_portal.png"), this.leftPos + -48, this.topPos + 40, 0, 0, 16, 16, 16, 16);

		if (ReturnUnlockedNetherProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_portal.png"), this.leftPos + -22, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockedEndProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_portal.png"), this.leftPos + 4, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockedApocalypticProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_portal.png"), this.leftPos + 30, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockedDesertProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_portal.png"), this.leftPos + 56, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockedSnowProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_portal.png"), this.leftPos + -74, this.topPos + 65, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockedFlaxanProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_portal.png"), this.leftPos + -48, this.topPos + 65, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockedPreHistoricProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_portal.png"), this.leftPos + -22, this.topPos + 65, 0, 0, 16, 16, 16, 16);
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.invincible_conquest.dimension_selector.label_dimension_seleciton"), -75, 15, -11252677, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.invincible_conquest.dimension_selector.label_dimension_selection"), -76, 14, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_blank16x = new ImageButton(this.leftPos + -77, this.topPos + 37, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new DimensionSelectorButtonMessage(0, x, y, z));
						DimensionSelectorButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x", imagebutton_blank16x);
		this.addRenderableWidget(imagebutton_blank16x);
		imagebutton_blank22x = new ImageButton(this.leftPos + -51, this.topPos + 36, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new DimensionSelectorButtonMessage(1, x, y, z));
						DimensionSelectorButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x", imagebutton_blank22x);
		this.addRenderableWidget(imagebutton_blank22x);
		imagebutton_blank22x1 = new ImageButton(this.leftPos + -25, this.topPos + 37, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new DimensionSelectorButtonMessage(2, x, y, z));
						DimensionSelectorButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x1", imagebutton_blank22x1);
		this.addRenderableWidget(imagebutton_blank22x1);
		imagebutton_blank22x2 = new ImageButton(this.leftPos + 1, this.topPos + 37, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new DimensionSelectorButtonMessage(3, x, y, z));
						DimensionSelectorButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x2", imagebutton_blank22x2);
		this.addRenderableWidget(imagebutton_blank22x2);
		imagebutton_blank22x3 = new ImageButton(this.leftPos + 27, this.topPos + 36, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new DimensionSelectorButtonMessage(4, x, y, z));
						DimensionSelectorButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x3", imagebutton_blank22x3);
		this.addRenderableWidget(imagebutton_blank22x3);
		imagebutton_blank22x4 = new ImageButton(this.leftPos + 53, this.topPos + 37, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new DimensionSelectorButtonMessage(5, x, y, z));
						DimensionSelectorButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x4", imagebutton_blank22x4);
		this.addRenderableWidget(imagebutton_blank22x4);
		imagebutton_blank22x5 = new ImageButton(this.leftPos + -77, this.topPos + 61, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new DimensionSelectorButtonMessage(6, x, y, z));
						DimensionSelectorButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x5", imagebutton_blank22x5);
		this.addRenderableWidget(imagebutton_blank22x5);
		imagebutton_blank22x6 = new ImageButton(this.leftPos + -51, this.topPos + 61, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new DimensionSelectorButtonMessage(7, x, y, z));
						DimensionSelectorButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x6", imagebutton_blank22x6);
		this.addRenderableWidget(imagebutton_blank22x6);
		imagebutton_blank22x7 = new ImageButton(this.leftPos + -25, this.topPos + 62, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new DimensionSelectorButtonMessage(8, x, y, z));
						DimensionSelectorButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x7", imagebutton_blank22x7);
		this.addRenderableWidget(imagebutton_blank22x7);
	}
}
