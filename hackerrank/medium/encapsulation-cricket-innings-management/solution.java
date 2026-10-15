import java.util.*;

class Innings {
    private String battingTeam;
    private Long runs;

    public Innings(String battingTeam, Long runs) {
        this.battingTeam = battingTeam;
        this.runs = runs;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(String battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Long getRuns() {
        return runs;
    }

    public void setRuns(Long runs) {
        this.runs = runs;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s", battingTeam, runs);
    }
}

class InningsBO {
    public void displayAllInningsDetails(Innings[] inningsList) {
        System.out.println("Innings Details");
        for (Innings innings : inningsList) {
            System.out.println(innings);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Innings[] inningsList = new Innings[2];

        System.out.println("Enter the values for FirstInnings");
        System.out.println("Enter the BattingTeam");
        String team1 = sc.nextLine();

        System.out.println("Enter the runs scored");
        Long runs1 = sc.nextLong();
        sc.nextLine();

        inningsList[0] = new Innings(team1, runs1);

        System.out.println("Enter the values for SecondInnings");
        System.out.println("Enter the BattingTeam");
        String team2 = sc.nextLine();

        System.out.println("Enter the runs scored");
        Long runs2 = sc.nextLong();

        inningsList[1] = new Innings(team2, runs2);

        InningsBO inningsBO = new InningsBO();
        inningsBO.displayAllInningsDetails(inningsList);

        sc.close();
    }
}
