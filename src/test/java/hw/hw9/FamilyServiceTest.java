package hw.hw9;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class FamilyServiceTest {

    private FamilyService familyService;

    @Before
    public void before() {
        this.familyService = new FamilyService(new CollectionFamilyDao());
    }

    @Test
    public void getAllFamilies() {
        Human james = new Man("James", "Maud", 1960, null);
        Human natalia = new Woman("Natalia", "Maud", 1970, null);
        familyService.createNewFamily(james, natalia);
        List<Family> families = new ArrayList<>();
        families.add(new Family(james, natalia));

        assertEquals(families, familyService.getAllFamilies());
    }

    @Test
    public void countFamiliesWithMemberNumber() {
        Human james = new Man("James", "Maud", 1960, null);
        Human natalia = new Woman("Natalia", "Maud", 1970, null);

        Human mark = new Man("Mar", "Doyle", 1965, null);
        Human bella = new Woman("Bella", "Doyle", 1974, null);

        familyService.createNewFamily(james, natalia);
        familyService.createNewFamily(mark, bella);
        familyService.bornChild(familyService.getFamilyById(0), "Mike", "Janie");
        familyService.bornChild(familyService.getFamilyById(0), "Daniel", "Lea");
        familyService.bornChild(familyService.getFamilyById(1), "Michael", "Adele");
        familyService.bornChild(familyService.getFamilyById(1), "Peter", "Michel");
        familyService.bornChild(familyService.getFamilyById(1), "Adrey", "Susanna");

        assertEquals(1, familyService.countFamiliesWithMemberNumber(5));

    }

    @Test
    public void deleteFamilyByIndex() {
        Human mark = new Man("Mar", "Doyle", 1965, null);
        Human bella = new Woman("Bella", "Doyle", 1974, null);
        familyService.createNewFamily(mark, bella);
        assertTrue(familyService.deleteFamilyByIndex(0));
    }

    @Test
    public void bornChild() {
        Human mark = new Man("Mar", "Doyle", 1965, null);
        Human bella = new Woman("Bella", "Doyle", 1974, null);

        familyService.createNewFamily(mark, bella);
        int familySize = familyService.getFamilyById(0).countFamily();
        familyService.bornChild(familyService.getFamilyById(0), "Jane", "Lewis");

        assertEquals(familySize+1, familyService.getFamilyById(0).countFamily());
    }

    @Test
    public void adoptChild() {
        Human mark = new Man("Mar", "Doyle", 1965, null);
        Human bella = new Woman("Bella", "Doyle", 1974, null);
        Family family = new Family(mark, bella);
        familyService.createNewFamily(mark, bella);
        Human adopted = new Human("Mike", "Ric", 1996, null);
        family.addChild(adopted);

        familyService.adoptChild(familyService.getFamilyById(0), adopted);

        assertEquals(family, familyService.getFamilyById(0));
    }

    @Test
    public void count() {
        Human james = new Man("James", "Maud", 1960, null);
        Human natalia = new Woman("Natalia", "Maud", 1970, null);

        Human mark = new Man("Mar", "Doyle", 1965, null);
        Human bella = new Woman("Bella", "Doyle", 1974, null);

        familyService.createNewFamily(james, natalia);
        familyService.createNewFamily(mark, bella);

        assertEquals(2, familyService.count());
    }

    @Test
    public void getFamilyById() {
        Human james = new Man("James", "Maud", 1960, null);
        Human natalia = new Woman("Natalia", "Maud", 1970, null);

        Human mark = new Man("Mar", "Doyle", 1965, null);
        Human bella = new Woman("Bella", "Doyle", 1974, null);
        List<Family> families = new ArrayList<>();
        families.add(new Family(mark,bella));
        families.add(new Family(james,natalia));
        familyService.createNewFamily(mark,bella);
        familyService.createNewFamily(james,natalia);

        assertEquals(families.get(0), familyService.getFamilyById(0));
    }

    @Test
    public void getPets() {
        Human james = new Man("James", "Maud", 1960, null);
        Human natalia = new Woman("Natalia", "Maud", 1970, null);
        familyService.createNewFamily(james,natalia);
        familyService.addPet(0, new Dog(Species.DOG, "Mick"));
        familyService.addPet(0, new RoboCat(Species.ROBOCAT, "Pety"));
        familyService.addPet(0, new Fish(Species.FISH, "Fishy"));

        Set<Pet> pets = new LinkedHashSet<>();
        pets.add(new Dog(Species.DOG, "Mick"));
        pets.add(new RoboCat(Species.ROBOCAT, "Pety"));
        pets.add(new Fish(Species.FISH, "Fishy"));

        assertEquals(pets, familyService.getPets(0));
    }
}