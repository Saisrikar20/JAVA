import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        
        if(a%100==0 && a%400==0 || a%100!=0 && a%4==0){
            System.out.print(a);
        }
        else{
            while ((a%100==0 && a%400!=0) || a%4!=0){
            a++;
            }
        System.out.print(a);
        }
        sc.close();
    }
}
