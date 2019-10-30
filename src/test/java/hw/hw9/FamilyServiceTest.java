package hw.hw9;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FamilyServiceTest {

    private FamilyService familyService;

    @Before
    public void before() {
        this.familyService = new FamilyService(new CollectionFamilyDao());
    }

    @Test
    public void getAllFamilies() {
    }

    @Test
    public void displayAllFamilies() {
    }

    @Test
    public void getAllFamiliesBiggerThan() {
    }

    @Test
    public void getAllFamiliesLessThan() {
    }

    @Test
    public void countFamiliesWithMemberNumber() {
    }

    @Test
    public void createNewFamily() {
    }

    @Test
    public void deleteFamilyByIndex() {
    }

    @Test
    public void bornChild() {
    }

    @Test
    public void adoptChild() {
    }

    @Test
    public void getFamilyById() {
    }

    @Test
    public void deleteAllChildrenOlderThan() {
    }

    @Test
    public void getPets() {
    }

    @Test
    public void addPet() {
    }
}