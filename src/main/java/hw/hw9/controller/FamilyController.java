package hw.hw9.controller;

import hw.hw9.dao.FamilyService;
import hw.hw9.human.Family;
import hw.hw9.human.Human;
import hw.hw9.pet.Pet;

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

    public void bornChild(Family family, String boyName, String girlName) {
        familyService.bornChild(family, boyName, girlName);
    }

    public Family adoptChild(Family family, Human human) {
        return familyService.adoptChild(family, human);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int index) {
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
}
