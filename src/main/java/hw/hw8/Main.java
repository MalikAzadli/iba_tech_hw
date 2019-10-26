package hw.hw8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> schedule = new HashMap<>();
        Human man = new Man("j", "b", 1975, new Dog(), null, schedule);
        Pet roboCat = new RoboCat(Species.ROBOCAT, "Janie");
        RoboCat cat = new RoboCat(Species.ROBOCAT, "maxie");
        Man max = new Man("M", "S", 1234, null);

    }
}
