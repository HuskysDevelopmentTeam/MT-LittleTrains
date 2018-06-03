package net.multiteam.mt_t_trains.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public enum EngineType {

    ELECTRIC(0F, "Electric", TextFormatting.DARK_GRAY),
    DIESEL(0F, "Diesel", TextFormatting.GRAY);

    float fuelConsumption;

    String tierName;
    TextFormatting tierColor;

    EngineType(float fuelConsumption, String tierName, TextFormatting tierColor) {
        this.fuelConsumption = fuelConsumption;
        this.tierName = tierName;
        this.tierColor = tierColor;
    }

    public static EngineType getType(ItemStack stack) {
        return getType(stack.getItemDamage());
    }

    public static EngineType getType(int index) {
        if (index < 0 || index >= values().length) {
            return DIESEL;
        }
        return EngineType.values()[index];
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public String getTierName() {
        return tierName;
    }

    public TextFormatting getTierColor() {
        return tierColor;
    }
}
