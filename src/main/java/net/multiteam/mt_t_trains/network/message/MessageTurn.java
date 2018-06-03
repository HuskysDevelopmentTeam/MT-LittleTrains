package net.multiteam.mt_t_trains.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.multiteam.mt_t_trains.entity.EntityTrain;

public class MessageTurn implements IMessage, IMessageHandler<MessageTurn, IMessage> {
    private EntityTrain.TurnDirection direction;

    public MessageTurn() {
    }

    public MessageTurn(EntityTrain.TurnDirection direction) {
        this.direction = direction;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(direction.ordinal());
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.direction = EntityTrain.TurnDirection.values()[buf.readInt()];
    }

    @Override
    public IMessage onMessage(MessageTurn message, MessageContext ctx) {
        EntityPlayerMP player = ctx.getServerHandler().player;
        Entity riding = player.getRidingEntity();
        if (riding instanceof EntityTrain) {
            ((EntityTrain) riding).setTurnDirection(message.direction);
        }
        return null;
    }
}
