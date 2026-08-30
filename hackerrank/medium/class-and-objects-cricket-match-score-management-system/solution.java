import java.util.*;

class Innings {
    String battingTeam;
    Long runs;

    // Default constructor
    Innings() {
    }

    // 2-argument constructor
    Innings(String battingTeam, Long runs) {
        this.battingTeam = battingTeam;
        this.runs = runs;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Innings[] innings = new Innings[2];

        System.out.println("Enter the values for Innings 1");

        System.out.println("Enter the BattingTeam");
        String team1 = sc.nextLine();

        System.out.println("Enter the runs scored");
        Long runs1 = sc.nextLong();
        sc.nextLine();

        innings[0] = new Innings(team1, runs1);

        System.out.println("Enter the values for Innings 2");

        System.out.println("Enter the BattingTeam");
        String team2 = sc.nextLine();

        System.out.println("Enter the runs scored");
        Long runs2 = sc.nextLong();

        innings[1] = new Innings(team2, runs2);

        System.out.println("Innings 1 Details");
        System.out.println("BattingTeam: " + innings[0].battingTeam);
        System.out.println("Runs scored: " + innings[0].runs);

        System.out.println("Innings 2 Details");
        System.out.println("BattingTeam: " + innings[1].battingTeam);
        System.out.println("Runs scored: " + innings[1].runs);
    }
}
