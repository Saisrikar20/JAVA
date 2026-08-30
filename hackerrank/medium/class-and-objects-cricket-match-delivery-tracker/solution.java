import java.util.*;

class Delivery {
    Long Over;
    Long Ball;
    Long Runs;
    String Batsman;
    String Bowler;
    String NonStriker;

    void displayDeliveryDetails() {
        System.out.println("Delivery Details :");
        System.out.println("Over : " + Over);
        System.out.println("Ball : " + Ball);
        System.out.println("Runs : " + Runs);
        System.out.println("Batsman : " + Batsman);
        System.out.println("Bowler : " + Bowler);
        System.out.println("NonStriker : " + NonStriker);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Delivery delivery = new Delivery();

        System.out.println("Enter the over");
        delivery.Over = sc.nextLong();

        System.out.println("Enter the ball");
        delivery.Ball = sc.nextLong();

        System.out.println("Enter the runs");
        delivery.Runs = sc.nextLong();

        sc.nextLine();

        System.out.println("Enter the batsman name");
        delivery.Batsman = sc.nextLine();

        System.out.println("Enter the bowler name");
        delivery.Bowler = sc.nextLine();

        System.out.println("Enter the nonStriker name");
        delivery.NonStriker = sc.nextLine();

        delivery.displayDeliveryDetails();
    }
}
