# Strings - Character Count 1

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Mario wants to determine whether any letter in a given word is repeated more than three times. If any letter appears more than three times, Mario should discard the word. Write a program that takes a single word as input and outputs the highest number of times any letter appears within that word. If this count exceeds three, Mario can discard the word.

 **Input Format** 

A single string value consisting of lowercase alphabets (a-z).

 **Constraints** 

The input string will only contain lowercase alphabets: str = {a-z}.

 **Output Format** 

A positive integer representing the highest number of times any letter appears in the input word.

 **Sample Input 0** 

```
trumpet

```

 **Sample Output 0** 

```
2

```

 **Explanation 0** 

- The word "trumpet" has the letter 't' repeated 2 times, and all other letters appear only once.
- The highest number of repeating letters is 2.

 **Sample Input 1** 

```
reiterate

```

 **Sample Output 1** 

```
3

```

 **Explanation 1** 

- The word "reiterate" has the letter 'e' repeated 3 times, and other letters appear once or twice.
- The highest number of repeating letters is 3.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-18T13:51:54.610Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();
        int[] count=new int[26];
        for(char ch: word.toCharArray()){
            count[ch-'a']++;
        }
        int max=0;
        for(int i=0;i<26;i++){
            if(count[i]>max){
                max=count[i];
            }
        }
        System.out.println(max);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/strings-character-count-1/problem)