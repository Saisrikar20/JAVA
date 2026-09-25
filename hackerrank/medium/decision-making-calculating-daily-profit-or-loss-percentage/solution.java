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
