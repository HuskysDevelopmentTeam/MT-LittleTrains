package net.multiteam.mt_t_trains.entity.vehicle;

import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.multiteam.mt_t_trains.entity.EntityTrainPart;
import net.multiteam.mt_t_trains.init.MTItems;
import net.multiteam.mt_t_trains.init.MTSounds;

public class EntitySantaFe8081 extends EntityTrainPart {

    public EntitySantaFe8081(World worldIn) {
        super(worldIn);
    }

    @Override
    public void entityInit() {
        super.entityInit();

        if (world.isRemote) {
            body = new ItemStack(MTItems.C62_STEAM_LOCOMOTIVE_BODY);
            wheel = new ItemStack(MTItems.TRAIN_WHEEL[1]);
            engine = new ItemStack(MTItems.ENGINE[1]);
        }
    }

    @Override
    public SoundEvent getMovingSound() {
        return MTSounds.DIESEL_MOVING;
    }

}
