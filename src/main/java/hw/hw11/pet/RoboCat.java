package hw.hw11.pet;


import java.util.Set;

public class RoboCat extends Pet implements Foulable {

    public RoboCat(Species species, String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(species);
    }

    public RoboCat(Species species, String nickname) {
        super(nickname);
        this.setSpecies(species);
    }

    public RoboCat() {
    }

    @Override
    public void respond() {
        System.out.println("I am robocat, " + this.getNickname() + ". I feel so tired, can you renew my oil?");
    }

    @Override
    public void foul() {
        System.out.println("I need to get refreshed. I need hot bath for an hour");
    }
}
