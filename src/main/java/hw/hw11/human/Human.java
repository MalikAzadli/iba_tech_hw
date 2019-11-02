package hw.hw11.human;

import hw.hw11.pet.Pet;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Human {
    //class variables
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Pet pet;
    private Family family;
    private Map<String, ArrayList<String>> schedule = new HashMap<>();

    public Human(String name, String surname, long birthDate, Family family) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.family = family;
        if((family != null)) family.addChild(this);
    }

    public Human(String name, String surname, long year, Pet pet, Family family, Map<String, ArrayList<String>> schedule) {
        this(name, surname, year, family);
        this.pet = pet;
        this.schedule = schedule;
    }

    public Human(String name, String surname, String birthDate, int iq){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.birthDate = LocalDate.parse(birthDate, formatter).toEpochDay();
        this.iq = iq;
        this.name = name;
        this.surname = surname;
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

    public long getYear() {
        return birthDate;
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

    public void setYear(long birthDate) {
        this.birthDate = birthDate;
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

    public String describeAge(){
        LocalDate date = LocalDate.ofEpochDay(birthDate);
        LocalDate localDate = LocalDate.now();
        Period period = Period.between(date, localDate);
        return String.format("%d years, %d months, %d days old",
                period.getYears(),
                period.getMonths(),
                period.getDays());
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
        return Objects.hash(name, surname, birthDate);
    }

    @Override
    public String toString() {
        String s = String.format("Human{name='%s', surname='%s', birth date=%s, iq=1, schedule=%s}",
                name,
                surname,
                LocalDate.ofEpochDay(birthDate).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString(),
                schedule.toString());

        return s;
    }

    protected void finalize() throws Throwable {
        System.out.println("This Human object is going to be removed by Garbage Collector.");
    }
}
