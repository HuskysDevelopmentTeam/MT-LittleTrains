package com.mrcrayfish.rccar.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.mrcrayfish.rccar.Reference.MOD_ID;

public class ModCrafting 
{
	public static void init()
	{
		GameRegistry.addShapedRecipe(new ResourceLocation(MOD_ID, "controller"), new ResourceLocation(MOD_ID, "items"), new ItemStack(ModItems.controller), " B ", "LIL", "IRI", 'B', Blocks.IRON_BARS, 'I', Items.IRON_INGOT, 'R', Items.REDSTONE, 'L', Blocks.LEVER);
		GameRegistry.addShapedRecipe(new ResourceLocation(MOD_ID, "car"), new ResourceLocation(MOD_ID, "items"), new ItemStack(ModItems.car), " C ", "CFC", "BRB", 'C', new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 14), 'F', Blocks.FURNACE, 'R', Items.REDSTONE, 'B', new ItemStack(Blocks.WOOL, 1, 15));
	}
}
