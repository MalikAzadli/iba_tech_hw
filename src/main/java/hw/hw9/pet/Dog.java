package hw.hw9.pet;

import java.util.Random;
import java.util.Set;

public class Dog extends Pet implements Foulable {
    private Random rand = new Random();

    public Dog(Species species, String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(species);
    }

    public Dog(Species species, String nickname) {
        super(nickname);
        this.setSpecies(species);
    }

    public Dog() {
    }

    @Override
    public void respond() {
        System.out.println("I am, " + this.getNickname() + ". Who are you?");
    }

    @Override
    public void foul() {
        System.out.println("Hi, i am RoboDog, " + rand.nextInt(245));
    }
}
