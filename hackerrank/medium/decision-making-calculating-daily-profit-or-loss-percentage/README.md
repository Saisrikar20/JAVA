# Decision Making - Calculating Daily Profit or Loss Percentage

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Jammy and Lily run a small shop together. Each day, Jammy invests a certain amount of money, Rs. X, to set up and run the shop. At the end of the day, they calculate the total earnings, Rs. Y, from sales and other sources. Jammy asks Lily to calculate the profit or loss percentage compared to the amount invested. Your task is to write a program that takes the invested amount and the earned amount as inputs and outputs whether they made a profit or a loss, including the percentage value. However, if any input amount is negative, it should output "Invalid Input."

 **Input Format** 

- The first input corresponds to the invested amount (Integer).
- The second input corresponds to the earned amount (Integer).

 **Constraints** 

Input values must be non-negative integers; otherwise, output "Invalid Input."

 **Output Format** 

- If there is a profit, print: Profit - X%
- If there is a loss, print: Loss - X%
- If the investment and earnings are equal, print: No Profit, No Loss
- In case of negative inputs, print: Invalid Input

 **Sample Input 0** 

```
1200
1500

```

 **Sample Output 0** 

```
Profit - 25%

```

 **Explanation 0** 

The investment was Rs. 1200, and the earnings were Rs. 1500. The profit is Rs. 300, and the profit percentage is (300/1200) * 100 = 25%.

 **Sample Input 1** 

```
1500
1200

```

 **Sample Output 1** 

```
Loss - 20%

```

 **Explanation 1** 

The investment was Rs. 1500, and the earnings were Rs. 1200. The loss is Rs. 300, and the loss percentage is (300/1500) * 100 = 20%.

 **Sample Input 2** 

```
-1500
-1200

```

 **Sample Output 2** 

```
Invalid Input

```

 **Sample Input 3** 

```
1000
1000

```

 **Sample Output 3** 

```
No Profit, No Loss

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-25T21:47:41.879Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int iamt,amt;
        iamt=sc.nextInt();
        amt=sc.nextInt();
        if(amt<0 || iamt<0){
            System.out.println("Invalid Input");
        }
        else if (amt>iamt){
            System.out.println("Profit - "+(((amt-iamt)*100)/iamt)+"%");
        }
        else if (amt<iamt){
            System.out.println("Loss - "+(((iamt-amt)*100)/iamt)+"%");
        }
        else if(amt==iamt){
            System.out.println("No Profit, No Loss");
        }
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/decision-making-calculating-daily-profit-or-loss-percentage/problem)