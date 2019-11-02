package hw.hw9.human;

import hw.hw9.pet.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Human {
    //class variables
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Family family;
    private Map<String, ArrayList<String>> schedule = new HashMap<>();

    public Human(String name, String surname, int year, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.family = family;
        if((family != null)) family.addChild(this);
    }

    public Human(String name, String surname, int year, Pet pet, Family family, Map<String, ArrayList<String>> schedule) {
        this(name, surname, year, family);
        this.pet = pet;
        this.schedule = schedule;
    }

    public void greetPet() {
        System.out.println("Hello, " + pet.getNickname());
    }

    public void describePet() {
        String slyness = pet.getAge() > 50 ? "very sly" : "almost not sly";
        System.out.printf("I have a %s, he is %d years old, he is %s\n", pet.getSpecies(), pet.getAge(), slyness);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYear() {
        return year;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public int getIq() {
        return iq;
    }

    public Pet getPet() {
        return pet;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setIq() {
        this.iq = iq;
    }

    public void setSchedule(Map<String, ArrayList<String>> schedule) {
        this.schedule = schedule;
    }

    public void setFamily(Family family) {
        //adding new family lead to leaving current family (being removed from its children object)
        //and being added to the children set of new family

        if(family.equals(this.family)) return;
        if (this.family != null) this.family.deleteChild(this);
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return name.equals(human.name) &&
                surname.equals(human.surname) &&
                Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year);
    }

    @Override
    public String toString() {
        String s = String.format("Human{name='%s', surname='%s', year=%d, iq=1, " +
                "schedule=%s}", name, surname, year, schedule.toString());

        return s;
    }

    protected void finalize() throws Throwable {
        System.out.println("This Human object is going to be removed by Garbage Collector.");
    }
}
