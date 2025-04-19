
package net.clozynoii.invincibleconquest.network;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record DimensionSelectorButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<DimensionSelectorButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "dimension_selector_buttons"));

	public static final StreamCodec<RegistryFriendlyByteBuf, DimensionSelectorButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, DimensionSelectorButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new DimensionSelectorButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<DimensionSelectorButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final DimensionSelectorButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;

				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = DimensionSelectorMenu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

		if (buttonID == 0) {

			SelectDimensionRandomProcedure.execute();
		}
		if (buttonID == 1) {

			SelectDimensionOverworldProcedure.execute();
		}
		if (buttonID == 2) {

			SelectDimensionNetherProcedure.execute();
		}
		if (buttonID == 3) {

			SelectDimensionEndProcedure.execute();
		}
		if (buttonID == 4) {

			SelectDimensionApocalypticProcedure.execute();
		}
		if (buttonID == 5) {

			SelectDimensionDesertProcedure.execute();
		}
		if (buttonID == 6) {

			SelectDimensionSnowProcedure.execute();
		}
		if (buttonID == 7) {

			SelectDimensionFlaxanProcedure.execute();
		}
		if (buttonID == 8) {

			SelectDimensionPreHistoricProcedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleConquestMod.addNetworkMessage(DimensionSelectorButtonMessage.TYPE, DimensionSelectorButtonMessage.STREAM_CODEC, DimensionSelectorButtonMessage::handleData);
	}

}
