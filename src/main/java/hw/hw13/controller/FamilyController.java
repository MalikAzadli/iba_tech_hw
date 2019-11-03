package hw.hw13.controller;

import hw.hw13.dao.FamilyService;
import hw.hw13.exception.FamilyOverflowException;
import hw.hw13.human.Family;
import hw.hw13.human.Human;
import hw.hw13.pet.Pet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class FamilyController {

    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public void getAllFamiliesBiggerThan(int index) {
        familyService.getAllFamiliesBiggerThan(index);
    }

    public void getAllFamiliesLessThan(int index) {
        familyService.getAllFamiliesLessThan(index);
    }

    public int countFamiliesWithMemberNumber(int number) {
        return familyService.countFamiliesWithMemberNumber(number);
    }

    public void createNewFamily(Human father, Human mother) {
        familyService.createNewFamily(father, mother);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public void bornChild(Family family, String boyName, String girlName) throws FamilyOverflowException {
        if (family.countFamily() >= 5) {
            throw new FamilyOverflowException("More than 5 members will not be allowed");
        }
        familyService.bornChild(family, boyName, girlName);
    }

    public Family adoptChild(Family family, Human human) {
        if (family.countFamily() >= 5) {
            throw new FamilyOverflowException("More than 5 members is not be allowed");
        }
        return familyService.adoptChild(family, human);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int index) throws IndexOutOfBoundsException {
        return familyService.getFamilyById(index);
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }

    public void loadData() throws IOException, ClassNotFoundException {
        familyService.loadData();
    }

    public void saveData() throws IOException {
        familyService.saveData();
    }
}
