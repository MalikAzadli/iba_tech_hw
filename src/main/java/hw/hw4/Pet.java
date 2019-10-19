package hw.hw4;

public class Pet {
    //class variables
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet() {

    }

    public void eat(){
        System.out.println("I am eating");
    }

    public void respond(){
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", nickname);
    }

    public void foul(){
        System.out.println("I need to cover it up");
    }

    public String getNickname() {
        return nickname;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }
}
