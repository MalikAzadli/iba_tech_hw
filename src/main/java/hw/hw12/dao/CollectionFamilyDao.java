package hw.hw12.dao;

import hw.hw12.human.Family;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionFamilyDao implements FamilyDao {

    private List<Family> families;

    public CollectionFamilyDao() {
        this.families = new ArrayList<>();
    }

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) throws IndexOutOfBoundsException{
        if(!isValidFamily(index)){
            return null;
        }
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if(isValidFamily(index)){
         return families.remove(index) != null;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        if(!families.contains(family)) families.add(family);
    }

    private boolean isValidFamily(int index) throws IndexOutOfBoundsException{
        try{
            families.get(index);
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Invalid family index.");
        }
        return true;
    }
}
