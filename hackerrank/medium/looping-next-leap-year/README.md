# Looping - Next Leap Year

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are an app developer, and your company wants you to develop a new feature to engage more users by showing the next nearest leap year for a given year, represented by an integer value N. Your task is to find and return an integer value representing the next nearest leap year for the given year. If the given year itself is a leap year, then return that.

 **Input Format** 

An integer value N representing the given year.

 **Constraints** 

NA

 **Output Format** 

Return an integer value representing the next nearest leap year for a given year.

 **Sample Input 0** 

```
2021

```

 **Sample Output 0** 

```
2024

```

 **Explanation 0** 

Here, the given year is 2021 and the next upcoming leap year would be 2024. Therefore, 2024 is returned as the output.

 **Sample Input 1** 

```
2008

```

 **Sample Output 1** 

```
2008

```

 **Explanation 1** 

Here, the given year is 2008, which is itself a leap year. Therefore 2008 is returned as the output.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-22T06:43:00.544Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        
        if(a%100==0 && a%400==0 || a%100!=0 && a%4==0){
            System.out.print(a);
        }
        else{
            while ((a%100==0 && a%400!=0) || a%4!=0){
            a++;
            }
        System.out.print(a);
        }
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/looping-next-leap-year/problem)