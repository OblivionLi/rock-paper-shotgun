package rockpaperscissors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public enum Gesture {
    ROCK,
    FIRE,
    SCISSORS,
    SNAKE,
    HUMAN,
    TREE,
    WOLF,
    SPONGE,
    PAPER,
    AIR,
    WATER,
    DRAGON,
    DEVIL,
    LIGHTNING,
    GUN;

    public static List<Integer> getOrdinals(Set<String> gestures) {
        List<Integer> ordinals = new ArrayList<>();
        for (String gesture : gestures) {
            int gestureOrdinal = Gesture.getOrdinal(gesture);
            if (gestureOrdinal == -1) {
                System.out.println("Skipping gesture because couldn't find ordinal for it: " + gesture);
                continue;
            }
            ordinals.add(gestureOrdinal);
        }

        Collections.sort(ordinals);
        return ordinals;
    }

    public static List<Integer> getOrdinals() {
        List<Integer> ordinals = new ArrayList<>();
        for (Gesture gesture : Gesture.values()) {
            ordinals.add(gesture.ordinal());
        }
        return ordinals;
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Gesture gesture : Gesture.values()) {
            names.add(gesture.name());
        }

        return names;
    }

    public static boolean containsValue(String gesture) {
        for (Gesture g : Gesture.values()) {
            if (g.name().equalsIgnoreCase(gesture)) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsValue(Set<String> values) {
        for (String value : values) {
            boolean valueExists = false;
            for (Gesture gesture : Gesture.values()) {
                if (gesture.name().equals(value)) {
                    valueExists = true;
                    break;
                }
            }

            if (!valueExists) {
                return false;
            }
        }
        return true;
    }

    public static int getOrdinal(String value) {
        try {
            Gesture enumValue = Gesture.valueOf(value);
            return enumValue.ordinal();
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }
}
