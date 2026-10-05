# Polymorphism - Restaurant Food Delivery Tracker

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The Restaurant Food Delivery Tracker is a software application designed to assist customers in tracking their food orders from various restaurants. In today's fast-paced world, customers often seek timely updates on their food delivery status. This application aims to enhance customer satisfaction by providing real-time updates based on different criteria: order ID, customer name, or a combination of both with the restaurant name. The application uses method overloading to cater to different user inputs efficiently.

In this scenario, we will create a Restaurant Food Delivery Tracker application that tracks food delivery orders based on various parameters. The application will utilize method overloading to handle different types of order queries.

Program Specifications

Class Name: FoodDelivery

Methods:

- void trackOrder(int orderId): This method tracks the delivery status of an order using the order ID.
- void trackOrder(String customerName): This method tracks all orders associated with a specific customer name.
- void trackOrder(String customerName, String restaurantName): This method tracks all orders for a specific customer from a specific restaurant.

Main Class: Main

- This class will interact with the user, allowing them to choose how they want to track their order.

 **Input Format** 

The user can choose to track an order using:

- An order ID (integer).
- A customer name (string).
- A combination of customer name and restaurant name (two strings).

 **Constraints** 

NA

 **Output Format** 

The system will display the delivery status based on the input provided.

 **Sample Input 0** 

```
1
12345

```

 **Sample Output 0** 

```
Welcome to the Restaurant Food Delivery Tracker
Select tracking option:
1. Track by Order ID
2. Track by Customer Name
3. Track by Customer Name and Restaurant Name
Enter your choice (1-3): Enter the Order ID: Tracking Order ID: 12345
Order ID: 12345 is out for delivery.

```

 **Sample Input 1** 

```
2
Alice

```

 **Sample Output 1** 

```
Welcome to the Restaurant Food Delivery Tracker
Select tracking option:
1. Track by Order ID
2. Track by Customer Name
3. Track by Customer Name and Restaurant Name
Enter your choice (1-3): Enter the Customer Name: Tracking orders for customer: Alice
Customer Alice has 2 active orders.

```

 **Sample Input 2** 

```
3
Bob
Dominos

```

 **Sample Output 2** 

```
Welcome to the Restaurant Food Delivery Tracker
Select tracking option:
1. Track by Order ID
2. Track by Customer Name
3. Track by Customer Name and Restaurant Name
Enter your choice (1-3): Enter the Customer Name: Enter the Restaurant Name: Tracking orders for customer: Bob from restaurant: Dominos
Customer Bob has an order from Dominos that is ready for pickup.

```

 **Sample Input 3** 

```
5

```

 **Sample Output 3** 

```
Welcome to the Restaurant Food Delivery Tracker
Select tracking option:
1. Track by Order ID
2. Track by Customer Name
3. Track by Customer Name and Restaurant Name
Enter your choice (1-3): Invalid choice! Please select a valid option.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T03:20:37.321Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/polymorphism-restaurant-food-delivery-tracker/problem)