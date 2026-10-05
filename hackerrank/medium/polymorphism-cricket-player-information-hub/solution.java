import java.util.*;
class Player {
    private String name;
    private String country;
    private String skill;
    Player(String name,String country,String skill) {
        this.name=name;
        this.country=country;
        this.skill=skill;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country=country;
    }
    public String getSkill() {
        return skill;
    }
    public void setSkill(String skill) {
        this.skill=skill;
    }
    @Override
    public String toString() {
        return String.format("%-15s %-15s %s",name,country,skill);
    }
}
class PlayerBO {
    void displayAllPlayerDetails(Player[] playerList) {
        for(Player p:playerList) {
            System.out.println(p);
        }
    }
    void displaySpecificPlayerDetails(Player[] playerList,String countryName) {
        for(Player p:playerList) {
            if(p.getCountry().equals(countryName)) {
                System.out.println(p);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of players");
        int n=sc.nextInt();
        sc.nextLine();
        Player[] playerList=new Player[n];
        for(int i=0;i<n;i++) {
            System.out.println("Enter the player name");
            String name=sc.nextLine();
            System.out.println("Enter the country name");
            String country=sc.nextLine();
            System.out.println("Enter the skill");
            String skill=sc.nextLine();
            playerList[i]=new Player(name,country,skill);
        }
        System.out.println();
        System.out.println("Player Details");
        PlayerBO pbo=new PlayerBO();
        pbo.displayAllPlayerDetails(playerList);
        System.out.println();
        System.out.println("Enter the country name for which players details to be known");
        String countryName=sc.nextLine();
        System.out.println();
        System.out.println("Player Details");
        pbo.displaySpecificPlayerDetails(playerList,countryName);
    }
}
