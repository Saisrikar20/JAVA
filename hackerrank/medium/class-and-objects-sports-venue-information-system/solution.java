import java.util.*;

class Venue {
    String name;
    String city;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the venue details");
        String input = sc.nextLine();

        String[] details = input.split(",");

        Venue venue = new Venue();

        venue.name = details[0];
        venue.city = details[1];

        System.out.println("Venue Details ");
        System.out.println("Venue Name : " + venue.name);
        System.out.println("City Name : " + venue.city);
    }
}
