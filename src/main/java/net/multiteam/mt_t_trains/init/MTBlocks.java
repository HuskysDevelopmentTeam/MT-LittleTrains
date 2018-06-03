package net.multiteam.mt_t_trains.init;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.multiteam.mt_t_trains.block.BlockRail;
import net.multiteam.mt_t_trains.block.BlockRailDetector;
import net.multiteam.mt_t_trains.block.BlockRailPowered;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MTBlocks {

    public static final Block RAIL, DETECTOR_RAIL, POWERED_RAIL;

    static {
        RAIL = new BlockRail();
        DETECTOR_RAIL = new BlockRailDetector();
        POWERED_RAIL = new BlockRailPowered();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

    }

}
