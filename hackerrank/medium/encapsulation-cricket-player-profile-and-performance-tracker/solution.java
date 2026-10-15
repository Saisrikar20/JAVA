import java.util.*;

class CricketPlayer {
    private String name;
    private int age;
    private String role;
    private int matchesPlayed;
    private int runsScored;

    public CricketPlayer(String name, int age, String role,
                         int matchesPlayed, int runsScored) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void addRuns(int runs) {
        if (runs > 0) {
            runsScored += runs;
            System.out.println("Runs added successfully. Updated Runs Scored: " + runsScored);
        } else {
            System.out.println("Invalid Input");
        }
    }

    public void addMatches(int matches) {
        if (matches > 0) {
            matchesPlayed += matches;
            System.out.println("Matches added successfully. Updated Matches Played: " + matchesPlayed);
        } else {
            System.out.println("Invalid Input");
        }
    }

    public void displayPlayerDetails() {
        System.out.println("Player Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Role: " + role);
        System.out.println("Matches Played: " + matchesPlayed);
        System.out.println("Runs Scored: " + runsScored);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the player's name:");
        String name = sc.nextLine();

        System.out.println("Enter the player's age:");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the player's role:");
        String role = sc.nextLine();

        System.out.println("Enter matches played:");
        int matchesPlayed = sc.nextInt();

        System.out.println("Enter runs scored:");
        int runsScored = sc.nextInt();

        CricketPlayer player = new CricketPlayer(
            name, age, role, matchesPlayed, runsScored
        );

        player.displayPlayerDetails();

        System.out.println("Enter runs to add:");
        int runs = sc.nextInt();
        player.addRuns(runs);

        System.out.println("Enter matches to add:");
        int matches = sc.nextInt();
        player.addMatches(matches);

        player.displayPlayerDetails();

        sc.close();
    }
}
