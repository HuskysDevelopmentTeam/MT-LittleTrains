package net.multiteam.mt_t_trains.client.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.multiteam.mt_t_trains.items.ItemCraftingMaterial;

public class SlotCraftingMaterial extends Slot {

    private Item item;

    public SlotCraftingMaterial(IInventory inventoryIn, int index, int xPosition, int yPosition, Item item) {
        super(inventoryIn, index, xPosition, yPosition);
        this.item = item;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return item instanceof ItemCraftingMaterial;
    }

}
