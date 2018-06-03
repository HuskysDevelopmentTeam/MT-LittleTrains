package net.multiteam.mt_t_trains.block;

import net.hdt.huskylib2.blocks.BlockMod;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.multiteam.mt_t_trains.MTTTrains;

import javax.annotation.Nullable;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

public class BlockControlBox extends BlockMod {

    public BlockControlBox() {
        super(Material.IRON, MOD_ID, "control_box");
        setCreativeTab(MTTTrains.MT_T_TRAINS_CREATIVE_TAB);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
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

}
