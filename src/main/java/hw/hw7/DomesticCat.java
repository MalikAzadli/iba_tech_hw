package hw.hw7;

public class DomesticCat extends Pet implements Foulable {

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
        System.out.println("Hi, dear. I am " + this.getNickname()+ ". Nice to meet you. Where have you been???");
    }

    @Override
    public void foul() {
        System.out.println("I need one big juicy meat. Then i think i can get well.");
    }
}
