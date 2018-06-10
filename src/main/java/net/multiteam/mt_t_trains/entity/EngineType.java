package net.multiteam.mt_t_trains.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public enum EngineType {

    ELECTRIC(0, 0F, "Simple Electric", "simple_electric_engine", TextFormatting.DARK_GRAY),
    DIESEL(1, 0F, "Electric Diesel", "electric_diesel_engine", TextFormatting.GRAY),
    STEAM(2, 0F, "Electric Steam", "electric_steam_boiler", TextFormatting.WHITE);

    int id;
    float fuelConsumption;

    String tierName, registryName;
    TextFormatting tierColor;

    EngineType(int id, float fuelConsumption, String tierName, String registryName, TextFormatting tierColor) {
        this.id = id;
        this.fuelConsumption = fuelConsumption;
        this.tierName = tierName;
        this.registryName = registryName;
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

    public String getRegistryName() {
        return registryName;
    }

    public int getId() {
        return id;
    }

    public TextFormatting getTierColor() {
        return tierColor;
    }
}
