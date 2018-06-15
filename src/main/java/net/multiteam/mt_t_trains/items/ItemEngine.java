package net.multiteam.mt_t_trains.items;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.multiteam.mt_t_trains.MTTTrains;
import net.multiteam.mt_t_trains.entity.EngineType;

import javax.annotation.Nullable;
import java.util.List;

public class ItemEngine extends ItemPart {

    private EngineType type;

    public ItemEngine(EngineType type) {
        super(type.getRegistryName());
        this.type = type;
        setCreativeTab(MTTTrains.ITEMS_CREATIVE_TAB);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(type.getTierColor() + TextFormatting.BOLD.toString() + type.getTierName() + " Tier");
        if (GuiScreen.isShiftKeyDown()) {
            tooltip.add(TextFormatting.YELLOW + "Fuel Consumption: " + TextFormatting.RESET + type.getFuelConsumption() + "pt");
        } else {
            tooltip.add(TextFormatting.YELLOW + "Hold SHIFT for Stats");
        }
    }

}
