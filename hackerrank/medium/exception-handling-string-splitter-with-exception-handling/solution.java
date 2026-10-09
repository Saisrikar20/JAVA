import java.util.Scanner;

public class Solution {
    static void splitString(String s) {
        String[] parts = s.split("/");
        for (int i = 0; i < parts.length; i++) {
            System.out.println("Splitted string at index " + i + " is: " + parts[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        try {
            if (s.length() <= 2) {
                throw new NullPointerException("String length is too short to split.");
            }
            splitString(s);
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e);
        } finally {
            System.out.println("Inside finally block");
        }

        sc.close();
    }
}
