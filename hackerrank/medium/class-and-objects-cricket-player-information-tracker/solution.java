import java.util.*;

class Player {
    String name;
    String country;
    String skill;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the player details");
        String input = sc.nextLine();

        String[] details = input.split(",");

        Player player = new Player();

        player.name = details[0];
        player.country = details[1];
        player.skill = details[2];

        System.out.println("Player Details ");
        System.out.println("Player Name : " + player.name);
        System.out.println("Country Name : " + player.country);
        System.out.println("Skill : " + player.skill);
    }
}
