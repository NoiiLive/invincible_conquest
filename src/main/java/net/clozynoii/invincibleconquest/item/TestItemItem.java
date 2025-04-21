
package net.clozynoii.invincibleconquest.item;

public class TestItemItem extends Item {
	public TestItemItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		TestItemRightclickedProcedure.execute();
		return ar;
	}
}