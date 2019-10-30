package hw.hw10;

import java.util.Set;

public class Fish extends Pet {

    public Fish(Species species, String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(species);
    }

    public Fish(Species species, String nickname) {
        super(nickname);
        this.setSpecies(species);
    }

    public Fish() {
    }

    @Override
    public void respond() {

    }
}
