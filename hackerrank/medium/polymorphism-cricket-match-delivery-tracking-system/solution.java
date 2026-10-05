import java.util.*;
class Delivery {
    void displayDeliveryDetails(String bowler,String batsman) {
        String b=bowler.substring(bowler.lastIndexOf(" ")+1);
        String bat=batsman.substring(batsman.lastIndexOf(" ")+1);
        System.out.println("Player details of the delivery:");
        System.out.println("Bowler: "+b);
        System.out.println("Batsman: "+bat);
    }
    void displayDeliveryDetails(Long runs) {
        System.out.println("Number of runs scored in the delivery: "+runs);
        if(runs==6)
        System.out.println("It is a Sixer.");
        else if(runs==4)
        System.out.println("It is a boundary.");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Delivery d=new Delivery();
        System.out.println("Menu");
        System.out.println("1. Player details of the delivery");
        System.out.println("2. Run details of the delivery");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1) {
            System.out.println("Enter the bowler name: ");
            String bowler=sc.nextLine();
            System.out.println("Enter the batsman name: ");
            String batsman=sc.nextLine();
            d.displayDeliveryDetails(bowler,batsman);
        }
        else if(choice==2) {
            System.out.println("Enter the number of runs: ");
            Long runs=sc.nextLong();
            d.displayDeliveryDetails(runs);
        }
    }
}
