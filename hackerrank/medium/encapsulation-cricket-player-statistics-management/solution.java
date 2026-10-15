import java.util.*;

class CricketPlayer {
    private String name;
    private int totalRuns;
    private int matchesPlayed;

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public String getName() {
        return name;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CricketPlayer player = new CricketPlayer();

        System.out.println("Enter Player Name:");
        player.setName(sc.nextLine());

        System.out.println("Enter Total Runs:");
        player.setTotalRuns(sc.nextInt());

        System.out.println("Enter Matches Played:");
        player.setMatchesPlayed(sc.nextInt());

        System.out.println();
        System.out.println("Cricket Player Details:");
        System.out.println("Name: " + player.getName());
        System.out.println("Total Runs: " + player.getTotalRuns());
        System.out.println("Matches Played: " + player.getMatchesPlayed());

        sc.close();
    }
}
