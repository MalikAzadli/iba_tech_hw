package hw.hw4;

import java.util.Arrays;

public class Human {
    //class variables
    private String name;
    private String surname;
    private int year;
    private int iq;
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

    public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
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
        String slyness = pet.getAge() > 50
                                        ? "very sly"
                                        : "almost not sly";
        System.out.printf("I have a %s, he is %d years old, he is %s\n", pet.getSpecies(), pet.getAge(), slyness);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        String s = String.format("Human{name='%s', surname='%s', year=%d, iq=%d, mother=%s,"+
                " father=%s, pet=dog{nickname='%s', age=%d, trickLevel=%d, habits=%s}}",
                name, surname, year, iq, (mother.getName()+" "+mother.getSurname()),
                (father.getName()+" "+father.getSurname()), pet.getNickname(),
                pet.getAge(), pet.getTrickLevel(), Arrays.toString(pet.getHabits()));

        return s;
    }
}
