package net.multiteam.mt_t_trains.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.multiteam.mt_t_trains.entity.EngineType;
import net.multiteam.mt_t_trains.entity.vehicle.*;
import net.multiteam.mt_t_trains.enums.EnumWheelTypes;
import net.multiteam.mt_t_trains.items.*;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MTItems {

    public static final Item[] TRAIN_WHEEL = new Item[3];
    public static final Item[] ENGINE = new Item[4];
    public static final Item DB_ICE_MOTORCART_BODY, C62_STEAM_LOCOMOTIVE_BODY, C62_STEAM_LOCOMOTIVE_TENDER_BODY, RBH_TE_2_2_BODY, ČD_810_BODY, SantaFe_8081_BODY;
    public static final Item DB_ICE_MOTORCART, C62_STEAM_LOCOMOTIVE, C62_STEAM_LOCOMOTIVE_TENDER, RBH_TE_2_2, ČD_810, SantaFe_8081;

    public static final Item TRAIN_CONTROLLER;

    static {
        for (EnumWheelTypes wheelTypes : EnumWheelTypes.values()) {
            TRAIN_WHEEL[wheelTypes.getId()] = new ItemPart(wheelTypes.getName() + "_wheel");
        }
        DB_ICE_MOTORCART = new ItemModelTrain<>("db_ice_motorcart_electric", EntityDBIceMotorcart::new);
        DB_ICE_MOTORCART_BODY = new ItemColoredPart("db_ice_motorcart_electric_body");
        C62_STEAM_LOCOMOTIVE = new ItemModelTrain<>("C62_steam_locomotive", EntityC62SteamLocomotive::new);
        C62_STEAM_LOCOMOTIVE_BODY = new ItemColoredPart("C62_steam_locomotive_body");
        C62_STEAM_LOCOMOTIVE_TENDER = new ItemModelTrain<>("C62_steam_locomotive_tender", EntityC62SteamLocomotiveTender::new);
        C62_STEAM_LOCOMOTIVE_TENDER_BODY = new ItemColoredPart("C62_steam_locomotive_tender_body");
        RBH_TE_2_2 = new ItemModelTrain<>("rhb_te_2_2", EntityRbhTE22::new);
        RBH_TE_2_2_BODY = new ItemColoredPart("rhb_te_2_2_body");
        ČD_810_BODY = new ItemColoredPart("ČD_810_body");
        ČD_810 = new ItemModelTrain<>("ČD_810", EntityČD810::new);
        SantaFe_8081_BODY = new ItemColoredPart("santafe_8081_body");
        SantaFe_8081 = new ItemModelTrain<>("santafe_8081", EntitySantaFe8081::new);

        TRAIN_CONTROLLER = new ItemController();
        for (EngineType type : EngineType.values()) {
            ENGINE[type.getId()] = new ItemEngine(type);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

}
