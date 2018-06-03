package net.multiteam.mt_t_trains.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.multiteam.mt_t_trains.items.ItemPart;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MTItems {

    public static final Item TRAIN_WEEL;

    static {
        TRAIN_WEEL = new ItemPart("train_wheel");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

}
