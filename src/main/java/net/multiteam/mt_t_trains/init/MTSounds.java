package net.multiteam.mt_t_trains.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

/**
 * Author: MrCrayfish
 */
public class MTSounds {

    public static final SoundEvent HORN_MONO;
    public static final SoundEvent HORN_STEREO;
    public static final SoundEvent ELECTRIC_STARTUP;
    public static final SoundEvent ELECTRIC_MOVING;
    public static final SoundEvent DIESEL_IDLE;
    public static final SoundEvent DIESEL_STARTUP;
    public static final SoundEvent DIESEL_START_MOVING;
    public static final SoundEvent DIESEL_MOVING;

    static {
        HORN_MONO = registerSound("horn_mono");
        HORN_STEREO = registerSound("horn_stereo");
        ELECTRIC_STARTUP = registerSound("electric_startup");
        ELECTRIC_MOVING = registerSound("electric_moving");
        DIESEL_IDLE = registerSound("diesel_idle");
        DIESEL_STARTUP = registerSound("diesel_startup");
        DIESEL_START_MOVING = registerSound("diesel_start_moving");
        DIESEL_MOVING = registerSound("diesel_moving");
    }

    private static SoundEvent registerSound(String soundNameIn) {
        ResourceLocation resource = new ResourceLocation(MOD_ID, soundNameIn);
        return new SoundEvent(resource).setRegistryName(MOD_ID, soundNameIn);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerSounds(final RegistryEvent.Register<SoundEvent> event) {
            IForgeRegistry<SoundEvent> registry = event.getRegistry();
            registry.register(ELECTRIC_STARTUP);
            registry.register(ELECTRIC_MOVING);
            registry.register(DIESEL_IDLE);
            registry.register(DIESEL_STARTUP);
            registry.register(DIESEL_START_MOVING);
            registry.register(DIESEL_MOVING);
        }
    }
}
