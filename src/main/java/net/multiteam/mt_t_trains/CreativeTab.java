package net.multiteam.mt_t_trains;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class CreativeTab extends CreativeTabs {

    private String title = "";

    private ItemStack icon = ItemStack.EMPTY;
    private boolean displayRandom = true;
    private int tempIndex = 0;
    private ItemStack tempDisplayStack = ItemStack.EMPTY;

    public CreativeTab(String label) {
        super(label);
    }

    @Override
    public ItemStack getIconItemStack() {
        if (this.displayRandom) {
            if (Minecraft.getSystemTime() % 120 == 0) {
                this.updateDisplayStack();
            }
            return this.tempDisplayStack;
        } else return this.icon;
    }

    @Override
    public String getTranslatedTabLabel() {
        return getTabLabel();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private void updateDisplayStack() {
        if (this.displayRandom) {
            NonNullList<ItemStack> itemStacks = NonNullList.create();
            this.displayAllRelevantItems(itemStacks);
            this.tempDisplayStack = !itemStacks.isEmpty() ? itemStacks.get(tempIndex) : ItemStack.EMPTY;
            if (++tempIndex >= itemStacks.size()) tempIndex = 0;
        } else {
            if (this.icon.isEmpty()) {
                this.tempDisplayStack = new ItemStack(Items.DIAMOND);
            }
            this.tempDisplayStack = this.icon;
        }
    }

    @Override
    public ItemStack getTabIconItem() {
        return this.getIconItemStack();
    }

}
