package net.multiteam.mt_t_trains.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.multiteam.mt_t_trains.block.BlockBase;
import net.multiteam.mt_t_trains.block.BlockControlBox;
import net.multiteam.mt_t_trains.block.BlockModellerTable;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MTBlocks {

    public static final Block STRAIGHT_TRACK, POWER_TRACK, BUFFER_TRACK, CONTROL_BOX, MODELLER_TABLE;

    static {
        STRAIGHT_TRACK = new BlockBase(Material.WOOD, "straight_track");
        POWER_TRACK = new BlockBase(Material.WOOD, "power_track");
        BUFFER_TRACK = new BlockBase(Material.WOOD, "buffer_track");
        CONTROL_BOX = new BlockControlBox();
        MODELLER_TABLE = new BlockModellerTable();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

    }

}
