package hw.hw6;

public class Main {
    public static void main(String[] args) {
        String[][] schedule = new String[7][2];
        schedule[0][0] = DayofWeek.SUNDAY.name();
        schedule[0][1] = "just some routine stuff";
        for(int i = 0; i < 1000000; i++){
            Human human = new Human("James", "Stewart", 1900, null);
        }
    }
}
