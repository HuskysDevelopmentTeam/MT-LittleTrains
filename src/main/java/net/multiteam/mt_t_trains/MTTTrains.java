package net.multiteam.mt_t_trains;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.multiteam.mt_t_trains.entity.CustomDataSerializers;
import net.multiteam.mt_t_trains.entity.EntityTrain;
import net.multiteam.mt_t_trains.entity.vehicle.EntityC62SteamLocomotive;
import net.multiteam.mt_t_trains.entity.vehicle.EntityC62SteamLocomotiveTender;
import net.multiteam.mt_t_trains.entity.vehicle.EntityDBIceMotorcart;
import net.multiteam.mt_t_trains.entity.vehicle.EntityRbhTE22;
import net.multiteam.mt_t_trains.init.MTItems;
import net.multiteam.mt_t_trains.network.PacketHandler;
import net.multiteam.mt_t_trains.proxy.SProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class MTTTrains {

    public static final CreativeTabs MT_T_TRAINS_CREATIVE_TAB = new CreativeTabs("mt_t_trains") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(MTItems.DB_ICE_MOTORCART_BODY);
        }
    };

    @Mod.Instance
    public static MTTTrains instance;

    @SidedProxy(clientSide = Reference.C_PROXY, serverSide = Reference.S_PROXY)
    public static SProxy proxy;

    public int nextEntityId;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        PacketHandler.init();
        CustomDataSerializers.register();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        registerTrainParts();

        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    private void registerTrainParts() {
        registerTrainPart("db_ice_motorcart_electric", EntityDBIceMotorcart.class);
        registerTrainPart("rhb_te_2_2", EntityRbhTE22.class);
        registerTrainPart("C62_steam_locomotive", EntityC62SteamLocomotive.class);
        registerTrainPart("C62_steam_locomotive_tender", EntityC62SteamLocomotiveTender.class);
    }

    private void registerTrainPart(String id, Class<? extends EntityTrain> clazz) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, id), clazz, id, nextEntityId++, this, 64, 1, true);
    }

}
