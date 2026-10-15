import java.util.*;

class Player {
    private String name;
    private String country;
    private String skill;

    public Player() {
    }

    public Player(String name, String country, String skill) {
        this.name = name;
        this.country = country;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s", name, country, skill);
    }
}

class PlayerBO {
    public void displayPlayerDetails(Player player) {
        System.out.println("Player Details ");
        System.out.println(player.toString());
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the player name");
        String name = sc.nextLine();

        System.out.println("Enter the country");
        String country = sc.nextLine();

        System.out.println("Enter the skill");
        String skill = sc.nextLine();

        Player player = new Player(name, country, skill);

        PlayerBO playerBO = new PlayerBO();
        playerBO.displayPlayerDetails(player);

        sc.close();
    }
}
