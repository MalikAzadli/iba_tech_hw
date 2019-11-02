package hw.hw11;

import hw.hw11.controller.FamilyController;
import hw.hw11.dao.CollectionFamilyDao;
import hw.hw11.dao.FamilyDao;
import hw.hw11.dao.FamilyService;
import hw.hw11.human.Family;
import hw.hw11.human.Human;
import hw.hw11.human.Man;
import hw.hw11.human.Woman;
import hw.hw11.pet.Dog;
import hw.hw11.pet.Pet;
import hw.hw11.pet.Species;

import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(familyDao);
        FamilyController controller = new FamilyController(service);

        //manually created families
        Human jamesMaud = new Man("James", "Maud", LocalDate.of(1960, 10, 28).toEpochDay(), null);
        Human nataliaMaud = new Woman("Natalia", "Maud", LocalDate.of(1970, 10, 28).toEpochDay(), null);

        Human markKane = new Man("Mark", "Kane", LocalDate.of(1965, 10, 28).toEpochDay(), null);
        Human juliaKane = new Woman("Julia", "Kane", LocalDate.of(1972,10,28).toEpochDay(), null);

        controller.createNewFamily(jamesMaud, nataliaMaud);
        controller.createNewFamily(markKane, juliaKane);

        Family maud = controller.getFamilyById(0);
        Family kane = controller.getFamilyById(1);

        Human markMaud = new Man("Mark", "Maud", LocalDate.of(2007,10,28).toEpochDay(), maud);
        Human janeMaud = new Woman("Jane", "Maud", LocalDate.of(1993,10,28).toEpochDay(), maud);
        //Create new Family
        Human jakeMiles = new Man("Jake", "Miles", LocalDate.of(1945,10,28).toEpochDay(), null);
        Human barbaraMiles = new Man("Barbara", "Miles", LocalDate.of(1951,10,28).toEpochDay(), null);
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

        //delete all children older than
        controller.deleteAllChildrenOlderThan(15);
        System.out.println("After deleting older children");
        controller.displayAllFamilies();

        //born child
        System.out.println("One new member was born");
        controller.bornChild(controller.getFamilyById(1), "James", "Lea");
        controller.displayAllFamilies();

        //family with specific number of members
        int count = controller.countFamiliesWithMemberNumber(3);
        System.out.printf("There are %d families with 3 members\n", count);

        //get family by id AND delete family by id
        Family family = controller.getFamilyById(1);
        System.out.println("Family at index 1 will be deleted: " + family.toString());
        controller.deleteFamilyByIndex(1);
        controller.displayAllFamilies();

    }
}
