package hw.hw12.console;

import hw.hw12.controller.FamilyController;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Console {

    private static final String STOP = "exit";
    private Scanner scanner;
    private Executioner executioner;

    public Console(FamilyController controller) throws FileNotFoundException {
        this.scanner = new Scanner(System.in);
        this.executioner = new Executioner(controller);
    }

    public void run() throws FileNotFoundException {
        printCommands();
        String line = "";
        while (true) {
            System.out.print(">> ");
            line = scanner.nextLine();
            if (line.equalsIgnoreCase("menu")) {
                printCommands();
                continue;
            }
            if (line.equalsIgnoreCase(STOP)) break;
            List<String> requests = getRequestList(line);
            requests = collectRequests(requests);
            executioner.executeCommand(requests);
        }
    }

    private void printCommands() throws FileNotFoundException {
        File file = new File("commands");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        br.lines().forEach(s -> System.out.println(s));
    }

    private List<String> getRequestList(String lineNumber) {
        int number = convertToNumber(lineNumber);
        checkRange(number, 9);
        List<String> requests;
        if (number == 8) {
            System.out.print("Choose one of the following options:" +
                    "\n1. Give birth to a baby" +
                    "\n2. Adopt a child" +
                    "\n3. Return to main menu" +
                    "\n>> Enter number:  ");
            int option = convertToNumber(scanner.nextLine());
            checkRange(option, 3);
            requests = executioner.getCommandRequests(String.format("%d.%d", number, option));
        } else {
            requests = executioner.getCommandRequests(number);
        }
        return requests;
    }

    private List<String> collectRequests(List<String> requests) {
        List<String> collectedData = new ArrayList<>();
        for (String request : requests) {
            System.out.print(String.format("Enter %s", request));
            String line = scanner.nextLine();
            collectedData.add(line);
        }
        return collectedData;
    }

    private int convertToNumber(String string) {
        int number = 0;
        try {
            number = Integer.parseInt(string);
        } catch (IllegalArgumentException e) {
            System.out.println("Enter number");
        }
        return number;
    }

    private void checkRange(int number, int range) {
        if (number > range || number < 1)
            System.out.println("You have entered invalid number.");
    }

}
