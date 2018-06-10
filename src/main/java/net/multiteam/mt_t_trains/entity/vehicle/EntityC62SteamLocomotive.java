package net.multiteam.mt_t_trains.entity.vehicle;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.multiteam.mt_t_trains.entity.EntityTrainPart;
import net.multiteam.mt_t_trains.init.MTItems;

public class EntityC62SteamLocomotive extends EntityTrainPart {

    public EntityC62SteamLocomotive(World worldIn) {
        super(worldIn);
    }

    @Override
    public void entityInit() {
        super.entityInit();

        if (world.isRemote) {
            body = new ItemStack(MTItems.C62_STEAM_LOCOMOTIVE_BODY);
            wheel = new ItemStack(MTItems.TRAIN_WHEEL[1]);
            engine = new ItemStack(MTItems.ENGINE[2]);
        }
    }

    @Override
    public SoundEvent getMovingSound() {
        return SoundEvents.BLOCK_ANVIL_BREAK;
    }

}
