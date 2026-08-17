# Arrays 2D - Image Rotation Feature

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine a photo editing application that allows users to edit and manipulate images. One of the features of this application is to rotate an image by 90 degrees clockwise. The image is represented as an n x n 2D matrix, where each element is a pixel value. Write a program to implement this feature and rotate the image in-place, meaning you have to modify the input matrix directly without using extra space.

 **Input Format** 

The first line contains an integer n, representing the dimensions of the square image matrix. The next n lines contain n integers each, representing the pixel values of the image.

 **Constraints** 

NA

 **Output Format** 

Output the rotated image matrix.

 **Sample Input 0** 

```
3
1 2 3
4 5 6
7 8 9

```

 **Sample Output 0** 

```
7 4 1
8 5 2
9 6 3

```

 **Explanation 0** 

The original image matrix is:

1 2 3

4 5 6

7 8 9

After rotating the image by 90 degrees clockwise, the updated matrix becomes:

7 4 1

8 5 2

9 6 3

 **Sample Input 1** 

```
2
1 2
3 4

```

 **Sample Output 1** 

```
3 1
4 2

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-17T15:29:54.735Z  

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = a[i][left];
                a[i][left] = a[i][right];
                a[i][right] = temp;

                left++;
                right--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);

                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/arrays-2d-image-rotation-feature/problem)