import java.util.*;

class Player {
    private String name;
    private String country;
    private String skill;

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getSkill() {
        return skill;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the player name");
        String name = sc.nextLine();

        System.out.println("Enter the country name");
        String country = sc.nextLine();

        System.out.println("Enter the skill");
        String skill = sc.nextLine();

        Player player = new Player();

        player.setName(name);
        player.setCountry(country);
        player.setSkill(skill);

        System.out.println("Player Details: ");
        System.out.println("Player Name : " + player.getName());
        System.out.println("Country Name : " + player.getCountry());
        System.out.println("Skill : " + player.getSkill());
    }
}
