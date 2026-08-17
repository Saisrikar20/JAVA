# Array 2D - Security Camera Image Processing System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A security system captures images of an area in a binary format using a grid of pixels, where 1 represents a white pixel (presence of light) and 0 represents a black pixel (absence of light). The images are used to monitor and analyze the area for unusual activity.

However, to simplify the analysis, the system needs to process each image in two steps:

- Flip the Image Horizontally: Reverse each row of the image.
- Invert the Image: Replace each 0 with 1 and each 1 with 0.

Write a program to process the images using the described operations and return the modified images.

 **Input Format** 

- The first line contains an integer n, representing the dimensions of the square image matrix.
- The next n lines contain n binary integers (0 or 1) each, representing the pixel values of the image.

 **Constraints** 

NA

 **Output Format** 

Output the modified image matrix after flipping and inverting.

 **Sample Input 0** 

```
3
1 1 0
1 0 1
0 0 0

```

 **Sample Output 0** 

```
1 0 0
0 1 0
1 1 1

```

 **Explanation 0** 

Original Image

1 1 0

1 0 1

0 0 0

Step 1 - Flip Horizontally

Row 1: [1, 1, 0] -> [0, 1, 1]

Row 2: [1, 0, 1] -> [1, 0, 1]

Row 3: [0, 0, 0] -> [0, 0, 0]

Result after flipping:

0 1 1

1 0 1

0 0 0

Step 2 - Invert

Row 1: [0, 1, 1] -> [1, 0, 0]

Row 2: [1, 0, 1] -> [0, 1, 0]

Row 3: [0, 0, 0] -> [1, 1, 1]

Result after inverting:

1 0 0

0 1 0

1 1 1

 **Sample Input 1** 

```
2
1 0
0 1

```

 **Sample Output 1** 

```
1 0 
0 1 

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-17T16:42:27.782Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int[][] matrix=new int[n][n];
        
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            int left=0;
            int right=n-1;
            while(left<=right){
                int temp=matrix[i][left];
                matrix[i][left]=1-matrix[i][right];
                matrix[i][right]=1-temp;
                left++;
                right--;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/arrays-2d-security-camera-image-processing-system/problem)