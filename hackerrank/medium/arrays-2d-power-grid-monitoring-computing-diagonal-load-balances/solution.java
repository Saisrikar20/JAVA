import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        
        int d1=0;
        int d2=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
                if(i==j){
                    d1=d1+matrix[i][j];
                }
            }
        }
        for(int i=0;i<n;i++){
            d2=d2+matrix[i][n-1-i];
        }
        System.out.println(d1+" "+d2);
        sc.close();
    }
}
