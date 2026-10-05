import java.util.*;
import java.text.*;
class Match {
    void displayMatchDetails(Date matchDate) {
        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
        System.out.println("Match Date: "+sdf.format(matchDate));
    }
    void displayMatchDetails(String venue) {
        String[] parts=venue.split(",");
        System.out.println("Match Venue:");
        System.out.println("Stadium: "+parts[0].trim());
        System.out.println("City: "+parts[1].trim());
    }
    void displayMatchDetails(String winnerTeam,long runs) {
        System.out.println("Match Outcome:");
        System.out.println(winnerTeam+" won by "+runs+" runs.");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Match m=new Match();
        System.out.println("Menu");
        System.out.println("1. Match Date");
        System.out.println("2. Match Venue");
        System.out.println("3. Match Outcome");
        System.out.print("Enter your choice (1-3): ");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1) {
            System.out.print("Enter the date of the match (dd/MM/yyyy): ");
            String date=sc.nextLine();
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                Date d=sdf.parse(date);
                m.displayMatchDetails(d);
            }
            catch(Exception e) {
                System.out.println("Invalid date");
            }
        }
        else if(choice==2) {
            System.out.print("Enter venue of the match (Stadium, City): ");
            String venue=sc.nextLine();
            m.displayMatchDetails(venue);
        }
        else if(choice==3) {
            System.out.print("Enter the winner team of the match: ");
            String team=sc.nextLine();
            System.out.print("Enter the number of runs: ");
            long runs=sc.nextLong();
            m.displayMatchDetails(team,runs);
        }
    }
}
