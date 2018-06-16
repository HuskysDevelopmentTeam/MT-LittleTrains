package net.multiteam.mt_t_trains.items;

import net.hdt.huskylib2.items.ItemMod;
import net.multiteam.mt_t_trains.MTTTrains;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

public class ItemCraftingMaterial extends ItemMod {

    public ItemCraftingMaterial(String name) {
        super(name, MOD_ID);
        setCreativeTab(MTTTrains.ITEMS_CREATIVE_TAB);
    }

}
