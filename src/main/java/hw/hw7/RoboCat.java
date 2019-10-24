package hw.hw7;

public class RoboCat extends Pet implements HasFouls{

    public RoboCat(Species species, String nickname, int age, int trickLevel, String[] habits) {
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

    }

    @Override
    public void foul() {

    }
}
