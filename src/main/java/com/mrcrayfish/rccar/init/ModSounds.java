package com.mrcrayfish.rccar.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModSounds {
	
	public static SoundEvent connect;
	
	public static void register()
	{
		connect = registerSound("crccm:connect");
	}

	private static SoundEvent registerSound(String soundNameIn)
    {
		ResourceLocation sound = new ResourceLocation(soundNameIn);
		ForgeRegistries.SOUND_EVENTS.register(new SoundEvent(sound).setRegistryName(soundNameIn));
        return ForgeRegistries.SOUND_EVENTS.getValue(sound);
    }
}
