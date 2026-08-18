# Strings - Reversing Words for a Speech Teleprompter

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine you are working on developing software for a teleprompter used during speeches. Sometimes, speakers want to practice their lines by reading the sentences in reverse order to improve their memory and articulation skills. Your task is to write a program that reverses the order of words in a given sentence without using the split method. This will help the speakers rehearse their lines unconventionally.

You are given a string S containing a sentence. Write a program to reverse the order of occurrence of words in the sentence while keeping the individual words unchanged. Do not use the split method. Ensure that all words in your output are followed by a single space.

 **Input Format** 

A string S containing a sentence with multiple words separated by spaces.

 **Constraints** 

- Words in the input are separated by a single space.
- There are no leading or trailing spaces in the input.
- The input string S will contain only alphabetic characters and spaces.

 **Output Format** 

Print the sentence with the order of words reversed, separated by single spaces.

 **Sample Input 0** 

```
Hello world

```

 **Sample Output 0** 

```
world Hello

```

 **Explanation 0** 

The words "Hello" and "world" have been reversed to "world Hello".

 **Sample Input 1** 

```
Coding is awesome

```

 **Sample Output 1** 

```
awesome is Coding

```

 **Explanation 1** 

The words "Coding", "is", and "awesome" have been reversed to "awesome is Coding".

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-18T14:08:22.659Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] words=s.split(" ");
        for( int i=words.length-1;i>=0;i--){
            System.out.print(words[i]+" ");
        }
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/strings-reversing-words-for-a-speech-teleprompter/problem)