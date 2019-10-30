package hw.hw10;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pet {
    //class variables
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits = new HashSet<>();

    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet() {

    }

    public void eat() {
        System.out.println("I am eating");
    }

    public abstract void respond();

    public String getNickname() {
        return nickname;
    }

    public Species getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                trickLevel == pet.trickLevel &&
                species.equals(pet.species) &&
                nickname.equals(pet.nickname) &&
                habits.equals(pet.habits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, age, trickLevel);
        result = 31 * result + habits.hashCode();
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("This Pet object is going to be removed by Garbage Collector.");
    }

    @Override
    public String toString() {
        return String.format("{My name is %s, I am a %s}", nickname, species);
    }
}
