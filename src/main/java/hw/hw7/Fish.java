package hw.hw7;

public class Fish extends Pet {

    public Fish(Species species, String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(species);
    }

    public Fish(Species species, String nickname){
        super(nickname);
        this.setSpecies(species);
    }

    public Fish() {
    }

    @Override
    public void respond() {

    }
}
