package hw.hw12;

import java.util.ArrayList;
import java.util.Map;

public final class Man extends Human {
    public Man(String name, String surname, long year, Family family) {
        super(name, surname, year, family);
    }

    public Man(String name, String surname, long year, Pet pet, Family family, Map<String, ArrayList<String>> schedule) {
        super(name, surname, year, pet, family, schedule);
    }

    public Man(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    @Override
    public void greetPet() {
        System.out.println("Hello, " + this.getPet().getNickname());
    }

    public void repairCar() {
        System.out.println("I am bored. I am gonna repair that antique car.");
    }
}
