import java.util.*;

class Team {
    String name;
    String coach;
    String location;
    String players;
    String captain;

    // Default constructor
    Team() {
    }

    // 5-Argument constructor
    Team(String name, String coach, String location, String players, String captain) {
        this.name = name;
        this.coach = coach;
        this.location = location;
        this.players = players;
        this.captain = captain;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the team details");
        String input = sc.nextLine();

        String[] details = input.split("#");

        Team team = new Team(
            details[0],
            details[1],
            details[2],
            details[3],
            details[4]
        );

        System.out.println("Team: " + team.name);
        System.out.println("Coach: " + team.coach);
        System.out.println("Location: " + team.location);
        System.out.println("Players: " + team.players);
        System.out.println("Captain: " + team.captain);
    }
}
