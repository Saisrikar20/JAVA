import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double income, expenses;

        while (true) {
            try {
                System.out.println("Enter your estimated monthly income: ");
                income = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric value.");
            }
        }

        while (true) {
            try {
                System.out.println("Enter your expected monthly expenses: ");
                expenses = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric value.");
            }
        }

        System.out.printf("Remaining balance: Rs.%.2f%n", income - expenses);
        sc.close();
    }
}
