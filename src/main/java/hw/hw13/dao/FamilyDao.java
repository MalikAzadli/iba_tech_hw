package hw.hw13.dao;

import hw.hw13.human.Family;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
    void saveData() throws IOException;
    void loadData() throws IOException, ClassNotFoundException;
}
