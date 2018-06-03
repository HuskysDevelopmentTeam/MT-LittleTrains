package net.multiteam.mt_t_trains.client.audio;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.multiteam.mt_t_trains.entity.EntityVehicle;

/**
 * Author: MrCrayfish
 */
@SideOnly(Side.CLIENT)
public class MovingSoundVehicle extends MovingSound
{
    private final EntityVehicle vehicle;

    public MovingSoundVehicle(EntityVehicle vehicle)
    {
        super(vehicle.getMovingSound(), SoundCategory.NEUTRAL);
        this.vehicle = vehicle;
        this.repeat = true;
        this.repeatDelay = 0;
        this.volume = 0.001F;
    }

    @Override
    public void update()
    {
        this.volume = 0.8F;
        if(!vehicle.isDead && vehicle.getControllingPassenger() != null && vehicle.getControllingPassenger() != Minecraft.getMinecraft().player)
        {
            EntityPlayer localPlayer = Minecraft.getMinecraft().player;
            this.xPosF = (float) (vehicle.posX + (localPlayer.posX - vehicle.posX) * 0.65);
            this.yPosF = (float) (vehicle.posY + (localPlayer.posY - vehicle.posY) * 0.65);
            this.zPosF = (float) (vehicle.posZ + (localPlayer.posZ - vehicle.posZ) * 0.65);
            this.pitch = vehicle.getMinEnginePitch() + (vehicle.getMaxEnginePitch() - vehicle.getMinEnginePitch()) * Math.abs(vehicle.getNormalSpeed());
        }
        else
        {
            this.donePlaying = true;
        }
    }
}
