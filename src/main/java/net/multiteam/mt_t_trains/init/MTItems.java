package net.multiteam.mt_t_trains.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.multiteam.mt_t_trains.entity.vehicle.EntityTestTrain;
import net.multiteam.mt_t_trains.enums.EnumWheelTypes;
import net.multiteam.mt_t_trains.items.ItemColoredPart;
import net.multiteam.mt_t_trains.items.ItemModelTrain;
import net.multiteam.mt_t_trains.items.ItemPart;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MTItems {

    public static final Item[] TRAIN_WHEEL = new Item[3];
    public static final Item[] ENGINE = new Item[2];
    public static final Item TEST_TRAIN_BODY;
    public static final Item TEST_TRAIN;

    static {
        for(EnumWheelTypes wheelTypes : EnumWheelTypes.values()) {
            TRAIN_WHEEL[wheelTypes.getId()] = new ItemPart(wheelTypes.getName() + "_wheel");
        }
        TEST_TRAIN_BODY = new ItemColoredPart("test_train_body");
        TEST_TRAIN = new ItemModelTrain("test_train", EntityTestTrain.class);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

}
