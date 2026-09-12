import java.util.Scanner;

class Player {
    String name;
    int age;
    String team;

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Team: " + team);
    }
}

class Batsman extends Player {
    int runsScored;

    void displayBatsmanDetails() {
        System.out.println("Batsman Details:");
        displayDetails();
        System.out.println("Runs Scored: " + runsScored);
        System.out.println();
    }
}

class Bowler extends Player {
    int wicketsTaken;

    void displayBowlerDetails() {
        System.out.println("Bowler Details:");
        displayDetails();
        System.out.println("Wickets Taken: " + wicketsTaken);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Batsman batsman = new Batsman();
        System.out.println("Enter details for Batsman:");
        System.out.print("Name: ");
        batsman.name = sc.nextLine();
        System.out.print("Age: ");
        batsman.age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Team: ");
        batsman.team = sc.nextLine();
        System.out.print("Runs Scored: ");
        batsman.runsScored = Integer.parseInt(sc.nextLine().trim());
        System.out.println();

        Bowler bowler = new Bowler();
        System.out.println("Enter details for Bowler:");
        System.out.print("Name: ");
        bowler.name = sc.nextLine();
        System.out.print("Age: ");
        bowler.age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Team: ");
        bowler.team = sc.nextLine();
        System.out.print("Wickets Taken: ");
        bowler.wicketsTaken = Integer.parseInt(sc.nextLine().trim());
        System.out.println();

        batsman.displayBatsmanDetails();
        bowler.displayBowlerDetails();

        sc.close();
    }
}
