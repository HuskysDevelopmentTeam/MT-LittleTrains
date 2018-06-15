package net.multiteam.mt_t_trains.entity.vehicle;

import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.multiteam.mt_t_trains.entity.EntityTrainPart;
import net.multiteam.mt_t_trains.init.MTItems;
import net.multiteam.mt_t_trains.init.MTSounds;

public class EntityČD810 extends EntityTrainPart {

    public EntityČD810(World worldIn) {
        super(worldIn);
    }

    @Override
    public void entityInit() {
        super.entityInit();

        if (world.isRemote) {
            body = new ItemStack(MTItems.ČD_810_BODY);
            wheel = new ItemStack(MTItems.TRAIN_WHEEL[1]);
            engine = new ItemStack(MTItems.ENGINE[1]);
        }
    }

    @Override
    public SoundEvent getMovingSound() {
        return MTSounds.DIESEL_MOVING;
    }

}
