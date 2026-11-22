import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int a;
        float b;
        
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextFloat();
        if (a>13 && (b==10.15f || b==18.00f ||b==22.00f))
        System.out.print("$5.00");
        else if(b==13.30f)
        System.out.print("$2.00");
        else
        System.out.print("$2.00");
        sc.close();
    }    
}
