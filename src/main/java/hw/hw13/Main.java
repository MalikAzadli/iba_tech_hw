package hw.hw13;

import hw.hw13.console.Console;
import hw.hw13.controller.FamilyController;
import hw.hw13.dao.CollectionFamilyDao;
import hw.hw13.dao.FamilyDao;
import hw.hw13.dao.FamilyService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(familyDao);
        FamilyController controller = new FamilyController(service);
        Console console = new Console(controller);

        console.run();

    }
}
