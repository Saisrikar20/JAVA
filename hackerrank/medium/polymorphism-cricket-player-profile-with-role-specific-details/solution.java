import java.util.*;
class Player {
    String name;
    String country;
    int matches;
    Player(String name,String country,int matches) {
        this.name=name;
        this.country=country;
        this.matches=matches;
    }
    public void displayPlayerInfo() {
        System.out.println("Name: "+name);
        System.out.println("Country: "+country);
        System.out.println("Matches Played: "+matches);
    }
}
class Batsman extends Player {
    double battingAverage;
    int totalRuns;
    Batsman(String name,String country,int matches,double battingAverage,int totalRuns) {
        super(name,country,matches);
        this.battingAverage=battingAverage;
        this.totalRuns=totalRuns;
    }
    public void displayPlayerInfo() {
        super.displayPlayerInfo();
        System.out.println("Player Type: Batsman");
        System.out.println("Batting Average: "+battingAverage);
        System.out.println("Total Runs: "+totalRuns);
    }
}
class Bowler extends Player {
    double bowlingAverage;
    int totalWickets;
    Bowler(String name,String country,int matches,double bowlingAverage,int totalWickets) {
        super(name,country,matches);
        this.bowlingAverage=bowlingAverage;
        this.totalWickets=totalWickets;
    }
    public void displayPlayerInfo() {
        super.displayPlayerInfo();
        System.out.println("Player Type: Bowler");
        System.out.println("Bowling Average: "+bowlingAverage);
        System.out.println("Total Wickets: "+totalWickets);
    }
}
class AllRounder extends Player {
    double battingAverage;
    double bowlingAverage;
    AllRounder(String name,String country,int matches,double battingAverage,double bowlingAverage) {
        super(name,country,matches);
        this.battingAverage=battingAverage;
        this.bowlingAverage=bowlingAverage;
    }
    public void displayPlayerInfo() {
        super.displayPlayerInfo();
        System.out.println("Player Type: AllRounder");
        System.out.println("Batting Average: "+battingAverage);
        System.out.println("Bowling Average: "+bowlingAverage);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter player type (Batsman/Bowler/AllRounder):");
        String type=sc.nextLine();
        System.out.println("Enter player name:");
        String name=sc.nextLine();
        System.out.println("Enter country:");
        String country=sc.nextLine();
        System.out.println("Enter matches played:");
        int matches=sc.nextInt();
        Player p;
        if(type.equals("Batsman")) {
            System.out.println("Enter batting average:");
            double avg=sc.nextDouble();
            System.out.println("Enter total runs:");
            int runs=sc.nextInt();
            p=new Batsman(name,country,matches,avg,runs);
            }
            else if(type.equals("Bowler")) {
                System.out.println("Enter bowling average:");
                double avg=sc.nextDouble();
                System.out.println("Enter total wickets:");
                int wickets=sc.nextInt();
                p=new Bowler(name,country,matches,avg,wickets);
            }
            else {
                System.out.println("Enter batting average:");
                double batting=sc.nextDouble();
                System.out.println("Enter bowling average:");
                double bowling=sc.nextDouble();
                p=new AllRounder(name,country,matches,batting,bowling);
            }
            System.out.println();
            System.out.println("Player Details:");
            p.displayPlayerInfo();
    }
}
