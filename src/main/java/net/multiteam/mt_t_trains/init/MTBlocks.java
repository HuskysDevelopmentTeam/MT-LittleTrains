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

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MTBlocks {

    public static final Block STRAIGHT_TRACK, STRAIGHT_TRACK_BALLASTED, STRAIGHT_TRACK_GRASS_PLATED,
            POWER_TRACK, POWER_TRACK_BALLASTED, POWER_TRACK_GRASS_PLATED, BUFFER_TRACK, BUFFER_TRACK_BALLASTED,
            BUFFER_TRACK_GRASS_PLATED, TURN_TRACK_90_DEG, TURN_TRACK_90_DEG_BALLASTED, TURN_TRACK_90_DEG_GRASS_PLATED;
    public static final Block CONTROL_BOX, MODELLER_TABLE;
    public static final Block BALLAST_BLOCK, COBBLE_ANDESITE, COBBLE_HARDENED_CLAY, COPPER_BLOCK, COPPER_ORE, TIN_BLOCK, TIN_ORE;

    static {
        STRAIGHT_TRACK = new BlockRailBase("straight_track");
        STRAIGHT_TRACK_BALLASTED = new BlockRailBase("straight_track_ballasted");
        STRAIGHT_TRACK_GRASS_PLATED = new BlockRailBase("straight_track_grass_plated");
        POWER_TRACK = new BlockRailBase("power_track");
        POWER_TRACK_BALLASTED = new BlockRailBase("power_track_ballasted");
        POWER_TRACK_GRASS_PLATED = new BlockRailBase("power_track_grass_plated");
        BUFFER_TRACK = new BlockRailBase("buffer_track");
        BUFFER_TRACK_BALLASTED = new BlockRailBase("buffer_track_ballasted");
        BUFFER_TRACK_GRASS_PLATED = new BlockRailBase("buffer_track_grass_plated");
        TURN_TRACK_90_DEG = new BlockRailBase("turn_track_90_deg");
        TURN_TRACK_90_DEG_BALLASTED = new BlockRailBase("turn_track_90_deg_ballasted");
        TURN_TRACK_90_DEG_GRASS_PLATED = new BlockRailBase("turn_track_90_deg_grass_plated");

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
