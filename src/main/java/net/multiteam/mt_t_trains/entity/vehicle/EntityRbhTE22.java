package net.multiteam.mt_t_trains.entity.vehicle;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.multiteam.mt_t_trains.entity.EntityTrainPart;
import net.multiteam.mt_t_trains.init.MTItems;

public class EntityRbhTE22 extends EntityTrainPart {

    public EntityRbhTE22(World worldIn) {
        super(worldIn);
    }

    @Override
    public void entityInit() {
        super.entityInit();

        if (world.isRemote) {
            body = new ItemStack(MTItems.RBH_TE_2_2_BODY);
            wheel = new ItemStack(MTItems.TRAIN_WHEEL[1]);
            engine = new ItemStack(MTItems.ENGINE[0]);
        }
    }

    @Override
    public SoundEvent getMovingSound() {
        return SoundEvents.BLOCK_ANVIL_BREAK;
    }

}
