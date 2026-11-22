import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int a;
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        if (a>0)
        System.out.print("Safe for outdoor activities");
        else
        System.out.print("Too cold for outdoor activities");
        sc.close();
    }
}
