package hw.hw12.console;

import hw.hw12.controller.FamilyController;

import java.util.Scanner;

public class Console {

    private static final String stop = "exit";
    private Scanner scanner;

    private FamilyController controller;

    public Console(FamilyController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        while (true){

        }
    }

}
