import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of subjects: ");
        int n = sc.nextInt();

        int[] grades = new int[n];

        System.out.println("Enter grades for each subject:");
        for (int i = 0; i < n; i++) {
            grades[i] = sc.nextInt();
        }

        while (true) {
            System.out.println("Enter the subject index to check grade: ");
            int index = sc.nextInt();

            try {
                System.out.println("Grade for subject " + index + ": " + grades[index]);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Invalid subject index. Please enter a number between 0 and " + (n - 1) + ".");
            }
        }

        sc.close();
    }
}
