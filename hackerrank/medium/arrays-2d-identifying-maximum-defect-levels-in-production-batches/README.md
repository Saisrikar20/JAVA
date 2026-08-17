# Arrays 2D - Identifying Maximum Defect Levels in Production Batches

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a manufacturing unit, a quality control team is tasked with monitoring defect levels across multiple production batches. The defect levels for each item in a batch are recorded in a matrix format, where each row represents a production batch and each column represents the defect level of an item within that batch.

The quality control team needs to find the maximum defect level in each production batch to identify the most defective item in each batch. Write a program to help them identify the maximum defect levels for all production batches.

 **Input Format** 

- The first line contains two integers, m (number of production batches) and n (number of items in each batch).
- The next m lines contain n integers each, representing the defect levels of items in each batch.

 **Constraints** 

NA

 **Output Format** 

Output m integers, each representing the maximum defect level in the corresponding production batch.

 **Sample Input 0** 

```
3 4
5 3 8 6
2 9 4 7
1 6 3 8

```

 **Sample Output 0** 

```
8
9
8

```

 **Explanation 0** 

Input Matrix (Defect Levels)

Copy code

5 3 8 6

2 9 4 7

1 6 3 8

Batch 1: The maximum defect level is 8.

Batch 2: The maximum defect level is 9.

Batch 3: The maximum defect level is 8.

Output

The program outputs the maximum defect level for each batch, which helps the quality control team quickly assess the severity of defects in each batch.

 **Sample Input 1** 

```
2 3
1 2 3
4 5 6

```

 **Sample Output 1** 

```
3
6

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-17T14:34:52.700Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int max=0;
        
        int[][] matrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(max<matrix[i][j]){
                    max=matrix[i][j];
                }
            }
            System.out.println(max);
            max=0;
        }
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/arrays-2d-identifying-maximum-defect-levels-in-production-batches/problem)