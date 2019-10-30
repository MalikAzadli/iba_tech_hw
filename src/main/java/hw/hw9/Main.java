package hw.hw9;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(familyDao);
        FamilyController controller = new FamilyController(service);

        //manually created families
        Human jamesMaud = new Man("James", "Maud", 1960, null);
        Human nataliaMaud = new Woman("Natalia", "Maud", 1970, null);
        Family maud = new Family(jamesMaud, nataliaMaud);
        Human markMaud = new Man("Mark", "Maud", 2007, maud);
        Human janeMaud = new Woman("Jane", "Maud", 1993, maud);

        Human markKane = new Man("Mark", "Kane", 1965, null);
        Human juliaKane = new Woman("Julia", "Kane", 1972, null);
        Family kane = new Family(markKane, juliaKane);

        familyDao.saveFamily(maud);
        familyDao.saveFamily(kane);

        //Create new Family
        Human jakeMiles = new Man("Jake", "Miles", 1945, null);
        Human barbaraMiles = new Man("Barbara", "Miles", 1951, null);
        controller.createNewFamily(jakeMiles, barbaraMiles);

        //addPet and getPets
        controller.addPet(1, new Dog(Species.DOG, "Balto"));
        controller.addPet(1, new Dog(Species.DOG, "Mike"));
        Set<Pet> kanePet = controller.getPets(1);
        System.out.println("Pets of The Kanes': " + kanePet.toString());

        //count
        int familyCount = controller.count();
        System.out.printf("There are %d families.\n", familyCount);

        //adoptChild
        controller.adoptChild(kane, new Man("Michael", "Bailey", 2005, null));

        //getAllFamilies
        System.out.println("Get all families:");
        controller.getAllFamilies().forEach(family -> System.out.println(family.toString()));

        //displayAllFamilies
        System.out.println("Display all families:");
        controller.displayAllFamilies();

        //families bigger than AND families less than
        System.out.println("All families bigger than 2:");
        controller.getAllFamiliesBiggerThan(2);
        System.out.println("All families less than 4:");
        controller.getAllFamiliesLessThan(4);

        //get family by id AND delete family by id
        Family family = controller.getFamilyById(1);
        System.out.println("Family at index 1 will be deleted: " + family.toString());
        controller.deleteFamilyByIndex(1);
        controller.displayAllFamilies();

        //delete all children older than
        controller.deleteAllChildrenOlderThan(15);
        System.out.println("After deleting older children");

        controller.displayAllFamilies();


    }
}
