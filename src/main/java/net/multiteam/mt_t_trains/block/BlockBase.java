package net.multiteam.mt_t_trains.block;

import net.hdt.huskylib2.blocks.BlockMod;
import net.minecraft.block.material.Material;
import net.multiteam.mt_t_trains.MTTTrains;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

public class BlockBase extends BlockMod {

    public BlockBase(Material material, String name) {
        super(material, MOD_ID, name);
        setCreativeTab(MTTTrains.MT_T_TRAINS_CREATIVE_TAB);
    }

}
