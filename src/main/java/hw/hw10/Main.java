package hw.hw10;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Human james = new Man("James", "caan", LocalDate.of(1999, 8, 31).toEpochDay(), null);
        System.out.println(james.describeAge());

        Human orphan = new Man("Jerry", "Seinfeld", "21/09/1996", 119);
        System.out.println(orphan);

    }
}
