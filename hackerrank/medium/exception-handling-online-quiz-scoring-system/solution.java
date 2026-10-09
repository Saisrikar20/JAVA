import java.util.Scanner;
class InvalidScoreException extends Exception {
    InvalidScoreException(String message) {
        super(message);
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter your quiz score: ");
                int score = sc.nextInt();
                try {
                    if (score < 0 || score > 100) {
                        throw new InvalidScoreException("Score must be between 0 and 100. Please enter a valid score.");
                    }
                    System.out.println("Your score of " + score + " has been recorded.");
                    break;
                } catch (InvalidScoreException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                }
        } finally {
            sc.close();
            System.out.println("Resources have been closed.");
        }
    }
}
