package hw.hw6;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class FamilyTest {

    private Family family;

    @Before
    public void before(){
        Human father = new Human("Jake", "Seydoux", 1965, null);
        Human mother = new Human("Lea", "Seydoux", 1972, null);
        family = new Family(father, mother);
    }

    @Test
    public void addChild1() {
        Human person = new Human("Daniel", "Lewis", 1985, null);
        int childrenCount = family.getChildren().size();
        family.addChild(person);
        childrenCount+=1;
        assertEquals(childrenCount, family.getChildren().size());
    }

    @Test
    public void addChild2() {
        Human person = new Human("Jane", "Paterson", 1988, null);
        family.addChild(person);
        ArrayList<Human> children = family.getChildren();
        assertEquals(children.get(children.size()-1), person);
    }

    @Test
    public void deleteChild1() {
        Human person = new Human("Daniel", "Lewis", 1985, null);
        family.addChild(person);
        assertTrue(family.deleteChild(person));
    }

    @Test
    public void deleteChild2() {
        Human person = new Human("Jacob", "Blake", 1990, null);
        int childrenCount = family.getChildren().size();
        family.deleteChild(person);
        assertEquals(childrenCount, family.getChildren().size());
    }

    @Test
    public void testDeleteChild1() {
        Human person = new Human("Suzan", "Blake", 1997, null);
        family.addChild(person);
        int index = family.getChildren().indexOf(person);
        int childrenCount = family.getChildren().size();
        Human deletedPerson = family.deleteChild(index);
        assertEquals(family.getChildren().indexOf(person),-1);
        assertEquals(person, deletedPerson);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testDeleteChild2() throws IndexOutOfBoundsException {
        int childrenCount = family.getChildren().size();
        family.deleteChild(childrenCount + 5);
    }

    @Test
    public void countFamily() {
        Random rand = new Random();
        int length = rand.nextInt(10);
        for(int i = 0; i < length; i++){
            Human person = new Human("James", "Caan", 1959, null);
            family.addChild(person);
        }
        int familyLength = length + 2;
        assertEquals(familyLength, family.countFamily());
    }

    @Test
    public void testToString() {
        Human person1 = new Human("Ingmar", "Bergman", 1918, null);
        Human person2 = new Human("Andrey", "Tarkovsky", 1932, null);
        assertNotEquals(person1.toString(), person2.toString());
    }
}