import java.io.*;
import java.util.*;

public class Solution {
    static int findMiddle(int[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                count++;
            }
        }
        if(count==0){
            return -1;
        }
        int mid =count/2;
        int positivecount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                if(positivecount==mid){
                    return arr[i];
                }
                positivecount++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(findMiddle(arr));
        sc.close();
    }
}
