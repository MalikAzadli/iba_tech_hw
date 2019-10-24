package hw.hw7;

public class Dog extends Pet implements HasFouls{

    public Dog(Species species, String nickname, int age, int trickLevel, String[] habits) {
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

    }

    @Override
    public void foul() {

    }
}
