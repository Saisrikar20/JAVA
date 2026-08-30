import java.util.*;

class Venue {
    String venueName;
    String cityName;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the venue name");
        String venueName = sc.nextLine();

        System.out.println("Enter the city name");
        String cityName = sc.nextLine();

        Venue venue = new Venue();

        venue.venueName = venueName;
        venue.cityName = cityName;

        System.out.println("Venue Details");
        System.out.println("Venue Name : " + venue.venueName);
        System.out.println("City Name : " + venue.cityName);
        System.out.println(venue.venueName);
    }
}
