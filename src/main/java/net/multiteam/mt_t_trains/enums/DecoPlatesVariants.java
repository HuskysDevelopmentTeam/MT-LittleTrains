package net.multiteam.mt_t_trains.enums;

import net.minecraft.util.IStringSerializable;

public enum DecoPlatesVariants implements IStringSerializable {

    BALLAST("ballast_plate", 0, true),
    CONCRETE("concrete_plate", 1, true),
    CONCRETE_WATER_EDGE("concrete_water_edge", 2, true),
    CONCRETE_WATER_EDGE_CORNER("concrete_water_edge_corner", 3, true),
    GRASS_PLATE_CONCRETE_ROAD_CROSSING("grass_plate_concrete_road_crossing", 4, true),
    GRASS_PLATE_CONCRETE_ROAD_STRAIGHT("grass_plate_concrete_road_straight", 5, true),
    GRASS_PLATE_EMPTY("grass_plate_empty", 6, true),
    GRASS_PLATE_LAKE("grass_plate_lake", 7, true),
    GRASS_PLATE_WATER_EDGE("grass_plate_water_edge", 2, true),
    GRASS_PLATE_WATER_EDGE_CORNER("grass_plate_water_edge_corner", 3, true),
    GRASS_PLATE_MOUNTAIN("grass_plate_mountain", 8),
    GRASS_PLATE_MOUNTAIN_WALL("grass_plate_mountain_wall", 9),
    GRASS_PLATE_MOUNTAIN_WALL_CORNER("grass_plate_mountain_wall_corner", 10),
    GRASS_PLATE_MOUNTAIN_WALL_TUNNEL_START("grass_plate_mountain_wall_tunnel_start", 11),
    GRASS_PLATE_MOUNTAIN_WALL_TUNNEL_END("grass_plate_mountain_wall_tunnel_end", 12),
    GRASS_PLATE_MOUNTAIN_TUNNEL_STRAIGHT("grass_plate_mountain_tunnel_straight_track", 13),
    GRASS_PLATE_MOUNTAIN_TUNNEL_TURN_90_DEG("grass_plate_mountain_tunnel_turn_90_deg_track", 14),
    GRASS_PLATE_MOUNTAIN_TUNNEL_POWER("grass_plate_mountain_tunnel_power_track", 15),
    GRASS_PLATE_MOUNTAIN_TUNNEL_BUFFER("grass_plate_mountain_tunnel_buffer_track", 16),
    GRASS_PLATE_MOUNTAIN_TUNNEL_X_CROSSING("grass_plate_mountain_x_crossing_track", 17),
    GRASS_PLATE_MOUNTAIN_TUNNEL_RISING("grass_plate_mountain_tunnel_rising", 18),
    GRASS_PLATE_MOUNTAIN_TUNNEL_SINKING("grass_plate_mountain_tunnel_sinking", 19),
    WATER_BRIDGE("water_bridge", 18, true),
    WATER_BRIDGE_START_GRASS_PLATE("water_bridge_start_grass_plate", 19, true),
    WATER_PLATE("water_plate", 18, true);

    private String name;
    private int id;
    private boolean isPlate;

    DecoPlatesVariants(String name, int id, boolean isPlate) {
        this.name = name;
        this.id = id;
        this.isPlate = isPlate;
    }

    DecoPlatesVariants(String name, int id) {
        this.name = name;
        this.id = id;
        this.isPlate = false;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isPlate() {
        return isPlate;
    }

}
