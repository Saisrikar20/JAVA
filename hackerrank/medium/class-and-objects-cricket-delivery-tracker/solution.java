import java.util.*;

class Delivery {
    private int over;
    private int ball;
    private int runs;
    private String batsman;
    private String bowler;
    private String nonStriker;

    // Default constructor
    Delivery() {
    }

    // Parameterized constructor
    Delivery(int over, int ball, int runs, String batsman,
             String bowler, String nonStriker) {
        this.over = over;
        this.ball = ball;
        this.runs = runs;
        this.batsman = batsman;
        this.bowler = bowler;
        this.nonStriker = nonStriker;
    }

    // Getters
    int getOver() {
        return over;
    }

    int getBall() {
        return ball;
    }

    int getRuns() {
        return runs;
    }

    String getBatsman() {
        return batsman;
    }

    String getBowler() {
        return bowler;
    }

    String getNonStriker() {
        return nonStriker;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the over");
        int over = sc.nextInt();

        System.out.println("Enter the ball");
        int ball = sc.nextInt();

        System.out.println("Enter the runs");
        int runs = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter the batsman name");
        String batsman = sc.nextLine();

        System.out.println("Enter the bowler name");
        String bowler = sc.nextLine();

        System.out.println("Enter the nonStriker name");
        String nonStriker = sc.nextLine();

        Delivery delivery = new Delivery(
            over, ball, runs, batsman, bowler, nonStriker
        );

        System.out.println("Over: " + delivery.getOver());
        System.out.println("Ball: " + delivery.getBall());
        System.out.println("Runs: " + delivery.getRuns());
        System.out.println("Batsman: " + delivery.getBatsman());
        System.out.println("Bowler: " + delivery.getBowler());
        System.out.println("NonStriker: " + delivery.getNonStriker());
    }
}
