import java.util.*;

interface IPlayerStatistics {
    public void displayPlayerStatistics();
}

abstract class Player {
    protected String name;
    protected String teamName;
    protected Integer noOfMatches;

    public Player(String name, String teamName, Integer noOfMatches) {
        this.name = name;
        this.teamName = teamName;
        this.noOfMatches = noOfMatches;
    }
}

class CricketPlayer extends Player implements IPlayerStatistics {
    private Long totalRunsScored;
    private Integer noOfWicketsTaken;

    public CricketPlayer(String name, String teamName, Integer noOfMatches,
                         Long totalRunsScored, Integer noOfWicketsTaken) {
        super(name, teamName, noOfMatches);
        this.totalRunsScored = totalRunsScored;
        this.noOfWicketsTaken = noOfWicketsTaken;
    }

    public void displayPlayerStatistics() {
        System.out.println("Player Details:");
        System.out.println("Player name: " + name);
        System.out.println("Team name: " + teamName);
        System.out.println("No of matches: " + noOfMatches);
        System.out.println("Total runs scored: " + totalRunsScored);
        System.out.println("No of wickets taken: " + noOfWicketsTaken);
    }
}

class HockeyPlayer extends Player implements IPlayerStatistics {
    private String position;
    private Integer noOfGoals;

    public HockeyPlayer(String name, String teamName, Integer noOfMatches,
                        String position, Integer noOfGoals) {
        super(name, teamName, noOfMatches);
        this.position = position;
        this.noOfGoals = noOfGoals;
    }

    public void displayPlayerStatistics() {
        System.out.println("Player Details:");
        System.out.println("Player name: " + name);
        System.out.println("Team name: " + teamName);
        System.out.println("No of matches: " + noOfMatches);
        System.out.println("Position: " + position);
        System.out.println("No of goals taken: " + noOfGoals);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Cricket Player Details");
        System.out.println("2. Hockey Player Details");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter player name: ");
        String name = sc.nextLine();

        System.out.print("Enter team name: ");
        String teamName = sc.nextLine();

        System.out.print("Enter number of matches played: ");
        int noOfMatches = sc.nextInt();
        sc.nextLine();

        IPlayerStatistics player;

        if (choice == 1) {
            System.out.print("Enter total runs scored: ");
            long runs = sc.nextLong();

            System.out.print("Enter total number of wickets taken: ");
            int wickets = sc.nextInt();

            player = new CricketPlayer(
                name, teamName, noOfMatches, runs, wickets
            );

        } else if (choice == 2) {
            System.out.print("Enter the position: ");
            String position = sc.nextLine();

            System.out.print("Enter total number of goals scored: ");
            int goals = sc.nextInt();

            player = new HockeyPlayer(
                name, teamName, noOfMatches, position, goals
            );

        } else {
            sc.close();
            return;
        }

        player.displayPlayerStatistics();
        sc.close();
    }
}
