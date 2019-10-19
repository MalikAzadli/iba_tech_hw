
package hw.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        //Array to store all guessed numbers
        ArrayList<Integer> user_numbers = new ArrayList<>();
        //program choose random number from range of [0-100]
        int chosenNumber = rand.nextInt(101);

        System.out.print("Please, enter your name.\nName: ");
        String name = scan.nextLine(); //scan player name
        System.out.println("Let the game begin!");

        int player_num;

        do {
            System.out.print("Enter your guess: ");
            //checks the validity of the input
            while(!scan.hasNextInt()) {
                System.out.print("This is not a number\nPlease, enter a number: ");
                scan.next();
            }
            //scan user's guess
            player_num = scan.nextInt();
            //add number to the array to keep record of all guesses
            user_numbers.add(player_num);
            //checks whether number is bigger or smaller than hidden number
            if(player_num > chosenNumber) {
                System.out.println("Your number is too big. Please, try again.");
            } else if( player_num < chosenNumber){
                System.out.println("Your number is too small. Please, try again.");
            }

        } while (player_num != chosenNumber);

        System.out.printf("Congratulations, %s!\n", name);
        Collections.sort(user_numbers); //sorting numbers that was guessed by player
        System.out.println("Your numbers: " + user_numbers);
    }
}
