package hw.hw3;

import java.util.Scanner;

public class WeekPlanner {

    //class variables and objects
    private static Scanner scan = new Scanner(System.in);
    private static String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static String[][] schedule = new String[7][2];

    public static void main(String[] args) {
        //setting default tasks for each weekday
        for(int i = 0; i < weekDays.length; i++){
            schedule[i][0] = weekDays[i];
            schedule[i][1] = "waking up and doing basic exercises";
        }
        //track whether to end the loop or not
        boolean isEnd = false;
        while(!isEnd){
            System.out.print("Please, input the day of the week: ");
            String day = validityCheck();
            if(day.contains("reschedule")){
                setSchedule(day);
                continue;
            }
            //look through the entry and decide what tasks to print if the day is valid
            for(int i = 0; i < weekDays.length; i++){
                if (day.equalsIgnoreCase(weekDays[i])) {
                    printTasks(i);
                    break;
                }
            }

            //change the cycle flag to true to end the loop
            if(day.equalsIgnoreCase("exit")) isEnd = true;
        }
    }

    /**
     * Input will be scanned and analyzed to check the validity of the command
     * Unacceptable input will be disregard, new input will be requested
     * @return String will be returned if it input is valid
     */
    private static String validityCheck(){
        String day;
        while (true){
            //input is trimmed and convert to lower case to make further processes easier
            day = scan.nextLine().trim().toLowerCase();
            for(String weekDay : weekDays){
                if(day.equalsIgnoreCase(weekDay)) return day; //valid day will be returned immediately
                if(day.equalsIgnoreCase("exit")) return day;
                if(day.contains("reschedule")) return day;
            }
            System.out.print("Sorry, I don't understand you, please try again."
                    +"\nPlease, input the day of the week: ");
        }

    }

    /**
     * Day that is requested to be rearranged will be extracted from input.
     * According to the name mentioned in the command, option for new tasks will be opened
     *
     * @param command It is considered to be two strings separated by a whitespace
     */
    private static void setSchedule(String command){
        int whiteSpace = command.indexOf(" ");
        String day = command.substring(whiteSpace+1);

        int dayNum = 0;
        for(int i = 0; i < weekDays.length; i++){
            if(weekDays[i].equalsIgnoreCase(day)) dayNum = i;
        }
        System.out.printf("%s will be rescheduled.\nPlease, enter your tasks: ", day);
        //setting tasks for the day
        schedule[dayNum][1] = scan.nextLine();
    }

    /**
     * According to the passed number, tasks of the respective day will be printed
     * @param weekDay
     */
    private static void printTasks(int weekDay){
        System.out.printf("Your tasks for %s: %s\n", schedule[weekDay][0], schedule[weekDay][1]);
    }
}
