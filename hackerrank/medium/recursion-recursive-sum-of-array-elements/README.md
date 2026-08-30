# Recursion - Recursive Sum of Array Elements

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a digital library, the system maintains an array of book ratings to analyze the popularity of books. You are tasked with implementing a feature that calculates the total sum of ratings using recursion. This feature will help in the dynamic calculation of total ratings without using traditional iteration methods, enhancing the system's ability to process large data sets efficiently.

Write a program to calculate the sum of elements in an array using recursion.

 **Input Format** 

- A single integer N representing the number of elements in the array.
- An array of N integers representing the ratings of the books in the library.

 **Constraints** 

NA

 **Output Format** 

A single integer representing the sum of the array elements.

 **Sample Input 0** 

```
5
1 3 2 4 5

```

 **Sample Output 0** 

```
15

```

 **Explanation 0** 

The sum of the array elements [1, 3, 2, 4, 5] is 1 + 3 + 2 + 4 + 5 = 15.

 **Sample Input 1** 

```
3
7 8 10

```

 **Sample Output 1** 

```
25

```

 **Explanation 1** 

The sum of the array elements [7, 8, 10] is 7 + 8 + 10 = 25.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T15:19:36.236Z  

```java
import java.util.*;

public class Solution {

    static int sumArray(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }

        return arr[index] + sumArray(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(sumArray(arr, 0));
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/recursion-recursive-sum-of-array-elements/problem)