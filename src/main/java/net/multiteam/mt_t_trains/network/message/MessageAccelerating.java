package net.multiteam.mt_t_trains.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.multiteam.mt_t_trains.entity.EntityTrain;

public class MessageAccelerating implements IMessage, IMessageHandler<MessageAccelerating, IMessage> {
    private EntityTrain.AccelerationDirection acceleration;

    public MessageAccelerating() {
    }

    public MessageAccelerating(EntityTrain.AccelerationDirection acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(acceleration.ordinal());
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.acceleration = EntityTrain.AccelerationDirection.values()[buf.readInt()];
    }

    @Override
    public IMessage onMessage(MessageAccelerating message, MessageContext ctx) {
        EntityPlayerMP player = ctx.getServerHandler().player;
        Entity riding = player.getRidingEntity();
        if (riding instanceof EntityTrain) {
            ((EntityTrain) riding).setAcceleration(message.acceleration);
        }
        return null;
    }
}
