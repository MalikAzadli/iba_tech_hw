package hw3;

import java.util.Scanner;

public class WeekPlanner {

    private static Scanner scan = new Scanner(System.in);
    private static String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static String[][] schedule = new String[7][2];

    public static void main(String[] args) {

        for(int i = 0; i < weekDays.length; i++){
            schedule[i][0] = weekDays[i];
            schedule[i][1] = "waking up and doing basic exercises";
        }

        boolean isEnd = false;
        while(!isEnd){
            System.out.print("Please, input the day of the week: ");
            String day = validityCheck();

            for(int i = 0; i < weekDays.length; i++){
                if (day.equalsIgnoreCase(weekDays[i])) printTasks(i);
            }

            if(day.equalsIgnoreCase("exit")) isEnd = true;
        }
    }

    private static String validityCheck(){
        boolean isValid = false;
        String day = "";
        while (!isValid){
            day = scan.nextLine().trim();
            for(String weekDay : weekDays){
                if(day.equalsIgnoreCase(weekDay)){
                    isValid = true;
                    return day;
                }
                if(day.equalsIgnoreCase("exit")) return day;
            }
            System.out.print("Sorry, I don't understand you, please try again."
                    +"\nPlease, input the day of the week: ");
        }

        return day.trim();
    }

    private static void printTasks(int weekDay){
        System.out.printf("Your tasks for %s: %s\n", schedule[weekDay][0], schedule[weekDay][1]);
    }
}
