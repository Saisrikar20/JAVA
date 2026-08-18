import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        int[] rowsum=new int[n];
        int[] colsum=new int[n];
        int x=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
                x=x+matrix[i][j];
            }
            rowsum[i]=x;
            x=0;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                x=x+matrix[j][i];
            }
            colsum[i]=x;
            x=0;
        }
        System.out.println("Row sums:");
        for(int i=0;i<n;i++){
            System.out.println(rowsum[i]);
        }
        System.out.println("Column sums:");
        for(int i=0;i<n;i++){
            System.out.println(colsum[i]);
        }
        sc.close();
    }
}
