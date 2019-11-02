package hw.hw9.human;

import hw.hw9.pet.Pet;

import java.util.*;

public class Family {

    private Human mother;
    private Human father;
    private Set<Pet> pet;
    private List<Human> children;

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
        this.pet = new LinkedHashSet<>();
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Family setMother(Human mother) {
        this.mother = mother;
        return new Family(this.mother, this.father);
    }

    public Family setFather(Human father) {
        this.father = father;
        return new Family(this.mother, this.father);
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }

    public void addPet(Pet pet) {
        this.pet.add(pet);
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    public void addChild(Human child) {
        if(children.contains(child)) return;
        this.children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(Human child) {
        if (children.indexOf(child) == -1) {
            return false;
        }
        int index = children.indexOf(child);
        Human human = children.remove(index);
        return true;
    }

    public Human deleteChild(int index) throws IndexOutOfBoundsException {
        Human child = children.remove(index);
        return child;
    }

    public int countFamily() {
        return children.size() + 2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children);
    }

    @Override
    public boolean equals(Object that) {
        if (this == null) return false;
        if (this == that) return true;
        if (!(that instanceof Family)) return false;

        Family family = (Family) that;
        if (this.mother.equals(family.mother) && this.father.equals(family.father)) return true;
        return false;
    }

    @Override
    public String toString() {
        String childrenInfo = "";
        for (Human child : children) {
            childrenInfo+=String.format("%s\n", child.toString());
        }
        String s = String.format("Family{father=%s, mother=%s, children=%s}",
                father.getFullName(), mother.getFullName(), childrenInfo.trim());
        return s;
    }

    protected void finalize() throws Throwable {
        System.out.println("This Family object is going to be removed by Garbage Collector.");
    }
}
