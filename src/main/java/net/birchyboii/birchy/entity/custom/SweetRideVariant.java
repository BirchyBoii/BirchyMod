package net.birchyboii.birchy.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum SweetRideVariant {
    DEFAULT(0),
    GOLDEN(1);

    private static final SweetRideVariant[] BY_ID =
            Arrays.stream(values()).sorted(Comparator.comparingInt(SweetRideVariant::getId)).toArray(SweetRideVariant[]::new);
    private final int id;

    SweetRideVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SweetRideVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
