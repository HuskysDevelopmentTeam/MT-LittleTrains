package net.multiteam.mt_t_trains.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.multiteam.mt_t_trains.MTTTrains;
import net.multiteam.mt_t_trains.tileentity.TileModellerTable;

import javax.annotation.Nullable;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

public class BlockModellerTable extends BlockModFacingContainer {

    public BlockModellerTable() {
        super(Material.IRON, MOD_ID, "modeller_table");
        setCreativeTab(MTTTrains.MAIN_CREATIVE_TAB);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileModellerTable();
    }

    /*@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote & !playerIn.isSneaking()) {
            playerIn.openGui(MTTTrains.instance, MTGuiHandler.GUI_MODELLER_TABLE_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }*/

    /**
     * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
     * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
     */
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

}
