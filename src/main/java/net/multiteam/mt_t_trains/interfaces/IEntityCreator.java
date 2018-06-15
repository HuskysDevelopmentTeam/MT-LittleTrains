package net.multiteam.mt_t_trains.interfaces;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public interface IEntityCreator<T extends Entity> {

    public T createEntity(World world);

}
