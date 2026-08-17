import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] matrix=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int ans=n;
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j-1]>matrix[i][j]){
                    ans--;
                    break;
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
