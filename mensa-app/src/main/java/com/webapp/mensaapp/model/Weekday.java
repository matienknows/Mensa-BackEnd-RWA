package com.webapp.mensaapp.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Weekday {
    Monday(1),
    Tuesday(2),
    Wednesday(3),
    Thursday(4),
    Friday(5);

    private int i;
    private static Map map = new HashMap<>();

    Weekday(int i) {
        this.i = i;
    }

    static {
        for (Weekday weekday : Weekday.values()) {
            map.put(weekday.i, weekday);
        }
    }

    public static Weekday valueOf(int weekday) {
        return (Weekday) map.get(weekday);
    }

    public int getValue() {
        return i;
    }


}