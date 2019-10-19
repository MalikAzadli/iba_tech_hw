package hw.hw2;

import java.util.Random;
import java.util.Scanner;

public class AreaShooting {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Random rand = new Random();
        String[][] battleField = createField(5,5);
        //variables to keep record of target
        int tarLine = rand.nextInt(5)+1;
        int tarBar = rand.nextInt(5)+1;
        //number of shoots that have been completed
        int shoot_number = 0;

        System.out.println("All set. Get ready to rumble!");

        //variables to keep record of current shoot location
        int chosenLine, chosenBar;

        do {
            System.out.print("Enter line number to fire: ");
            chosenLine = validationCheck();

            System.out.print("Enter bar number to fire: ");
            chosenBar = validationCheck();

            shootLocation(chosenLine,chosenBar,battleField);
            shoot_number++;
        } while (tarLine != chosenLine || tarBar != chosenBar);
        System.out.println("You have won!");
        //after game finished, target location is marked with 'x'
        battleField[tarLine][tarBar] = " x |";

        printField(battleField);
        System.out.printf("You have defeated the enemy after %d shoots", shoot_number);
    }

    /**
     * Checks whether the number that is chosen by user is valid
     * in terms of the size of the field.
     * @return int will be returned if input is valid
     */
    private static int validationCheck() {
        int chosenLocation = isNumber();
        //checks validity of the number
        while(chosenLocation > 5 || chosenLocation < 1){
            System.out.print("This is not a valid number.\nEnter new number between 1 and 5: ");
            chosenLocation = isNumber();
        }
        return chosenLocation;
    }

    /**
     * Checks whether input passed by user is number (integer) or not
     * @return int
     */
    private static int isNumber(){
        int number;
        //asks for a new input if input passed before is not an integer
        while(!scan.hasNextInt()){
            System.out.print("This is not a number. Please, enter a number: ");
            scan.next();
        }
        number=scan.nextInt();
        return number;
    }

    /**
     * Creates field according to the numbers have passed. Extra line and bar
     * will be added to show the location of the respective rows and columns
     * @param height height of the field
     * @param width width of the field
     * @return Multidimensional array of String will be returned
     */
    private static String[][] createField(int height, int width){
        String[][] arr = new String[height+1][width+1];
        for(int i = 0; i < arr.length; i++ ){
            for(int z = 0; z < arr[i].length; z++) {
                if(i==0) {
                    //respective numbers will be added through first bar
                    arr[i][z] = " " + z + " |";
                } else if(z==0) {
                    //respective numbers will be added through first line
                    arr[i][z] = " " + i + " |";
                } else {
                    arr[i][z] = " - |";
                }
            }
        }
        return arr;
    }

    /**
     * Prints the passed multidimensional Array of String
     * @param arr Array that will be printed in console
     */
    private static void printField(String[][] arr){
        //current values of all cells will be printed
        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    /**
     * Specific location of the field will be shot according to the passed arguments.
     * @param line row number
     * @param bar column number
     * @param arr Array which will be modified
     */
    private static void shootLocation(int line, int bar, String[][] arr){
        //cell that has been shot will be marked with asterisk
        arr[line][bar]=" * |";
        printField(arr);
    }
}
