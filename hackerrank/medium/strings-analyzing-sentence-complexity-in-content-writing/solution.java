import java.io.*;
import java.util.*;

public class Solution {

    static int difficultyQuotient(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        String[] words = str.split(" ");
        int hard = 0, easy = 0;

        for (String word : words) {
            int vowels = 0, consonants = 0;
            int count = 0;
            boolean hardWord = false;

            for (char ch : word.toCharArray()) {

                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                    count = 0;
                } else {
                    consonants++;
                    count++;

                    if (count >= 3) {
                        hardWord = true;
                    }
                }
            }

            if (consonants > vowels) {
                hardWord = true;
            }

            
            if (hardWord) {
                hard++;
            } else {
                easy++;
            }
        }

        return (5 * hard) - (2 * easy);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(difficultyQuotient(str));

        sc.close();
    }
}
