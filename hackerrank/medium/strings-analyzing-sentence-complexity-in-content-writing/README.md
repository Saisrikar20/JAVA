# Strings - Analyzing Sentence Complexity in Content Writing

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you are developing a content evaluation tool for writers. The tool assesses the readability and complexity of the text they create, providing a "difficulty quotient" to help gauge whether the content is suitable for a target audience. Words that are considered "hard" might indicate a higher complexity level, while "easy" words suggest a more readable passage. You are tasked with implementing the algorithm that calculates this difficulty quotient based on predefined rules.

You are given a string containing multiple words separated by spaces. A word is considered "hard" if:

- The number of consonants is greater than the number of vowels.
- There are three or more consecutive consonants in the word.

Otherwise, the word is considered "easy." Implement a function to count the number of hard and easy words in the string and calculate the difficulty quotient using the formula:

Difficulty quotient = (5  *hard) - (2*  easy)

Return 0 if the input string is null.

 **Input Format** 

- A single string str containing multiple words separated by spaces.
- The string contains only lowercase English letters and spaces.

 **Constraints** 

- The output value lies within the integral range.
- The input string may contain only lowercase alphabets and spaces.
- If the string is null or empty, the output should be 0.

 **Output Format** 

An integer representing the difficulty quotient.

 **Sample Input 0** 

```
qlewldoaa life ace by fantasy

```

 **Sample Output 0** 

```
11

```

 **Explanation 0** 

- qlewldoaa: Hard (more consonants than vowels)
- life: Easy
- ace: Easy
- by: Hard (3 consecutive consonants)
- fantasy: Hard (more consonants than vowels)

Calculating Difficulty Quotient:

Difficulty quotient = (5  *3) - (2*  2) = 15 - 4 = 11

 **Sample Input 1** 

```
openai is awesome

```

 **Sample Output 1** 

```
-6

```

 **Explanation 1** 

- openai: Easy
- is: Easy
- awesome: Easy

Calculating Difficulty Quotient:

Difficulty quotient = (5  *0) - (2*  3) = 0 - 6 = -6

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T14:25:36.161Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/strings-analyzing-sentence-complexity-in-content-writing/problem)