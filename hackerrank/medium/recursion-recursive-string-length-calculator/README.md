# Recursion - Recursive String Length Calculator

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a digital document management system, each document is represented as a string. As part of the system's features, you need to determine the length of a string using a recursive approach. This feature is essential for efficient document analysis without relying on built-in methods.

Your task is to write a program that calculates the length of a given string using recursion.

 **Input Format** 

A single string S representing the content of the document.

 **Constraints** 

NA

 **Output Format** 

An integer representing the length of the string.

 **Sample Input 0** 

```
hello

```

 **Sample Output 0** 

```
5

```

 **Explanation 0** 

The string "hello" has 5 characters, so the output is 5.

 **Sample Input 1** 

```
recursion

```

 **Sample Output 1** 

```
9

```

 **Explanation 1** 

The string "recursion" has 9 characters, so the output is 9.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-30T15:14:29.151Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    static int stringLength(String str, int index) {
        if (index == str.length()) {
            return 0;
        }

        return 1 + stringLength(str, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(stringLength(str, 0));
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/recursion-recursive-string-length-calculator/problem)