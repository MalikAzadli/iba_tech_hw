package hw.hw11;

import java.util.ArrayList;
import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surname, long year, Family family) {
        super(name, surname, year, family);
    }

    public Woman(String name, String surname, long year, Pet pet, Family family, Map<String, ArrayList<String>> schedule) {
        super(name, surname, year, pet, family, schedule);
    }

    public Woman(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    @Override
    public void greetPet() {
        System.out.println("Hello, my little " + this.getPet().getNickname());
    }

    public void makeup() {
        System.out.println("I need to do some magic on me.");
    }
}
