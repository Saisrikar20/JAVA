import java.util.*;

interface IPlayerStatistics {
    public void displayPlayerStatistics();
}

class Player implements IPlayerStatistics {
    private String name;
    private String teamName;
    private Integer noOfMatches;
    private Long totalRunsScored;
    private Integer noOfWicketsTaken;

    public Player(String name, String teamName, Integer noOfMatches,
                  Long totalRunsScored, Integer noOfWicketsTaken) {
        this.name = name;
        this.teamName = teamName;
        this.noOfMatches = noOfMatches;
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

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter player name: ");
        String name = sc.nextLine();

        System.out.print("Enter team name: ");
        String teamName = sc.nextLine();

        System.out.print("Enter number of matches played: ");
        int noOfMatches = sc.nextInt();

        System.out.print("Enter total runs scored: ");
        long totalRunsScored = sc.nextLong();

        System.out.print("Enter number of wickets taken: ");
        int noOfWicketsTaken = sc.nextInt();

        Player player = new Player(
            name, teamName, noOfMatches, totalRunsScored, noOfWicketsTaken
        );

        player.displayPlayerStatistics();

        sc.close();
    }
}
