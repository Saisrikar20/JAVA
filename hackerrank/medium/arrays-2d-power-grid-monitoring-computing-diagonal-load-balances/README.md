# Arrays 2D - Power Grid Monitoring - Computing Diagonal Load Balances

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a power distribution center, the load levels are monitored and recorded in a grid-like structure to analyze how power is being distributed across different regions. The grid is represented as an n×n matrix, where each element represents the load level at a specific point in the grid.

The engineers are interested in efficiently calculating the sum of load levels along the two main diagonals:

- Primary diagonal: From the top-left to the bottom-right.
- Secondary diagonal: From the top-right to the bottom-left.

Write a program to compute the sum of the load levels along both diagonals.

 **Input Format** 

- The first line contains a single integer, n(the size of the square matrix).
- The next nnn lines contain nnn integers each, representing the load levels in the grid.

 **Constraints** 

NA

 **Output Format** 

Print two integers: the sum of the primary diagonal and the sum of the secondary diagonal, separated by a space.

 **Sample Input 0** 

```
3
5 2 3
8 6 4
1 9 7

```

 **Sample Output 0** 

```
18 10

```

 **Explanation 0** 

Input Matrix (Load Levels):

5 2 3

8 6 4

1 9 7

Primary Diagonal: 5+6+7=18

Secondary Diagonal: 3+6+1=10 Output

The program outputs 18 10, which represents the sum of the primary and secondary diagonals, respectively.

 **Sample Input 1** 

```
4
10 2 3 4
5 11 6 7
8 9 12 13
14 15 16 17

```

 **Sample Output 1** 

```
50 33

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-17T15:05:12.082Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        
        int d1=0;
        int d2=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
                if(i==j){
                    d1=d1+matrix[i][j];
                }
            }
        }
        for(int i=0;i<n;i++){
            d2=d2+matrix[i][n-1-i];
        }
        System.out.println(d1+" "+d2);
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/arrays-2d-power-grid-monitoring-computing-diagonal-load-balances/problem)