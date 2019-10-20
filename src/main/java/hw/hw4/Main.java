package hw.hw4;

import hw.hw5.Family;

public class Main {
    public static void main(String[] args) {

        Pet ginger = new Pet("cat", "Ginger");
        Pet bolt = new Pet("dog", "Bolt", 5, 34, new String[]{"dancing", "kissing"});
        Pet maxie = new Pet();

        //Bailey family
        Human george = new Human();
        george.setName("George");
        george.setSurname("Bailey");
        Human sarah = new Human("Sarah", "Bailey", 1912);
        Human zuzu = new Human("Zuzu", "Bailey", 1940, 85, bolt, sarah, george, new String[7][2]);


        //Allison family
        Human james = new Human("James", "Allison", 1986);
        Human rebecca = new Human();
        rebecca.setName("Rebecca");
        rebecca.setSurname("Allison");
        Human mark = new Human("Mark", "Allison", 2003, rebecca, james);
        Human lea = new Human("Lea", "Allison", 2005, 95, bolt, rebecca, james, new String[7][2]);

        lea.describePet();
        lea.greetPet();
        System.out.println(lea);
    }

}
