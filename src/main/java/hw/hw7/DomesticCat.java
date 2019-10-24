package hw.hw7;

public class DomesticCat extends Pet implements HasFouls {

    public DomesticCat(Species species, String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(species);
    }

    public DomesticCat(Species species, String nickname) {
        super(nickname);
        this.setSpecies(species);
    }

    public DomesticCat() {
    }

    @Override
    public void respond() {

    }

    @Override
    public void foul() {

    }
}
