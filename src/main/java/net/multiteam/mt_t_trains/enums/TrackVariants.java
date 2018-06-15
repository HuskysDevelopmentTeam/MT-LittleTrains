package net.multiteam.mt_t_trains.enums;

import net.minecraft.util.IStringSerializable;

public enum TrackVariants implements IStringSerializable {

    STRAIGHT("straight", 0),
    STRAIGHT_BALLASTED("straight_ballasted", 1),
    STRAIGHT_GRASS_PLATED("straight_grass_plated", 2),
    POWER("power", 3),
    POWER_BALLASTED("power_ballasted", 4),
    POWER_GRASS_PLATED("power_grass_plated", 5),
    BUFFER("buffer", 6),
    BUFFER_BALLASTED("buffer_ballasted", 7),
    BUFFER_GRASS_PLATED("buffer_grass_plated", 8),
    TURN_90_DEG("turn_90_deg", 9),
    TURN_90_DEG_BALLASTED("turn_90_deg_ballasted", 10),
    TURN_90_DEG_GRASS_PLATED("turn_90_deg_grass_plated", 11),
    X_CROSSING("x_crossing", 12),
    X_CROSSING_BALLASTED("x_crossing_ballasted", 13),
    X_CROSSING_GRASS_PLATED("x_crossing_grass_plated", 14);

    private String name;
    private int id;

    TrackVariants(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
