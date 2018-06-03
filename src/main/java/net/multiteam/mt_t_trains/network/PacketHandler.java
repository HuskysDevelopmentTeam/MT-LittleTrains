package net.multiteam.mt_t_trains.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.multiteam.mt_t_trains.Reference;
import net.multiteam.mt_t_trains.network.message.MessageAccelerating;
import net.multiteam.mt_t_trains.network.message.MessageTurn;

public class PacketHandler {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    public static void init() {
        INSTANCE.registerMessage(MessageTurn.class, MessageTurn.class, 0, Side.SERVER);
        INSTANCE.registerMessage(MessageAccelerating.class, MessageAccelerating.class, 1, Side.SERVER);
    }
}
