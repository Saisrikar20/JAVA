
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total price of the items: ");
        double price = sc.nextDouble();

        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();

        while (true) {
            try {
                if (n == 0)
                    throw new ArithmeticException();

                System.out.printf("Price per item: %.2f%n", price / n);
                break;
            } catch (ArithmeticException e) {
                System.out.println("Error: Number of items cannot be zero. Please enter a valid quantity.");
                System.out.println("Enter the number of items: ");
                n = sc.nextInt();
            }
        }

        sc.close();
    }
}
