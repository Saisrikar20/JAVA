import java.util.*;
class FoodDelivery {
    void trackOrder(int orderId) {
        System.out.println("Tracking Order ID: "+orderId);
        System.out.println("Order ID: "+orderId+" is out for delivery.");
    }
    void trackOrder(String customerName) {
        System.out.println("Tracking orders for customer: "+customerName);
        System.out.println("Customer "+customerName+" has 2 active orders.");
    }
    void trackOrder(String customerName,String restaurantName) {
        System.out.println("Tracking orders for customer: "+customerName+" from restaurant: "+restaurantName);
        System.out.println("Customer "+customerName+" has an order from "+restaurantName+" that is ready for pickup.");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        FoodDelivery f=new FoodDelivery();
        System.out.println("Welcome to the Restaurant Food Delivery Tracker");
        System.out.println("Select tracking option:");
        System.out.println("1. Track by Order ID");
        System.out.println("2. Track by Customer Name");
        System.out.println("3. Track by Customer Name and Restaurant Name");
        System.out.print("Enter your choice (1-3): ");
        int choice=sc.nextInt();
        if(choice==1) {
            System.out.print("Enter the Order ID: ");
            int id=sc.nextInt();
            f.trackOrder(id);
        }
        else if(choice==2) {
            System.out.print("Enter the Customer Name: ");
            String name=sc.next();
            f.trackOrder(name);
        }
        else if(choice==3) {
            System.out.print("Enter the Customer Name: ");
            String name=sc.next();
            System.out.print("Enter the Restaurant Name: ");
            String restaurant=sc.next();
            f.trackOrder(name,restaurant);
        }
        else {
            System.out.println("Invalid choice! Please select a valid option.");
        }
    }
}
