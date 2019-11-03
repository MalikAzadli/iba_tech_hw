package hw.hw12;

import hw.hw12.console.Console;
import hw.hw12.controller.FamilyController;
import hw.hw12.dao.*;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(familyDao);
        FamilyController controller = new FamilyController(service);
        Console console = new Console(controller);

        console.run();

    }
}
