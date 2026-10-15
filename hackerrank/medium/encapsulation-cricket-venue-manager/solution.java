import java.util.*;

class Venue {
    private String name;
    private String city;

    public Venue() {
    }

    public Venue(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of venues");
        int n = Integer.parseInt(sc.nextLine());

        List<Venue> venues = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter the details of venue " + i);
            String input = sc.nextLine();

            String[] details = input.split(",", 2);
            String name = details[0].trim();
            String city = details[1].trim();

            venues.add(new Venue(name, city));
        }

        System.out.println("Venue Details");

        for (Venue venue : venues) {
            System.out.println("Venue Name : " + venue.getName());
            System.out.println("City Name : " + venue.getCity());
        }

        sc.close();
    }
}
