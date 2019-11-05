package hw.hw12.dao;

import hw.hw12.exception.FamilyOverflowException;
import hw.hw12.human.Family;
import hw.hw12.human.Human;
import hw.hw12.human.Man;
import hw.hw12.human.Woman;
import hw.hw12.pet.Pet;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
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
        families.forEach(family -> System.out.printf("%d. %s\n", families.indexOf(family) + 1, family.prettyFormat()));
    }

    public void getAllFamiliesBiggerThan(int index) {
        Stream<Family> familyStream = getAllFamilies().stream();
        familyStream
                .filter(family -> family.countFamily() > index)
                .forEach(family -> System.out.printf("%s\n", family.prettyFormat()));
    }

    public void getAllFamiliesLessThan(int index) {
        Stream<Family> familyStream = getAllFamilies().stream();
        familyStream
                .filter(family -> family.countFamily() < index)
                .forEach(family -> System.out.printf("%s\n", family.prettyFormat()));
    }

    public int countFamiliesWithMemberNumber(int memberCount) {
        List<Family> families = familyDao.getAllFamilies();
        families = families.stream()
                .filter(family -> family.countFamily() == memberCount)
                .collect(Collectors.toList());
        System.out.printf("%d family with %d members.\n", families.size(), memberCount);
        return families.size();
    }

    public void createNewFamily(Human father, Human mother) {
        familyDao.saveFamily(new Family(father, mother));
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(familyDao.getFamilyByIndex(index));
    }

    public Family bornChild(Family family, String boyName, String girlName) throws FamilyOverflowException {
        if (!familyDao.getAllFamilies().contains(family)) return family;
        Random rand = new Random();
        String surname = family.getFather().getSurname();
        LocalDate birthDate = LocalDate.now();
        Human child;
        if (rand.nextBoolean()) child = new Man(boyName, surname, birthDate.toEpochDay(), family);
        else child = new Woman(girlName, surname, birthDate.toEpochDay(), family);
        try {
            family.addChild(child);
        } catch (FamilyOverflowException e) {
            throw e;
        }
        return family;
    }

    public Family adoptChild(Family family, Human human) throws FamilyOverflowException {
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

    public Family getFamilyById(int index) throws IndexOutOfBoundsException {
        return familyDao.getFamilyByIndex(index);
    }

    public void deleteAllChildrenOlderThan(int age) {
        LocalDate year = LocalDate.now();

        getAllFamilies().forEach(family -> {
            Iterator<Human> humanIterator = family.getChildren().iterator();
            ArrayList<Human> youngerChildren = new ArrayList<>();
            while (humanIterator.hasNext()) {
                Human human = humanIterator.next();
                if (Period.between(LocalDate.ofEpochDay(human.getYear()), year).getYears() < age)
                    youngerChildren.add(human);
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
