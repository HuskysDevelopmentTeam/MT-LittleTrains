package net.multiteam.mt_t_trains.block;

import net.hdt.huskylib2.blocks.BlockFacing;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.multiteam.mt_t_trains.MTTTrains;

import javax.annotation.Nullable;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

public class BlockControlBox extends BlockFacing {

    public BlockControlBox() {
        super(Material.IRON , MOD_ID, "control_box");
        setCreativeTab(MTTTrains.MAIN_CREATIVE_TAB);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return super.createTileEntity(world, state);
    }

    /**
     * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
     * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
     */
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

}
