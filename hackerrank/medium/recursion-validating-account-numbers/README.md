# Recursion - Validating Account Numbers

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A banking application requires users to enter their account numbers for authentication. The system needs to validate the length of the entered account number. If the user provides an incorrect number of digits, the system should prompt the user to try again. The application uses recursion to count the number of digits in the entered account number. By recursively counting each digit, the application ensures the correct length for valid account numbers.

 **Input Format** 

A positive integer n.

 **Constraints** 

NA

 **Output Format** 

The number of digits in the number.

 **Sample Input 0** 

```
12345

```

 **Sample Output 0** 

```
5

```

 **Sample Input 1** 

```
9

```

 **Sample Output 1** 

```
1

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T15:26:55.186Z  

```java
import java.util.*;

public class Solution {

    static int countDigits(int n) {
        if (n < 10) {
            return 1;
        }

        return 1 + countDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(countDigits(n));
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/recursion-validating-account-numbers/problem)