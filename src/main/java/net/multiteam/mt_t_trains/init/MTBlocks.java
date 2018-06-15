package net.multiteam.mt_t_trains.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.multiteam.mt_t_trains.block.BlockBase;
import net.multiteam.mt_t_trains.block.BlockControlBox;
import net.multiteam.mt_t_trains.block.BlockModellerTable;
import net.multiteam.mt_t_trains.block.BlockRailBase;
import net.multiteam.mt_t_trains.enums.TrackVariants;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MTBlocks {

    public static final Block[] TRACKS = new Block[15];
    public static final Block CONTROL_BOX, MODELLER_TABLE;
    public static final Block BALLAST_BLOCK, COBBLE_ANDESITE, COBBLE_HARDENED_CLAY, COPPER_BLOCK, COPPER_ORE, TIN_BLOCK, TIN_ORE;

    static {
        for(TrackVariants trackVariants : TrackVariants.values()) {
            TRACKS[trackVariants.getId()] = new BlockRailBase(String.format("track_%s", trackVariants.getName()));
        }

        CONTROL_BOX = new BlockControlBox();
        MODELLER_TABLE = new BlockModellerTable();

        BALLAST_BLOCK = new BlockBase(Material.ROCK, "ballast_block");
        COBBLE_ANDESITE = new BlockBase(Material.ROCK, "cobble_andesite");
        COBBLE_HARDENED_CLAY = new BlockBase(Material.ROCK, "cobble_hardened_clay");
        COPPER_BLOCK = new BlockBase(Material.IRON, "copper_block");
        COPPER_ORE = new BlockBase(Material.ROCK, "copper_ore");
        TIN_BLOCK = new BlockBase(Material.IRON, "tin_block");
        TIN_ORE = new BlockBase(Material.ROCK, "tin_ore");
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

    }

}
