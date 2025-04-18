package net.clozynoii.invincibleconquest.client.gui;

import org.joml.Vector3f;
import org.joml.Quaternionf;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.world.inventory.MenuFactionStatsMenu;
import net.clozynoii.invincibleconquest.procedures.ReturnPlayerEntityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnFactionSpriteProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnFactionReputationProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnFactionRankProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnFactionNameProcedure;
import net.clozynoii.invincibleconquest.network.MenuFactionStatsButtonMessage;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModScreens.WidgetScreen;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MenuFactionStatsScreen extends AbstractContainerScreen<MenuFactionStatsMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = MenuFactionStatsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_tab_top_unselected;
	ImageButton imagebutton_tab_bottom_unselected;
	ImageButton imagebutton_icon_flag;

	public MenuFactionStatsScreen(MenuFactionStatsMenu container, Inventory inventory, Component text) {
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
		if (Minecraft.getInstance().screen instanceof MenuFactionStatsScreen sc) {

		}
		return textstate;
	}

	public HashMap<String, Object> getWidgets() {
		return guistate;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/menu_faction_stats.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ReturnPlayerEntityProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			this.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + -54, this.topPos + 72, 40, 0f + (float) Math.atan((this.leftPos + -54 - mouseX) / 40.0), (float) Math.atan((this.topPos + 23 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -88 && mouseX < leftPos + -64 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_faction_stats.tooltip_stat_menu"), mouseX, mouseY);
		if (mouseX > leftPos + -63 && mouseX < leftPos + -39 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_faction_stats.tooltip_ability_menu"), mouseX, mouseY);
		if (mouseX > leftPos + -88 && mouseX < leftPos + -64 && mouseY > topPos + 83 && mouseY < topPos + 107)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_faction_stats.tooltip_player_stats"), mouseX, mouseY);
		if (mouseX > leftPos + -63 && mouseX < leftPos + -39 && mouseY > topPos + 83 && mouseY < topPos + 107)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_faction_stats.tooltip_faction_stats"), mouseX, mouseY);
		if (mouseX > leftPos + 60 && mouseX < leftPos + 80 && mouseY > topPos + 55 && mouseY < topPos + 75)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_faction_stats.tooltip_attempt_takeover"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/menu_faction.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/tab_top_edge.png"), this.leftPos + -89, this.topPos + -111, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/tab_bottom_fill.png"), this.leftPos + -89, this.topPos + 80, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/tab_bottom_middle.png"), this.leftPos + -64, this.topPos + 79, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/sprite_factions.png"), this.leftPos + -81, this.topPos + -37, Mth.clamp((int) ReturnFactionSpriteProcedure.execute(entity) * 16, 0, 64), 0, 16, 16, 80, 16);

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

				ReturnFactionReputationProcedure.execute(entity), 42, -12, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnFactionReputationProcedure.execute(entity), 41, -13, -1, false);
		guiGraphics.drawString(this.font,

				ReturnFactionRankProcedure.execute(entity), -57, -32, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnFactionRankProcedure.execute(entity), -58, -33, -1, false);
		guiGraphics.drawString(this.font,

				ReturnFactionNameProcedure.execute(entity), -77, -54, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnFactionNameProcedure.execute(entity), -78, -55, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_tab_top_unselected = new ImageButton(this.leftPos + -64, this.topPos + -109, 26, 32,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/tab_top_unselected.png"), ResourceLocation.parse("invincible_conquest:textures/screens/tab_top_unselected.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuFactionStatsButtonMessage(0, x, y, z, getEditBoxAndCheckBoxValues()));
						MenuFactionStatsButtonMessage.handleButtonAction(entity, 0, x, y, z, getEditBoxAndCheckBoxValues());
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top_unselected", imagebutton_tab_top_unselected);
		this.addRenderableWidget(imagebutton_tab_top_unselected);
		imagebutton_tab_bottom_unselected = new ImageButton(this.leftPos + -89, this.topPos + 80, 26, 32,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/tab_bottom_unselected.png"), ResourceLocation.parse("invincible_conquest:textures/screens/tab_bottom_unselected.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuFactionStatsButtonMessage(1, x, y, z, getEditBoxAndCheckBoxValues()));
						MenuFactionStatsButtonMessage.handleButtonAction(entity, 1, x, y, z, getEditBoxAndCheckBoxValues());
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_bottom_unselected", imagebutton_tab_bottom_unselected);
		this.addRenderableWidget(imagebutton_tab_bottom_unselected);
		imagebutton_icon_flag = new ImageButton(this.leftPos + 62, this.topPos + 57, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/icon_flag.png"), ResourceLocation.parse("invincible_conquest:textures/screens/icon_flag.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuFactionStatsButtonMessage(2, x, y, z, getEditBoxAndCheckBoxValues()));
						MenuFactionStatsButtonMessage.handleButtonAction(entity, 2, x, y, z, getEditBoxAndCheckBoxValues());
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_icon_flag", imagebutton_icon_flag);
		this.addRenderableWidget(imagebutton_icon_flag);
	}

	private void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}
}
