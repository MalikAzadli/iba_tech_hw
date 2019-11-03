package hw.hw13.console;

import hw.hw13.controller.FamilyController;
import hw.hw13.exception.FamilyOverflowException;
import hw.hw13.human.Family;
import hw.hw13.human.Human;
import hw.hw13.human.Man;
import hw.hw13.human.Woman;
import hw.hw13.pet.Dog;
import hw.hw13.pet.Species;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Executioner {

    private List<String> data;
    private List<String> lines;
    private FamilyController controller;
    private int commandNumber;
    private int subTopic = 0;

    public Executioner(FamilyController controller) throws FileNotFoundException {
        this.controller = controller;
        File file = new File("commandRequests");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        this.lines = br.lines().collect(Collectors.toList());
    }

    public List<String> getCommandRequests(int number) {
        this.commandNumber = number;
        List<String> requests = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith(number + ".")) requests.add(lines.get(i));
        }
        return requests;
    }

    public List<String> getCommandRequests(String string) {
        this.commandNumber = Integer.parseInt(string.substring(0, string.indexOf(".")));
        this.subTopic = Integer.parseInt(string.substring(string.indexOf(".") + 1));
        List<String> requests = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith(string)) requests.add(lines.get(i));
        }
        return requests;
    }

    public void executeCommand(List<String> requests) {
        this.data = requests;
        switch (commandNumber) {
            case 1:
                fillWithTestData();
                break;
            case 2:
                displayFamilies();
                break;
            case 3:
                familiesBiggerThan();
                break;
            case 4:
                familiesLessThan();
                break;
            case 5:
                countFamiliesWithMemberNumber();
                break;
            case 6:
                createNewFamily();
                break;
            case 7:
                deleteFamily();
                break;
            case 8:
                editFamily();
                break;
            case 9:
                deleteOlderChildren();
                break;

        }
    }

    private void fillWithTestData() {
        Human jamesMaud = new Man("James", "Maud", LocalDate.of(1960, 10, 28).toEpochDay(), null);
        Human nataliaMaud = new Woman("Natalia", "Maud", LocalDate.of(1970, 10, 28).toEpochDay(), null);

        Human markKane = new Man("Mark", "Kane", LocalDate.of(1965, 10, 28).toEpochDay(), null);
        Human juliaKane = new Woman("Julia", "Kane", LocalDate.of(1972, 10, 28).toEpochDay(), null);

        controller.createNewFamily(jamesMaud, nataliaMaud);
        controller.createNewFamily(markKane, juliaKane);
        Family maud = controller.getFamilyById(0);
        Human markMaud = new Man("Mark", "Maud", LocalDate.of(2007, 10, 28).toEpochDay(), maud);
        Human janeMaud = new Woman("Jane", "Maud", LocalDate.of(1993, 10, 28).toEpochDay(), maud);

        Human jakeMiles = new Man("Jake", "Miles", LocalDate.of(1945, 10, 28).toEpochDay(), null);
        Human barbaraMiles = new Man("Barbara", "Miles", LocalDate.of(1951, 10, 28).toEpochDay(), null);
        controller.createNewFamily(jakeMiles, barbaraMiles);

        //addPet and getPets
        controller.addPet(1, new Dog(Species.DOG, "Balto"));
        controller.addPet(1, new Dog(Species.DOG, "Mike"));

    }

    private void displayFamilies() {
        controller.displayAllFamilies();
    }

    private void familiesLessThan() {
        int number = convertToNumber(data.get(0));
        controller.getAllFamiliesLessThan(number);
    }

    private void familiesBiggerThan() {
        int number = convertToNumber(data.get(0));
        controller.getAllFamiliesBiggerThan(number);
    }

    private void countFamiliesWithMemberNumber() {
        int number = convertToNumber(data.get(0));
        controller.countFamiliesWithMemberNumber(number);
    }

    private void createNewFamily() {
        String date = (String.format("%s/%s/%s", data.get(4), data.get(3), data.get(2)));
        Human father = new Man(data.get(0), data.get(1), date, convertToNumber(data.get(5)));
        date = (String.format("%s/%s/%s", data.get(10), data.get(9), data.get(8)));
        Human mother = new Woman(data.get(6), data.get(7), date, convertToNumber(data.get(11)));
        controller.createNewFamily(father, mother);
    }

    private void deleteFamily() {
        int index = convertToNumber(data.get(0));
        if (!isValidFamily(index)) return;
        controller.deleteFamilyByIndex(index - 1);
    }

    private void deleteOlderChildren() {
        int age = convertToNumber(data.get(0));
        controller.deleteAllChildrenOlderThan(age);
    }

    private void editFamily() {
        try {
            if (subTopic == 1) bornChild();
            else if (subTopic == 2) adoptBaby();
            else System.out.println("You were returned to the main control.");
        } catch (FamilyOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    private void bornChild() throws FamilyOverflowException {
        int familyIndex = convertToNumber(data.get(0)) - 1;
        if (!isValidFamily(familyIndex)) {
            return;
        } else {
            Family family = controller.getFamilyById(familyIndex);
            controller.bornChild(family, data.get(1), data.get(2));
        }
    }

    private void adoptBaby() throws FamilyOverflowException {
        int familyIndex = convertToNumber(data.get(0)) - 1;
        if (!isValidFamily(familyIndex)) return;
        Family family = controller.getFamilyById(familyIndex);
        String date = data.get(4);
        Human kid = new Woman(data.get(2), data.get(3), date, convertToNumber(data.get(5)));
        if (data.get(1).equalsIgnoreCase("male")) {
            kid = new Man(data.get(2), data.get(3), date, convertToNumber(data.get(5)));
        } else {

        }
        controller.adoptChild(family, kid);
    }

    private int convertToNumber(String string) {
        int number = 0;
        try {
            number = Integer.parseInt(string);
        } catch (IllegalArgumentException e) {
            System.out.println("You have entered invalid input!!");
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return number;
    }

    private boolean isValidFamily(int index) {
        try {
            controller.getFamilyById(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void loadData() throws IOException, ClassNotFoundException {
        controller.loadData();
    }

    public void saveData() throws IOException {
        controller.saveData();
    }

}
