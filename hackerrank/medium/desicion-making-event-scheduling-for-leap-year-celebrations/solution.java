import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int a;
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        if (a%100==0)
        {
            if (a%400==0){
             System.out.print("Schedule Event" );
            }
            else
        {
            System.out.print("No Event This Year");
        }
        }
        else if(a%4==0){
            System.out.print("Schedule Event" );
        }
        else
        {
            System.out.print("No Event This Year");
        }
        sc.close();
    }
}
