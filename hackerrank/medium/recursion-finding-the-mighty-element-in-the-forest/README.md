# Recursion - Finding the Mighty Element in the Forest

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In the enchanting forest of Eldoria, the wise old owl named Orin has the unique ability to communicate with the animals. One day, Orin decided to organize a competition among the animals to find the mightiest creature based on their sizes. To do this, he devised a plan to represent the sizes of the animals in an array and asked the clever rabbit, Ruby, to help him find the largest size using a special method: recursion.

Write a program that takes an array of positive integers representing the sizes of different animals and finds the maximum size using recursion.

 **Input Format** 

- The first line contains an integer nnn (the number of animals).
- The second line contains n positive integers representing the sizes of the animals.

 **Constraints** 

- 1≤n≤1000
- Sizes are positive integers.

 **Output Format** 

Output the maximum size value from the array

 **Sample Input 0** 

```
5  
23 12 45 67 34

```

 **Sample Output 0** 

```
67

```

 **Explanation 0** 

In the array [23, 12, 45, 67, 34], the maximum size is 67, which represents the largest animal.

 **Sample Input 1** 

```
4  
2 8 1 5

```

 **Sample Output 1** 

```
8

```

 **Explanation 1** 

In the array [2, 8, 1, 5], the maximum size is 8, which represents the largest animal.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T14:47:31.557Z  

```java
import java.io.*;
import java.util.*;

public class Solution {
    
    static int findMax(int[] arr,int n){
        if(n==1){
            return arr[0];
        }
        int max =findMax(arr,n-1);
        return Math.max(arr[n-1],max);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(findMax(arr,n));
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/recursion-finding-the-mighty-element-in-the-forest/problem)