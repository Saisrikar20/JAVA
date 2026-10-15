import java.util.*;

class Delivery {
    private Long over;
    private Long ball;
    private String batsman;
    private String bowler;
    private String nonStriker;

    public Delivery(Long over, Long ball, String batsman,
                    String bowler, String nonStriker) {
        this.over = over;
        this.ball = ball;
        this.batsman = batsman;
        this.bowler = bowler;
        this.nonStriker = nonStriker;
    }

    public Long getOver() {
        return over;
    }

    public void setOver(Long over) {
        this.over = over;
    }

    public Long getBall() {
        return ball;
    }

    public void setBall(Long ball) {
        this.ball = ball;
    }

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public String getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(String nonStriker) {
        this.nonStriker = nonStriker;
    }

    @Override
    public String toString() {
        return "Over : " + over + "\n"
             + "Ball : " + ball + "\n"
             + "Batsman : " + batsman + "\n"
             + "Bowler : " + bowler + "\n"
             + "NonStriker : " + nonStriker;
    }
}

class DeliveryBO {
    public void displayAllDeliveryDetails(Delivery[] deliveryList) {
        System.out.println("Delivery Details");

        for (int i = 0; i < deliveryList.length; i++) {
            System.out.println("Delivery -- " + (i + 1));
            System.out.println(deliveryList[i]);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of deliveries");
        int n = sc.nextInt();

        Delivery[] deliveryList = new Delivery[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the over");
            Long over = sc.nextLong();

            System.out.println("Enter the ball");
            Long ball = sc.nextLong();
            sc.nextLine();

            System.out.println("Enter the batsman");
            String batsman = sc.nextLine();

            System.out.println("Enter the bowler");
            String bowler = sc.nextLine();

            System.out.println("Enter the nonStriker");
            String nonStriker = sc.nextLine();

            deliveryList[i] = new Delivery(
                over, ball, batsman, bowler, nonStriker
            );
        }

        DeliveryBO deliveryBO = new DeliveryBO();
        deliveryBO.displayAllDeliveryDetails(deliveryList);

        sc.close();
    }
}
