package hw.hw7;

import java.util.ArrayList;

public class Family {

    private Human mother;
    private Human father;
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

    public Family setMother(Human mother) {
        this.mother = mother;
        return new Family(this.mother, this.father);
    }

    public Family setFather(Human father) {
        this.father = father;
        return new Family(this.mother, this.father);
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

    public boolean deleteChild(Human child) {
        if(children.indexOf(child) == -1) {
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
        String childrenInfo = "";
        for(Human child: children){
            String.format("%s\n%s", childrenInfo, child.toString());
        }
        String s = String.format("Family{father=%s, mother=%s, children=%s",
                father.getFullName(), mother.getFullName(), childrenInfo.trim());
        return s;
    }

    protected void finalize() throws Throwable {
        System.out.println("This Family object is going to be removed by Garbage Collector.");
    }
}
