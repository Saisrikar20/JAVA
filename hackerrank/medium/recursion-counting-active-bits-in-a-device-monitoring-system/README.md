# Recursion - Counting Active Bits in a Device Monitoring System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine a device monitoring system that tracks the state of sensors in a factory. Each sensor is either active or inactive, and the state of all sensors is represented by a binary number. If a sensor is active, its corresponding bit is set to 1; otherwise, it is set to 0. To monitor the overall activity in the factory, you are required to count the number of active sensors (set bits) using a recursive approach.

Write a recursive function int countSetBits(int number) that takes an integer number (representing the state of the sensors in binary form) and returns the count of set bits in the binary representation of number.

 **Input Format** 

A single integer number.

 **Constraints** 

0≤number≤10^6

 **Output Format** 

An integer representing the count of set bits.

 **Sample Input 0** 

```
13

```

 **Sample Output 0** 

```
3

```

 **Explanation 0** 

The binary representation of 13 is 1101, which has three set bits (1s). Therefore, the output is 3.

 **Sample Input 1** 

```
8

```

 **Sample Output 1** 

```
1

```

 **Explanation 1** 

The binary representation of 8 is 1000, which has one set bit (1). Therefore, the output is 1.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T15:04:16.137Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    static int countSetBits(int number) {
        if (number == 0) {
            return 0;
        }

        return (number % 2) + countSetBits(number / 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        System.out.println(countSetBits(number));
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/recursion-counting-active-bits-in-a-device-monitoring-system/problem)