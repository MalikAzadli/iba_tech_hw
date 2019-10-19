package hw.hw5;

import java.util.ArrayList;

public class Family {

    private final Human mother;
    private final Human father;
    private Pet pet;
    private ArrayList<Human> children;

    public Family(Human father, Human mother){
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Pet getPet() {
        return pet;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    public void addChild(Human child){
        this.children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(Human child){
        int index = children.indexOf(child);
        Human human = children.remove(index);
        if(children.indexOf(index) == -1) {
            human.setFamily(null);
            return true;
        }
        return false;
    }

    public int countFamily(){
        return children.size() + 2;
    }

    @Override
    public boolean equals(Object that) {
        if(this == null) return false;
        if(this == that) return true;
        if(!(that instanceof Family)) return false;

        Family family = (Family) that;
        if(this.mother.equals(family.mother) && this.father.equals(family.father)) return true;
        return false;
    }

    @Override
    public String toString() {
        String s = String.format("Family{father=%s, mother=%s, children=%s",
                father.getFullName(), mother.getFullName(), children);
        return s;
    }
}
