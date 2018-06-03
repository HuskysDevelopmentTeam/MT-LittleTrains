package net.multiteam.mt_t_trains.items;

import net.hdt.huskylib2.items.ItemMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.multiteam.mt_t_trains.MTTTrains;
import net.multiteam.mt_t_trains.entity.EntityTrain;
import net.multiteam.mt_t_trains.init.MTBlocks;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

public class ItemModelTrain extends ItemMod {

    private Class<? extends EntityTrain> entity;

    public ItemModelTrain(String name, Class<? extends EntityTrain> entity) {
        super(name, MOD_ID);
        this.entity = entity;
        setCreativeTab(MTTTrains.MT_T_TRAINS_CREATIVE_TAB);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        if(worldIn.getBlockState(new BlockPos(playerIn.posX, playerIn.posY, playerIn.posZ)) == MTBlocks.STRAIGHT_TRACK.getDefaultState()) {
            try {
                worldIn.spawnEntity(entity.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.print(String.format("Spawned %s" + "\n", entity.getName()));
            return ActionResult.newResult(EnumActionResult.PASS, new ItemStack(this));
        }

        System.out.print(String.format("Could not spawn %s because of that the block is not a rail" + "\n", entity.getName()));
        return ActionResult.newResult(EnumActionResult.PASS, new ItemStack(this));
    }

}
