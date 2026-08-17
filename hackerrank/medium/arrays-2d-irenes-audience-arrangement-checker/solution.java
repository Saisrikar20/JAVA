import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        boolean uppertri=true;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if (matrix[i][j]!=0){
                    uppertri=false;
                    break;
                }
            }
        }
        if(uppertri){
            System.out.println("Upper triangular matrix");
        }
        else{
            System.out.print("Not an Upper triangular matrix");
        }
        sc.close();
    }
}
