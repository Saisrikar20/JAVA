# Arrays 2D - Counting Sorted Production Lines

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a manufacturing plant, items produced in assembly lines are arranged in rows for quality control. Each row represents a production line, and each item in the row has a quality score. The plant's quality assurance team needs to identify how many production lines have items sorted in non-decreasing order based on their quality scores.

Write a program that counts the number of rows in the matrix that are sorted in non-decreasing order.

 **Input Format** 

- The first line contains two integers, m (number of rows) and n (number of columns).
- The next m lines contain n integers each, representing the quality scores of items in each production line.

 **Constraints** 

- 1≤m,n≤100
- The quality scores are integers ranging from −1000 to 1000.

 **Output Format** 

Print the total count of rows that are sorted in non-decreasing order.

 **Sample Input 0** 

```
4 5
10 20 30 40 50
15 10 5 0 -5
5 5 6 7 8
9 11 10 13 14

```

 **Sample Output 0** 

```
2

```

 **Explanation 0** 

Input Matrix (Quality Scores of Items in Production Lines)

10 20 30 40 50 -> Sorted

15 10 5 0 -5 -> Not sorted

5 5 6 7 8 -> Sorted

9 11 10 13 14 -> Not sorted

The 1st and 3rd rows are sorted in non-decreasing order, so the output is 2.

Output

The program counts the rows where quality scores are sorted in non-decreasing order.

 **Sample Input 1** 

```
3 4
1 2 3 4
5 4 3 2
7 8 8 9

```

 **Sample Output 1** 

```
2

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-17T14:54:23.860Z  

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
        int ans=n;
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j-1]>matrix[i][j]){
                    ans--;
                    break;
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/arrays-2d-counting-sorted-production-lines/problem)