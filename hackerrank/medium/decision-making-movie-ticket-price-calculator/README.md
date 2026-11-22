# Decision Making - Movie Ticket Price Calculator

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You work at a movie theater that offers different ticket prices for adults and children. Adults are those over 13 years of age, and the regular ticket price for an adult is 2.00. The theater runs four daily shows at the following times:

- Morning Show: 10.15
- Matinee Show: 13.30
- Evening Show: 18.00
- Night Show: 22.00

All matinee shows have a special discounted rate, where both adults and children can watch the movie for $2.00. Write a program that calculates the movie ticket price based on the customer’s age and the chosen show timing.

 **Input Format** 

- An integer input representing the customer's age.
- A floating-point number representing the show timing on a 24-hour clock.

 **Constraints** 

- Age will be a positive integer.
- Show timing will be given as a floating-point number in a 24-hour format.

 **Output Format** 

Print the price of the movie ticket in the format: $

 **Sample Input 0** 

```
10
13.30

```

 **Sample Output 0** 

```
$2.00

```

 **Explanation 0** 

The customer is 10 years old, which classifies them as a child. The chosen show timing is 13.30, which is a matinee show. Since matinee shows have a special price of 2.00.

 **Sample Input 1** 

```
19
13.30

```

 **Sample Output 1** 

```
$2.00

```

 **Explanation 1** 

The customer is 19 years old, classifying them as an adult. The chosen show timing is 13.30, which is a matinee show. Even though the regular adult ticket price is 2.00 for everyone, so the output is $2.00.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-22T06:17:30.388Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int a;
        float b;
        
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextFloat();
        if (a>13 && (b==10.15f || b==18.00f ||b==22.00f))
        System.out.print("$5.00");
        else if(b==13.30f)
        System.out.print("$2.00");
        else
        System.out.print("$2.00");
        
        
        
        
    }    
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/decision-making-movie-ticket-price-calculator/problem)