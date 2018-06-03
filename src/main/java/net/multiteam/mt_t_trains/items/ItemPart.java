package net.multiteam.mt_t_trains.items;

import net.hdt.huskylib2.items.ItemMod;
import net.multiteam.mt_t_trains.MTTTrains;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

public class ItemPart extends ItemMod {

    public ItemPart(String id) {
        super(id, MOD_ID);
        this.setCreativeTab(MTTTrains.MT_T_TRAINS_CREATIVE_TAB);
    }

}
