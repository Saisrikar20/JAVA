import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int total=0,k=sc.nextInt();
        
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0;i<k;i++){
            total=total+arr[i];
        }
        System.out.print(total);
    }
}
