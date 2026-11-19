package utility.generator;

import java.util.ArrayList;
import java.util.Random;

abstract class Generator {
    static ArrayList<String> generated = new ArrayList<>();
    static Random rand = new Random();

    public static void addToGenerated(String value) {
        generated.add(value);
    }

    public static boolean isAlreadyExist(String value) {
        if (generated.contains(value)) return true;
        return false;
    }
}
