import java.io.*;
import java.util.*;

public class Solution {
    
    static int findMax(int[] arr,int n){
        if(n==1){
            return arr[0];
        }
        int max =findMax(arr,n-1);
        return Math.max(arr[n-1],max);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(findMax(arr,n));
    }
}
