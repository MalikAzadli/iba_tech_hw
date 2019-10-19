
package hw.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Numbers {

    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Random rand = new Random();

        ArrayList<Integer> userNumbers = new ArrayList<>();
        int hiddenNumber = rand.nextInt(101); //number in range of [0-100]

        System.out.print("Please, enter your name.\nName: ");
        String name = scan.nextLine(); //scan player name
        System.out.println("Let the game begin!");

        int playerNum;

        do {
            System.out.print("Enter your guess: ");
            playerNum = validityCheck();
            userNumbers.add(playerNum);

            //checks whether number is bigger or smaller than hidden number
            if(playerNum > hiddenNumber) {
                System.out.println("Your number is too big. Please, try again.");
            } else if( playerNum < hiddenNumber){
                System.out.println("Your number is too small. Please, try again.");
            }

        } while (playerNum != hiddenNumber);

        System.out.printf("Congratulations, %s!\n", name);
        Collections.sort(userNumbers); //sorting numbers that was guessed by player
        System.out.println("Your numbers: " + userNumbers);
    }

    /**
     * Checks whether input is valid or not
     * @return int input
     */
    public static int validityCheck(){
        int playerNum;
        while(!scan.hasNextInt()) {
            System.out.print("This is not a number\nPlease, enter a number: ");
            scan.next();
        }
        playerNum = scan.nextInt();
        return playerNum;
    }
}
