# Looping - Coding Marathon

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

N number of people participated in a coding marathon where they were asked to solve some problems. Each problem carried 1 mark and at the end of the marathon, the total marks that each person achieved was calculated.

As an organizer, you have the list of the total marks that each person achieved. You have to calculate the sum of the marks of top K scorers from the list.

 **Input Format** 

- An integer N representing the number of participants.
- An integer K representing the number of top scorers to consider.
- A space-separated list of N integers representing the marks of each participant.

 **Constraints** 

NA

 **Output Format** 

A single integer representing the sum of the marks of the top K scorers.

 **Sample Input 0** 

```
4
2
4 1 2 5

```

 **Sample Output 0** 

```
9

```

 **Explanation 0** 

Top 2 scores are 5 and 4. Sum = 5+4 = 9.

 **Sample Input 1** 

```
4
3
4 3 6 1

```

 **Sample Output 1** 

```
13

```

 **Explanation 1** 

Top 3 scores are 6, 4 and 3. Sum = 6+4+3 = 13.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-22T07:06:12.193Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int total=0,k=sc.nextInt();
        
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0;i<k;i++){
            total=total+arr[i];
        }
        System.out.print(total);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/looping-coding-marathon/problem)