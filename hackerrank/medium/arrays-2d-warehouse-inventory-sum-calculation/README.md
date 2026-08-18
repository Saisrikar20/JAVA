# Arrays 2D - Warehouse Inventory Sum Calculation

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a warehouse, products are stored in a grid-like arrangement where each cell in the grid represents the quantity of a particular product in a specific section. To ensure inventory accuracy and efficient restocking, the warehouse management system needs to calculate the total quantity of products for each row and each column of the grid.

Write a program to help the warehouse staff calculate the sum of quantities for each row and each column in the grid.

 **Input Format** 

- The first line of input contains an integer n, which represents the number of rows and columns in the grid (n x n grid).
- The next n lines each contain n integers, representing the quantity of products in each cell of the grid.

 **Constraints** 

NA

 **Output Format** 

The output should include:

- The sum of each row, printed on a new line.
- The sum of each column, printed on a new line after the row sums.

 **Sample Input 0** 

```
3
2 3 4
5 6 7
8 9 10

```

 **Sample Output 0** 

```
Row sums:
9
18
27
Column sums:
15
18
21

```

 **Explanation 0** 

Input Details

The warehouse has a 3x3 grid with the quantities:

2 3 4

5 6 7

8 9 10

Row Sums

Row 1: 2 + 3 + 4 = 9

Row 2: 5 + 6 + 7 = 18

Row 3: 8 + 9 + 10 = 27

Column Sums

Column 1: 2 + 5 + 8 = 15

Column 2: 3 + 6 + 9 = 18

Column 3: 4 + 7 + 10 = 21

 **Sample Input 1** 

```
2
1 2
3 4

```

 **Sample Output 1** 

```
Row sums:
3
7
Column sums:
4
6

```

 **Explanation 1** 

Input Details

The warehouse has a 2x2 grid with the quantities:

1 2

3 4

Row Sums

Row 1: 1 + 2 = 3

Row 2: 3 + 4 = 7

Column Sums

Column 1: 1 + 3 = 4

Column 2: 2 + 4 = 6

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-18T13:05:52.375Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        int[] rowsum=new int[n];
        int[] colsum=new int[n];
        int x=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
                x=x+matrix[i][j];
            }
            rowsum[i]=x;
            x=0;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                x=x+matrix[j][i];
            }
            colsum[i]=x;
            x=0;
        }
        System.out.println("Row sums:");
        for(int i=0;i<n;i++){
            System.out.println(rowsum[i]);
        }
        System.out.println("Column sums:");
        for(int i=0;i<n;i++){
            System.out.println(colsum[i]);
        }
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/arrays-2d-warehouse-inventory-sum-calculation/problem)