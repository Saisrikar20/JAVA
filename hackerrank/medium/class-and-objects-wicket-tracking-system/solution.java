import java.util.*;

class Wicket {
    int over;
    int ball;
    String wicketType;
    String playerName;
    String bowlerName;

    // Default constructor
    Wicket() {
    }

    // 5-argument constructor
    Wicket(int over, int ball, String wicketType,
           String playerName, String bowlerName) {
        this.over = over;
        this.ball = ball;
        this.wicketType = wicketType;
        this.playerName = playerName;
        this.bowlerName = bowlerName;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of wickets");
        int n = sc.nextInt();
        sc.nextLine();

        Wicket[] wickets = new Wicket[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the details of wicket " + (i + 1));

            String input = sc.nextLine();
            String[] details = input.split(",");

            int over = Integer.parseInt(details[0]);
            int ball = Integer.parseInt(details[1]);
            String wicketType = details[2];
            String playerName = details[3];
            String bowlerName = details[4];

            wickets[i] = new Wicket(
                over,
                ball,
                wicketType,
                playerName,
                bowlerName
            );
        }

        System.out.println("Wicket Details");

        for (int i = 0; i < n; i++) {
            System.out.println("Over: " + wickets[i].over);
            System.out.println("Ball: " + wickets[i].ball);
            System.out.println("Wicket Type: " + wickets[i].wicketType);
            System.out.println("Player Name: " + wickets[i].playerName);
            System.out.println("Bowler Name: " + wickets[i].bowlerName);
        }
    }
}
