import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();       
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(max<matrix[j][i]){
                    max=matrix[j][i];
                }
            }
        System.out.println(max);
                max=0;
        }
        sc.close();
    }
}
