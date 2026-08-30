import java.util.*;

class Innings {
    String number;
    String battingTeam;
    Long runs;

    void displayInningsDetails() {
        System.out.println("Innings Details :");
        System.out.println("Innings number : " + number);
        System.out.println("BattingTeam :" + battingTeam);
        System.out.println("Runs scored :" + runs);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Innings innings = new Innings();

        System.out.println("Enter the innings number");
        innings.number = sc.nextLine();

        System.out.println("Enter the BattingTeam");
        innings.battingTeam = sc.nextLine();

        System.out.println("Enter the runs scored");
        innings.runs = sc.nextLong();

        innings.displayInningsDetails();
    }
}
