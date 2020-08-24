package com.webapp.mensaapp.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Weekday {
    Monday(0),
    Tuesday(1),
    Wednesday(2),
    Thursday(3),
    Friday(4);


    private final int value;
    private static final Map map = new HashMap<>();

    Weekday(int value) {
        this.value = value;
    }

    static {
        for (Weekday weekday : Weekday.values()) {
            map.put(weekday.value, weekday);
        }
    }

    public static Weekday valueOf(int weekday) {
        return (Weekday) map.get(weekday);
    }

    public int getValue() {
        return value;
    }

}