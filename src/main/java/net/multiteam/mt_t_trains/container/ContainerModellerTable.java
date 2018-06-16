package net.multiteam.mt_t_trains.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.multiteam.mt_t_trains.client.gui.slot.SlotCraftingMaterial;
import net.multiteam.mt_t_trains.items.ItemCraftingMaterial;
import net.multiteam.mt_t_trains.tileentity.TileModellerTable;

public class ContainerModellerTable extends Container {

    private TileModellerTable te;

    public ContainerModellerTable(IInventory playerInv, TileModellerTable te) {

        this.te = te;

        for(int x = 0; x < 9; ++x) {
            for(Item item : ForgeRegistries.ITEMS.getValues()) {
                if(item instanceof ItemCraftingMaterial) {
                    this.addSlotToContainer(new SlotCraftingMaterial(playerInv, x, 8 + x * 18, 192, item));
                }
            }
        }

        // Player Inventory, Slot 9-35, Slot IDs 4-30
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(playerInv, y*9+x+9, 8+x*18, 134+y*18));
            }
        }

        // Player Inventory, Slot 0-8, Slot IDs 31-39
        for (int x = 0; x < 9; ++x) {
            this.addSlotToContainer(new Slot(playerInv, x, 8+x*18, 192));
        }
    }

    /**
     * Determines whether supplied player can use this container
     *
     * @param playerIn the player
     */
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return te.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();
            if(current != ItemStack.EMPTY) {
                if(fromSlot <= 4) {
                    //Transfers the item from the TE to the player's inventory.
                    for(int i = 5; i < this.inventorySlots.size(); i++) {
                        if(inventorySlots.get(i).getHasStack()) {
                            if(ItemStack.areItemStacksEqual(inventorySlots.get(i).getStack(), current)) {
                                if(inventorySlots.get(i).getStack().getCount() + current.getCount() > inventorySlots.get(i).getSlotStackLimit()) {
                                    int c = inventorySlots.get(i).getStack().getCount() + current.getCount() - inventorySlots.get(i).getSlotStackLimit();
                                    inventorySlots.get(i).getStack().setCount(inventorySlots.get(i).getSlotStackLimit());
                                    inventorySlots.get(i).onSlotChanged();
                                    inventorySlots.get(fromSlot).getStack().setCount(c);
                                    inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened

                                }else{
                                    inventorySlots.get(i).getStack().setCount(inventorySlots.get(i).getStack().getCount() + current.getCount());
                                    inventorySlots.get(i).onSlotChanged();
                                    inventorySlots.get(fromSlot).putStack(ItemStack.EMPTY);
                                    inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened
                                    return current;
                                }
                            }
                        }else{
                            inventorySlots.get(i).putStack(current.copy());
                            inventorySlots.get(i).onSlotChanged(); //Shows that the change happened
                            inventorySlots.get(fromSlot).putStack(ItemStack.EMPTY);
                            inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened
                            return current;
                        }
                    }
                } /*else {
                    if(current.getItem() == Items.DYE) {
                        if(current.getItemDamage() == 1) {
                            int i = 1;
                            if(inventorySlots.get(i).getHasStack()) {
                                if(inventorySlots.get(i).getStack().getCount() + current.getCount() > inventorySlots.get(i).getSlotStackLimit()) {
                                    int c = current.getCount() - (inventorySlots.get(i).getSlotStackLimit() - inventorySlots.get(i).getStack().getCount());
                                    inventorySlots.get(i).getStack().setCount(inventorySlots.get(i).getSlotStackLimit());
                                    inventorySlots.get(i).onSlotChanged(); //Shows that the change happened
                                    inventorySlots.get(fromSlot).getStack().setCount(c);
                                    inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened
                                } else {
                                    inventorySlots.get(i).getStack().setCount(inventorySlots.get(i).getStack().getCount() + current.getCount());
                                    inventorySlots.get(i).onSlotChanged(); //Shows that the change happened
                                    inventorySlots.get(fromSlot).putStack(ItemStack.EMPTY);
                                    inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened

                                }
                            } else {
                                inventorySlots.get(i).putStack(current.copy());
                                inventorySlots.get(i).onSlotChanged(); //Shows that the change happened
                                inventorySlots.get(fromSlot).putStack(ItemStack.EMPTY);
                                inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened
                                return current;
                            }

                        } else if(2 == current.getItemDamage()) {
                            int i = 3;
                            if(inventorySlots.get(i).getHasStack()) {
                                if(inventorySlots.get(i).getStack().getCount() + current.getCount() > inventorySlots.get(i).getSlotStackLimit()) {
                                    int c = current.getCount() - (inventorySlots.get(i).getSlotStackLimit() - inventorySlots.get(i).getStack().getCount());
                                    inventorySlots.get(i).getStack().setCount(inventorySlots.get(i).getSlotStackLimit());
                                    inventorySlots.get(i).onSlotChanged(); //Shows that the change happened
                                    inventorySlots.get(fromSlot).getStack().setCount(c);
                                    inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened
                                } else {
                                    inventorySlots.get(i).getStack().setCount(inventorySlots.get(i).getStack().getCount() + current.getCount());
                                    inventorySlots.get(i).onSlotChanged(); //Shows that the change happened
                                    inventorySlots.get(fromSlot).putStack(ItemStack.EMPTY);
                                    inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened

                                }
                            } else {
                                inventorySlots.get(i).putStack(current.copy());
                                inventorySlots.get(i).onSlotChanged(); //Shows that the change happened
                                inventorySlots.get(fromSlot).putStack(ItemStack.EMPTY);
                                inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened
                                return current;
                            }

                        } else if(4 == current.getItemDamage()) {
                            int i = 2;
                            if(inventorySlots.get(i).getHasStack()) {
                                if(inventorySlots.get(i).getStack().getCount() + current.getCount() > inventorySlots.get(i).getSlotStackLimit()) {
                                    int c = current.getCount() - (inventorySlots.get(i).getSlotStackLimit() - inventorySlots.get(i).getStack().getCount());
                                    inventorySlots.get(i).getStack().setCount(inventorySlots.get(i).getSlotStackLimit());
                                    inventorySlots.get(i).onSlotChanged(); //Shows that the change happened
                                    inventorySlots.get(fromSlot).getStack().setCount(c);
                                    inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened
                                } else {
                                    inventorySlots.get(i).getStack().setCount(inventorySlots.get(i).getStack().getCount() + current.getCount());
                                    inventorySlots.get(i).onSlotChanged(); //Shows that the change happened
                                    inventorySlots.get(fromSlot).putStack(ItemStack.EMPTY);
                                    inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened

                                }
                            } else {
                                inventorySlots.get(i).putStack(current.copy());
                                inventorySlots.get(i).onSlotChanged(); //Shows that the change happened
                                inventorySlots.get(fromSlot).putStack(ItemStack.EMPTY);
                                inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened
                                return current;
                            }
                        }
                    }else if(current.getItem() == Items.CLAY_BALL) {
                        if(inventorySlots.get(0).getHasStack()) {
                            if(inventorySlots.get(0).getStack().getCount() + current.getCount() > inventorySlots.get(0).getSlotStackLimit()) {
                                int c = current.getCount() - (inventorySlots.get(0).getSlotStackLimit() - inventorySlots.get(0).getStack().getCount());
                                inventorySlots.get(0).getStack().setCount(inventorySlots.get(0).getSlotStackLimit());
                                inventorySlots.get(0).onSlotChanged(); //Shows that the change happened
                                inventorySlots.get(fromSlot).getStack().setCount(c);
                                inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened
                            } else {
                                inventorySlots.get(0).getStack().setCount(inventorySlots.get(0).getStack().getCount() + current.getCount());
                                inventorySlots.get(0).onSlotChanged(); //Shows that the change happened
                                inventorySlots.get(fromSlot).putStack(ItemStack.EMPTY);
                                inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened

                            }
                        } else {
                            inventorySlots.get(0).putStack(current.copy());
                            inventorySlots.get(0).onSlotChanged(); //Shows that the change happened
                            inventorySlots.get(fromSlot).putStack(ItemStack.EMPTY);
                            inventorySlots.get(fromSlot).onSlotChanged(); //Shows that the change happened
                        }
                    }
                }*/
                //End Custom Behaviour
            }
            if (current.getCount() == 0)
                slot.putStack(ItemStack.EMPTY);
            else
                slot.onSlotChanged();

            if (current.getCount() == previous.getCount())
                return ItemStack.EMPTY;
            slot.onTake(playerIn, current);

        }
        return previous;
    }

}
