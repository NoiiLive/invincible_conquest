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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.clozynoii.invincibleconquest.world.inventory.MenuStatsMenu;
import net.clozynoii.invincibleconquest.procedures.ReturnStatVitalityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnStatStrengthProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnStatStaminaProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnStatIntelligenceProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnStatFocusProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnStatDurabilityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnStatAgilityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSpriteMasteryProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSpriteEXPProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnShowMasteryProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnShowEXPProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnPlayerSkillPointsProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnPlayerNameProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnPlayerEntityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnPlayerEXPProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnPlayerAgeProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnPlayerAbilityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnPlayerAbilityIconProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnHasFactionProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnDescriptionVitalityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnDescriptionStrengthProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnDescriptionStaminaProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnDescriptionIntelligenceProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnDescriptionFocusProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnDescriptionDurabilityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnDescriptionAgilityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnBirthdayTimeProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAddPointVitalityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAddPointStrengthProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAddPointStaminaProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAddPointIntelligenceProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAddPointFocusProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAddPointDurabilityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAddPointAgilityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAddPlayerSkillPointsProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAbilityMasteryProcedure;
import net.clozynoii.invincibleconquest.network.MenuStatsButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MenuStatsScreen extends AbstractContainerScreen<MenuStatsMenu> {
	private final static HashMap<String, Object> guistate = MenuStatsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_arrow_1;
	ImageButton imagebutton_arrow_3;
	ImageButton imagebutton_button_skillpoint;
	ImageButton imagebutton_button_skillpoint1;
	ImageButton imagebutton_button_skillpoint2;
	ImageButton imagebutton_button_skillpoint3;
	ImageButton imagebutton_button_skillpoint4;
	ImageButton imagebutton_button_skillpoint5;
	ImageButton imagebutton_button_skillpoint6;
	ImageButton imagebutton_tab_top_unselected;
	ImageButton imagebutton_tab_bottom_unselected;

	public MenuStatsScreen(MenuStatsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/menu_stats.png");

		@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ReturnPlayerEntityProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			this.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + -63, this.topPos + -29, 17, 0f + (float) Math.atan((this.leftPos + -63 - mouseX) / 40.0), (float) Math.atan((this.topPos + -78 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -82 && mouseX < leftPos + 80 && mouseY > topPos + -4 && mouseY < topPos + 5)
			guiGraphics.renderTooltip(font, Component.literal(ReturnPlayerEXPProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + -82 && mouseX < leftPos + 80 && mouseY > topPos + 7 && mouseY < topPos + 16)
			guiGraphics.renderTooltip(font, Component.literal(ReturnAbilityMasteryProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + -88 && mouseX < leftPos + -64 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_stats.tooltip_stat_menu"), mouseX, mouseY);
		if (mouseX > leftPos + -63 && mouseX < leftPos + -39 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_stats.tooltip_ability_menu"), mouseX, mouseY);
		if (mouseX > leftPos + -88 && mouseX < leftPos + -64 && mouseY > topPos + 83 && mouseY < topPos + 107)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_stats.tooltip_player_stats"), mouseX, mouseY);
		if (mouseX > leftPos + -63 && mouseX < leftPos + -39 && mouseY > topPos + 83 && mouseY < topPos + 107)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_stats.tooltip_faction_stats"), mouseX, mouseY);
			
		if (mouseX > leftPos + -42 && mouseX < leftPos + 12 && mouseY > topPos + -41 && mouseY < topPos + -26) {
    		String[] lines = ReturnBirthdayTimeProcedure.execute(entity).split("/n");
    		List<Component> tooltipLines = new ArrayList<>();
    		for (String line : lines) {
        		tooltipLines.add(Component.literal(line));
    		}
    		guiGraphics.renderTooltip(font, tooltipLines, Optional.empty(), mouseX, mouseY);
		}

		if (mouseX > leftPos + -82 && mouseX < leftPos + -23 && mouseY > topPos + 33 && mouseY < topPos + 46) {
    		String[] lines = ReturnDescriptionStrengthProcedure.execute(entity).split("/n");
    		List<Component> tooltipLines = new ArrayList<>();
    		for (String line : lines) {
        		tooltipLines.add(Component.literal(line));
    		}
    		guiGraphics.renderTooltip(font, tooltipLines, Optional.empty(), mouseX, mouseY);
		}
			
		if (mouseX > leftPos + -82 && mouseX < leftPos + -23 && mouseY > topPos + 48 && mouseY < topPos + 61) {
    		String[] lines = ReturnDescriptionDurabilityProcedure.execute(entity).split("/n");
    		List<Component> tooltipLines = new ArrayList<>();
    		for (String line : lines) {
        		tooltipLines.add(Component.literal(line));
    		}
    		guiGraphics.renderTooltip(font, tooltipLines, Optional.empty(), mouseX, mouseY);
		}
			
		if (mouseX > leftPos + -82 && mouseX < leftPos + -23 && mouseY > topPos + 63 && mouseY < topPos + 76) {
    		String[] lines = ReturnDescriptionAgilityProcedure.execute(entity).split("/n");
    		List<Component> tooltipLines = new ArrayList<>();
    		for (String line : lines) {
        		tooltipLines.add(Component.literal(line));
    		}
    		guiGraphics.renderTooltip(font, tooltipLines, Optional.empty(), mouseX, mouseY);
		}
			
		if (mouseX > leftPos + -21 && mouseX < leftPos + 38 && mouseY > topPos + 18 && mouseY < topPos + 31) {
    		String[] lines = ReturnDescriptionStaminaProcedure.execute(entity).split("/n");
    		List<Component> tooltipLines = new ArrayList<>();
    		for (String line : lines) {
        		tooltipLines.add(Component.literal(line));
    		}
    		guiGraphics.renderTooltip(font, tooltipLines, Optional.empty(), mouseX, mouseY);
		}
			
		if (mouseX > leftPos + -21 && mouseX < leftPos + 38 && mouseY > topPos + 33 && mouseY < topPos + 46) {
    		String[] lines = ReturnDescriptionVitalityProcedure.execute(entity).split("/n");
    		List<Component> tooltipLines = new ArrayList<>();
    		for (String line : lines) {
        		tooltipLines.add(Component.literal(line));
    		}
    		guiGraphics.renderTooltip(font, tooltipLines, Optional.empty(), mouseX, mouseY);
		}
			
		if (mouseX > leftPos + -21 && mouseX < leftPos + 38 && mouseY > topPos + 48 && mouseY < topPos + 61) {
    		String[] lines = ReturnDescriptionFocusProcedure.execute(entity).split("/n");
    		List<Component> tooltipLines = new ArrayList<>();
    		for (String line : lines) {
        		tooltipLines.add(Component.literal(line));
    		}
    		guiGraphics.renderTooltip(font, tooltipLines, Optional.empty(), mouseX, mouseY);
		}
			
		if (mouseX > leftPos + -21 && mouseX < leftPos + 38 && mouseY > topPos + 63 && mouseY < topPos + 76) {
    		String[] lines = ReturnDescriptionIntelligenceProcedure.execute(entity).split("/n");
    		List<Component> tooltipLines = new ArrayList<>();
    		for (String line : lines) {
        		tooltipLines.add(Component.literal(line));
    		}
    		guiGraphics.renderTooltip(font, tooltipLines, Optional.empty(), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/mainmenu_stats.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/tab_top_edge.png"), this.leftPos + -89, this.topPos + -111, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/tab_bottom_edge.png"), this.leftPos + -89, this.topPos + 79, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icons_sprite.png"), this.leftPos + -81, this.topPos + -23, Mth.clamp((int) ReturnPlayerAbilityIconProcedure.execute(entity) * 16, 0, 176), 0, 16, 16, 192, 16);

		if (ReturnShowEXPProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/exp_bar.png"), this.leftPos + -81, this.topPos + -3, Mth.clamp((int) ReturnSpriteEXPProcedure.execute(entity) * 160, 0, 2400), 0, 160, 7, 2560, 7);
		}
		if (ReturnShowMasteryProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/mastery_bar.png"), this.leftPos + -81, this.topPos + 8, Mth.clamp((int) ReturnSpriteMasteryProcedure.execute(entity) * 160, 0, 2400), 0, 160, 7, 2560, 7);
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
		guiGraphics.drawString(this.font,

				ReturnPlayerNameProcedure.execute(entity), -37, -56, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerNameProcedure.execute(entity), -38, -57, -1, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerAgeProcedure.execute(entity), -14, -36, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerAgeProcedure.execute(entity), -15, -37, -1, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerAbilityProcedure.execute(entity), -57, -18, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerAbilityProcedure.execute(entity), -58, -19, -1, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerSkillPointsProcedure.execute(entity), -55, 22, -14664184, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerSkillPointsProcedure.execute(entity), -56, 21, -8455136, false);
		guiGraphics.drawString(this.font,

				ReturnAddPlayerSkillPointsProcedure.execute(entity), 51, 21, -1, false);
		guiGraphics.drawString(this.font,

				ReturnStatStrengthProcedure.execute(entity), -55, 37, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnStatStrengthProcedure.execute(entity), -56, 36, -1, false);
		guiGraphics.drawString(this.font,

				ReturnStatDurabilityProcedure.execute(entity), -55, 52, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnStatDurabilityProcedure.execute(entity), -56, 51, -1, false);
		guiGraphics.drawString(this.font,

				ReturnStatAgilityProcedure.execute(entity), -55, 67, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnStatAgilityProcedure.execute(entity), -56, 66, -1, false);
		guiGraphics.drawString(this.font,

				ReturnStatStaminaProcedure.execute(entity), 6, 22, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnStatStaminaProcedure.execute(entity), 5, 21, -1, false);
		guiGraphics.drawString(this.font,

				ReturnStatVitalityProcedure.execute(entity), 6, 37, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnStatVitalityProcedure.execute(entity), 5, 36, -1, false);
		guiGraphics.drawString(this.font,

				ReturnStatFocusProcedure.execute(entity), 6, 52, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnStatFocusProcedure.execute(entity), 5, 51, -1, false);
		guiGraphics.drawString(this.font,

				ReturnStatIntelligenceProcedure.execute(entity), 6, 67, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnStatIntelligenceProcedure.execute(entity), 5, 66, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_1 = new ImageButton(this.leftPos + 39, this.topPos + 16, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/arrow_1.png"), ResourceLocation.parse("invincible_conquest:textures/screens/arrow_2.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuStatsButtonMessage(0, x, y, z));
						MenuStatsButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_arrow_1", imagebutton_arrow_1);
		this.addRenderableWidget(imagebutton_arrow_1);
		imagebutton_arrow_3 = new ImageButton(this.leftPos + 67, this.topPos + 16, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/arrow_3.png"), ResourceLocation.parse("invincible_conquest:textures/screens/arrow_4.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuStatsButtonMessage(1, x, y, z));
						MenuStatsButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_arrow_3", imagebutton_arrow_3);
		this.addRenderableWidget(imagebutton_arrow_3);
		imagebutton_button_skillpoint = new ImageButton(this.leftPos + -36, this.topPos + 33, 13, 13,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint.png"), ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint_s.png")), e -> {
					if (ReturnAddPointStrengthProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new MenuStatsButtonMessage(2, x, y, z));
						MenuStatsButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnAddPointStrengthProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_skillpoint", imagebutton_button_skillpoint);
		this.addRenderableWidget(imagebutton_button_skillpoint);
		imagebutton_button_skillpoint1 = new ImageButton(this.leftPos + -36, this.topPos + 48, 13, 13,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint.png"), ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint_s.png")), e -> {
					if (ReturnAddPointDurabilityProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new MenuStatsButtonMessage(3, x, y, z));
						MenuStatsButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnAddPointDurabilityProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_skillpoint1", imagebutton_button_skillpoint1);
		this.addRenderableWidget(imagebutton_button_skillpoint1);
		imagebutton_button_skillpoint2 = new ImageButton(this.leftPos + -36, this.topPos + 63, 13, 13,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint.png"), ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint_s.png")), e -> {
					if (ReturnAddPointAgilityProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new MenuStatsButtonMessage(4, x, y, z));
						MenuStatsButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnAddPointAgilityProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_skillpoint2", imagebutton_button_skillpoint2);
		this.addRenderableWidget(imagebutton_button_skillpoint2);
		imagebutton_button_skillpoint3 = new ImageButton(this.leftPos + 25, this.topPos + 18, 13, 13,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint.png"), ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint_s.png")), e -> {
					if (ReturnAddPointStaminaProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new MenuStatsButtonMessage(5, x, y, z));
						MenuStatsButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnAddPointStaminaProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_skillpoint3", imagebutton_button_skillpoint3);
		this.addRenderableWidget(imagebutton_button_skillpoint3);
		imagebutton_button_skillpoint4 = new ImageButton(this.leftPos + 25, this.topPos + 33, 13, 13,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint.png"), ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint_s.png")), e -> {
					if (ReturnAddPointVitalityProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new MenuStatsButtonMessage(6, x, y, z));
						MenuStatsButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnAddPointVitalityProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_skillpoint4", imagebutton_button_skillpoint4);
		this.addRenderableWidget(imagebutton_button_skillpoint4);
		imagebutton_button_skillpoint5 = new ImageButton(this.leftPos + 25, this.topPos + 48, 13, 13,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint.png"), ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint_s.png")), e -> {
					if (ReturnAddPointFocusProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new MenuStatsButtonMessage(7, x, y, z));
						MenuStatsButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnAddPointFocusProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_skillpoint5", imagebutton_button_skillpoint5);
		this.addRenderableWidget(imagebutton_button_skillpoint5);
		imagebutton_button_skillpoint6 = new ImageButton(this.leftPos + 25, this.topPos + 63, 13, 13,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint.png"), ResourceLocation.parse("invincible_conquest:textures/screens/button_skillpoint_s.png")), e -> {
					if (ReturnAddPointIntelligenceProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new MenuStatsButtonMessage(8, x, y, z));
						MenuStatsButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnAddPointIntelligenceProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_skillpoint6", imagebutton_button_skillpoint6);
		this.addRenderableWidget(imagebutton_button_skillpoint6);
		imagebutton_tab_top_unselected = new ImageButton(this.leftPos + -64, this.topPos + -109, 26, 32,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/tab_top_unselected.png"), ResourceLocation.parse("invincible_conquest:textures/screens/tab_top_unselected.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuStatsButtonMessage(9, x, y, z));
						MenuStatsButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top_unselected", imagebutton_tab_top_unselected);
		this.addRenderableWidget(imagebutton_tab_top_unselected);
		imagebutton_tab_bottom_unselected = new ImageButton(this.leftPos + -64, this.topPos + 80, 26, 32,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/tab_bottom_unselected.png"), ResourceLocation.parse("invincible_conquest:textures/screens/tab_bottom_unselected.png")), e -> {
					if (ReturnHasFactionProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new MenuStatsButtonMessage(10, x, y, z));
						MenuStatsButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnHasFactionProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_bottom_unselected", imagebutton_tab_bottom_unselected);
		this.addRenderableWidget(imagebutton_tab_bottom_unselected);
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
