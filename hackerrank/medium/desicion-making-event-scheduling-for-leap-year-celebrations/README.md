# Decision Making - Event Scheduling for Leap Year Celebrations

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a city, special events are scheduled every leap year to celebrate community milestones. Event organizers need a program that can help them identify whether a given year is a leap year, so they can schedule their events accordingly. If the year is a leap year, the program should notify the organizers to "Schedule Event"; otherwise, it should inform them "No Event This Year."

Write a program to determine if a given year is a leap year. If it is, print "Schedule Event"; otherwise, print "No Event This Year."

A year is considered a leap year if:

- It is divisible by 4,
- If it is a century year (i.e., divisible by 100), it must also be divisible by 400.

 **Input Format** 

A single integer representing the year.

 **Constraints** 

NA

 **Output Format** 

- Output "Schedule Event" if the year is a leap year.
- Output "No Event This Year" if it is not a leap year.

 **Sample Input 0** 

```
2024

```

 **Sample Output 0** 

```
Schedule Event

```

 **Explanation 0** 

The year 2024 is divisible by 4 and not a century year, so it is a leap year.

 **Sample Input 1** 

```
2023

```

 **Sample Output 1** 

```
No Event This Year

```

 **Explanation 1** 

The year 2023 is not divisible by 4, so it is not a leap year.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-22T05:50:49.194Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int a;
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        if (a%100==0)
        {
            if (a%400==0){
             System.out.print("Schedule Event" );
            }
            else
        {
            System.out.print("No Event This Year");
        }
        }
        else if(a%4==0){
            System.out.print("Schedule Event" );
        }
        else
        {
            System.out.print("No Event This Year");
        }
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/desicion-making-event-scheduling-for-leap-year-celebrations/problem)