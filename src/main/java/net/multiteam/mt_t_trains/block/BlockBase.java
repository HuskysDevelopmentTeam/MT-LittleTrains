package net.multiteam.mt_t_trains.block;

import net.hdt.huskylib2.blocks.BlockMod;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.multiteam.mt_t_trains.MTTTrains;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

public class BlockBase extends BlockMod {

    public BlockBase(Material material, String name) {
        super(material, MOD_ID, name);
        setCreativeTab(MTTTrains.TERRAIN_CREATIVE_TAB);
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isTranslucent(IBlockState state) {
        return true;
    }

    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

}
