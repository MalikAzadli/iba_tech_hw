package hw.hw13.dao;

import hw.hw13.human.Family;
import hw.hw13.human.Human;
import hw.hw13.human.Man;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    public Family getFamilyByIndex(int index) throws IndexOutOfBoundsException {
        if (!isValidFamily(index)) {
            return null;
        }
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (isValidFamily(index)) {
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
        if (!families.contains(family)) families.add(family);
    }

    @Override
    public void saveData() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("savedData.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(families);
        objectOutputStream.close();
        outputStream.close();
    }

    @Override
    public void loadData() throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream("savedData.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Human man = (Man) objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();
    }

    private boolean isValidFamily(int index) throws IndexOutOfBoundsException {
        try {
            families.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Invalid family index.");
        }
        return true;
    }
}
