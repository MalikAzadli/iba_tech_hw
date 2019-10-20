package hw.hw5;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    //class variables
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Family family;
    private String[][] schedule;

    public Human(String name, String surname, int year, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.family = family;
    }

    public Human(String name, String surname, int year, Pet pet, Family family, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.pet = pet;
        this.family = family;
        this.schedule = schedule;
    }

    public void greetPet(){
        System.out.println("Hello, " + pet.getNickname());
    }

    public void describePet(){
        String slyNess = pet.getAge() > 50 ? "very sly" : "almost not sly";
        System.out.printf("I have a %s, he is %d years old, he is %s\n", pet.getSpecies(), pet.getAge(), slyNess);
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

    public String getFullName() { return name+" "+surname; }

    public int getIq() {
        return iq;
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

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public void setFamily(Family family){
        //adding new family lead to leaving current family (being removed from its children object)
        //and being added to the children set of new family
        this.family.deleteChild(this);
        this.family = family;
        this.family.addChild(this);
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
        return Objects.hash(name, surname, family);
    }

    @Override
    public String toString() {
        String s = String.format("Human{name='%s', surname='%s', year=%d, iq=1, " +
                        "schedule=%s}", name, surname, year, Arrays.toString(schedule));

        return s;
    }


}
