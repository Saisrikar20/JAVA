# Arrays 2D - Robotic Warehouse Navigation - Snake Pattern Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a modern warehouse, a robot is tasked with scanning items in storage shelves arranged in a grid-like format. The robot moves in a snake-like pattern to ensure that all shelves are scanned efficiently. Specifically, the robot starts at the first row and scans from left to right, then moves to the next row and scans from right to left, and so on.

Write a program that outputs the order in which the robot scans the items in a given matrix in a snake pattern.

 **Input Format** 

- The first line contains two integers, m (number of rows) and n (number of columns).
- The next m lines contain n integers each, representing the item IDs on the storage shelves.

 **Constraints** 

- 1≤m,n≤1001 \leq m, n \leq 1001≤m,n≤100
- Item IDs are integers ranging from 111 to 100010001000.

 **Output Format** 

Print the item IDs in the order the robot scans them in a single line, separated by spaces.

 **Sample Input 0** 

```
3 4
1 2 3 4
5 6 7 8
9 10 11 12

```

 **Sample Output 0** 

```
1 2 3 4 8 7 6 5 9 10 11 12

```

 **Explanation 0** 

 **Input Matrix (Item IDs on Shelves)** 

1 2 3 4

5 6 7 8

9 10 11 12

The robot starts at the first row and moves left to right: 1 2 3 4 It then moves to the second row and scans from right to left: 8 7 6 5 Finally, it moves to the third row and scans from left to right: 9 10 11 12

 **Output** 

The order of item IDs in the snake pattern is 1 2 3 4 8 7 6 5 9 10 11 12.

 **Sample Input 1** 

```
2 3
1 2 3
4 5 6

```

 **Sample Output 1** 

```
1 2 3 6 5 4

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-17T04:17:57.950Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] matrix=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            if(i%2==0){
                for(int j=0;j<m;j++){
                    System.out.print(matrix[i][j]+" ");
                }
            }
            else{
                for(int j=m-1;j>=0;j--){
                    System.out.print(matrix[i][j]+" ");
                }
            }
        }
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/arrays-2d-robotic-warehouse-navigation-snake-pattern-traversal/problem)