package hw.hw4;

import javax.crypto.spec.PSource;
import java.util.Arrays;

public class Human {
    //class variables
    private String name;
    private String surname;
    private int year;
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int year, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public Human(){

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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        String s = String.format("Human{name='%s', surname='%s', year=%d, iq=90, mother=%s,"+
                " father=%s, pet=dog{nickname='%s', age=%d, trickLevel=%d, habits=%s}}",
                name, surname, year, (mother.getName()+" "+mother.getSurname()),
                (father.getName()+" "+father.getSurname()), pet.getNickname(),
                pet.getAge(), pet.getTrickLevel(), Arrays.toString(pet.getHabits()));

        return s;
    }
}
