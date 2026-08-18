# Arrays 2D - Warehouse Shelf Max Quantity Finder

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a large warehouse, products are organized on a series of vertical shelves arranged in rows and columns. The warehouse manager needs to know the maximum quantity of items available in each column to make better decisions for restocking. Write a program that calculates the maximum quantity of items present in each column.

 **Input Format** 

- The first line of input contains an integer n, which represents the number of rows and columns in the grid (n x n grid).
- The next n lines each contain n integers, representing the quantity of items in each cell of the grid.

 **Constraints** 

NA

 **Output Format** 

Print the maximum quantity for each column on a new line.

 **Sample Input 0** 

```
3
5 1 9
2 8 6
7 4 3

```

 **Sample Output 0** 

```
7
8
9

```

 **Explanation 0** 

Input Details

The warehouse has a 3x3 grid representing the quantity of items:

5 1 9

2 8 6

7 4 3

Maximum Quantity in Each Column

Column 1: The values are 5, 2, and 7. The maximum is 7.

Column 2: The values are 1, 8, and 4. The maximum is 8.

Column 3: The values are 9, 6, and 3. The maximum is 9.

 **Sample Input 1** 

```
2
10 15
20 5

```

 **Sample Output 1** 

```
20
15

```

 **Explanation 1** 

Input Details

The warehouse has a 2x2 grid representing the quantity of items:

10 15

20 5

Maximum Quantity in Each Column

Column 1: The values are 10 and 20. The maximum is 20.

Column 2: The values are 15 and 5. The maximum is 15.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-18T13:34:01.434Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();       
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(max<matrix[j][i]){
                    max=matrix[j][i];
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

[View on HackerRank](https://www.hackerrank.com/challenges/arrays-2d-warehouse-shelf-max-quantity-finder/problem)