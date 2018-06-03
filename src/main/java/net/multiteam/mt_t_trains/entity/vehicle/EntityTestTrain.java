package net.multiteam.mt_t_trains.entity.vehicle;

import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.multiteam.mt_t_trains.entity.EntityLandVehicle;

public class EntityTestTrain extends EntityLandVehicle {

    public EntityTestTrain(World worldIn) {
        super(worldIn);
    }

    @Override
    public SoundEvent getMovingSound() {
        return null;
    }

    @Override
    public SoundEvent getRidingSound() {
        return null;
    }

    @Override
    public double getMountedYOffset() {
        return 0;
    }

}
