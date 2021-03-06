package hw.hw9.dao;

import hw.hw9.human.Family;
import hw.hw9.human.Human;
import hw.hw9.human.Man;
import hw.hw9.human.Woman;
import hw.hw9.pet.Pet;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class FamilyService {

    private FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = getAllFamilies();
        for (int i = 0; i < families.size(); i++) {
            System.out.println((i + 1) + ": " + families.get(i).toString());
        }
    }

    public void getAllFamiliesBiggerThan(int index) {
        Stream<Family> familyStream = getAllFamilies().stream();
        familyStream
                .filter(family -> family.countFamily() > index)
                .forEach(family -> System.out.printf("%s\n", family.toString()));
    }

    public void getAllFamiliesLessThan(int index) {
        Stream<Family> familyStream = getAllFamilies().stream();
        familyStream
                .filter(family -> family.countFamily() < index)
                .forEach(family -> System.out.printf("%s\n", family.toString()));
    }

    public int countFamiliesWithMemberNumber(int memberCount) {
        int counter = 0;
        List<Family> families = familyDao.getAllFamilies();
        for (Family family : families) {
            if (family.countFamily() == memberCount) counter++;
        }
        return counter;
    }

    public void createNewFamily(Human father, Human mother) {
        familyDao.saveFamily(new Family(father, mother));
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(familyDao.getFamilyByIndex(index));
    }

    public Family bornChild(Family family, String boyName, String girlName) {
        Random rand = new Random();
        if (!familyDao.getAllFamilies().contains(family)) familyDao.saveFamily(family);
        String surname = family.getFather().getSurname();
        int year = LocalDate.now().getYear();
        Human child;
        if (rand.nextBoolean()) child = new Man(boyName, surname, year, family);
        else child = new Woman(girlName, surname, year, family);

        family.addChild(child);
        return family;
    }

    public Family adoptChild(Family family, Human human) {
        if (getAllFamilies().contains(family)) {
            family.addChild(human);
        } else {
            family.addChild(human);
            familyDao.saveFamily(family);
        }
        return family;
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public void deleteAllChildrenOlderThan(int age) {
        int year = LocalDate.now().getYear();

        getAllFamilies().forEach(family -> {
            Iterator<Human> humanIterator = family.getChildren().iterator();
            ArrayList<Human> youngerChildren = new ArrayList<>();
            while (humanIterator.hasNext()) {
                Human human = humanIterator.next();
                if (year - human.getYear() < age) youngerChildren.add(human);
            }
            family.setChildren(youngerChildren);
        });
    }

    public Set<Pet> getPets(int index) {
        return getFamilyById(index).getPet();
    }

    public void addPet(int index, Pet pet) {
        getFamilyById(index).addPet(pet);
    }
}
