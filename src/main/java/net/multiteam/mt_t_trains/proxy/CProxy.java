package net.multiteam.mt_t_trains.proxy;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.multiteam.mt_t_trains.client.render.vehicle.RenderTestTrain;
import net.multiteam.mt_t_trains.entity.vehicle.EntityTestTrain;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class CProxy extends SProxy {

    @Override
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityTestTrain.class, RenderTestTrain::new);
        super.preInit(event);
    }

    @Override
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);
        IItemColor color = (stack, index) -> {
            if(stack.hasTagCompound() && index == 1) {
                return stack.getTagCompound().getInteger("color");
            }
            return 0x7f0000; // White
        };

        /*for(Item item : Item.getItemById(Item.getIdFromItem(ForgeRegistries.ITEMS.containsValue()))) {
            if(item instanceof ItemColoredPart) {
                Minecraft.getMinecraft().getItemColors().registerItemColorHandler(color, item);
            }
        }*/
    }

    @Override
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

}
