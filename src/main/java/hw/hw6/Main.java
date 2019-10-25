package hw.hw6;

public class Main {
    public static void main(String[] args) throws Throwable {
        String[][] schedule = new String[7][2];
        schedule[0][0] = DayOfWeek.SUNDAY.name();
        schedule[0][1] = "just some routine stuff";
        int count = 0;
        for(int i = 0; i < 1000; i++){
            count++;

            Human human = new Human("James", "Stewart", 1900, null);
            if(count > 990) human.finalize();
        }
    }
}
