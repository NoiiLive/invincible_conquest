package net.clozynoii.invincibleconquest.client.gui;

public class AtomEveCreationScreen extends AbstractContainerScreen<AtomEveCreationMenu> {

	private final static HashMap<String, Object> guistate = AtomEveCreationMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	EditBox item;

	public AtomEveCreationScreen(AtomEveCreationMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/atom_eve_creation.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);

		super.render(guiGraphics, mouseX, mouseY, partialTicks);

		item.render(guiGraphics, mouseX, mouseY, partialTicks);

		this.renderTooltip(guiGraphics, mouseX, mouseY);

	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/atomeve_creation.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}

		if (item.isFocused())
			return item.keyPressed(key, b, c);

		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String itemValue = item.getValue();
		super.resize(minecraft, width, height);
		item.setValue(itemValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();

		item = new EditBox(this.font, this.leftPos + -94, this.topPos + -12, 188, 18, Component.translatable("gui.invincible_conquest.atom_eve_creation.item")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.atom_eve_creation.item").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.atom_eve_creation.item").getString());
				else
					setSuggestion(null);
			}
		};
		item.setMaxLength(32767);
		item.setSuggestion(Component.translatable("gui.invincible_conquest.atom_eve_creation.item").getString());

		guistate.put("text:item", item);
		this.addWidget(this.item);

	}

}
