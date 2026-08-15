# Arrays 1D - Finding the Median of Positive Product IDs

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are managing an inventory system, and you have an array of product IDs. Some of the IDs may be negative, which indicates a faulty product that should be ignored. You need to determine the product ID at the middle of the list, but only considering the positive product IDs. If there are two mid indices after ignoring the negative IDs, you are required to return the element at the larger index.

Write a function to find and return the product ID at the mid index from the list of positive product IDs, ignoring all negative IDs. If there are two mid indices, return the product ID at the larger index.

 **Input Format** 

- The first line contains an integer n, representing the number of product IDs.
- The second line contains n integers, representing the product IDs. These can include both positive and negative numbers.

Assumptions

- The array will have at least one positive number.
- If there are two mid indices after ignoring negative numbers, return the one at the smaller index.

 **Constraints** 

NA

 **Output Format** 

- Print the product ID located at the mid-index of the array after ignoring all negative product IDs.

 **Sample Input 0** 

```
6
11 23 -3 3 -5 -32

```

 **Sample Output 0** 

```
23

```

 **Explanation 0** 

After removing negative numbers from the array, the positive product IDs are {11, 23, 3}. The middle product ID is 23, which is the mid index of the filtered array.

 **Sample Input 1** 

```
5
-10 -20 -30 -40 -50

```

 **Sample Output 1** 

```
-1

```

 **Explanation 1** 

- All values are negative, so positiveCount=0
- Your code checks for this and returns -1 when there are no positive product IDs.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-15T14:59:19.517Z  

```java
import java.io.*;
import java.util.*;

public class Solution {
    static int findMiddle(int[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                count++;
            }
        }
        if(count==0){
            return -1;
        }
        int mid =count/2;
        int positivecount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                if(positivecount==mid){
                    return arr[i];
                }
                positivecount++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(findMiddle(arr));
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/arrays-1d-finding-the-median-of-positive-product-ids/problem)