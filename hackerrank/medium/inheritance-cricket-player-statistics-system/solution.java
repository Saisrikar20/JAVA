import java.util.*;

class Player {
    String name;
    String team;
    int age;

    void displayPlayerInfo() {
        System.out.println("Player Details:");
        System.out.println("Name: " + name);
        System.out.println("Team: " + team);
        System.out.println("Age: " + age);
    }
}

class Bowler extends Player {
    int wicketsTaken;
    double bowlingAverage;

    void displayBowlingStats() {
        System.out.println("Bowling Statistics:");
        System.out.println("Wickets Taken: " + wicketsTaken);
        System.out.println("Bowling Average: " + bowlingAverage);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the player's name:");
        String name = sc.nextLine();

        System.out.println("Enter the player's team:");
        String team = sc.nextLine();

        System.out.println("Enter the player's age:");
        int age = sc.nextInt();

        System.out.println("Enter the number of wickets taken:");
        int wicketsTaken = sc.nextInt();

        System.out.println("Enter the bowling average:");
        double bowlingAverage = sc.nextDouble();

        Bowler bowler = new Bowler();

        bowler.name = name;
        bowler.team = team;
        bowler.age = age;
        bowler.wicketsTaken = wicketsTaken;
        bowler.bowlingAverage = bowlingAverage;

        bowler.displayPlayerInfo();
        bowler.displayBowlingStats();
    }
}
