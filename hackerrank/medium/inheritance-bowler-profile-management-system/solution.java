import java.util.Scanner;

class Player {
    String name;
    String team;
    int age;
    
    Player(String name, String team, int age) {
        this.name = name;
        this.team = team;
        this.age = age;
    }
    
    void displayPlayerInfo() {
        System.out.println("Player Details:");
        System.out.println("Name: " + name);
        System.out.println("Team: " + team);
        System.out.println("Age: " + age);
    }
}

class Bowler extends Player {
    int wicketsTaken;
    double bowlingAverage;
    
    Bowler(String name, String team, int age, int wicketsTaken, double bowlingAverage) {
        super(name, team, age);
        this.wicketsTaken = wicketsTaken;
        this.bowlingAverage = bowlingAverage;
    }
    
    void displayBowlerInfo() {
        System.out.println("Bowler Details:");
        System.out.println("Wickets Taken: " + wicketsTaken);
        System.out.println("Bowling Average: " + bowlingAverage);
    }
}

class FastBowler extends Bowler {
    int averageSpeed;
    
    FastBowler(String name, String team, int age, int wicketsTaken, double bowlingAverage, int averageSpeed) {
        super(name, team, age, wicketsTaken, bowlingAverage);
        this.averageSpeed = averageSpeed;
    }
    
    void displayFastBowlerInfo() {
        System.out.println("Fast Bowler Details:");
        System.out.println("Average Speed: " + averageSpeed + " km/h");
        }
        }
        
        public class Main {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                
                System.out.println("Enter the player's name:");
                String name = sc.nextLine();
                
                System.out.println("Enter the player's team:");
                String team = sc.nextLine();
                
                System.out.println("Enter the player's age:");
                int age = sc.nextInt();
                
                System.out.println("Enter the number of wickets taken:");
                int wicketsTaken = sc.nextInt();
                
                System.out.println("Enter the bowling average:");
                double bowlingAverage = sc.nextDouble();
                
                System.out.println("Enter the average speed:");
                int averageSpeed = sc.nextInt();
                
                FastBowler fb = new FastBowler(name, team, age, wicketsTaken, bowlingAverage, averageSpeed);
                
                fb.displayPlayerInfo();
                fb.displayBowlerInfo();
                fb.displayFastBowlerInfo();
                
                sc.close();
    }
}
