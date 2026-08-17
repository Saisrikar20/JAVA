import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int classes=sc.nextInt();
        int days=sc.nextInt();
        int[][] matrix1=new int[classes][days];
        int[][] matrix2=new int[classes][days];
        
        for(int i=0;i<classes;i++){
            for(int j=0;j<days;j++){
                matrix1[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<classes;i++){
            for(int j=0;j<days;j++){
                matrix2[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<classes;i++){
            for(int j=0;j<days;j++){
                System.out.print( matrix2[i][j] + matrix1[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
