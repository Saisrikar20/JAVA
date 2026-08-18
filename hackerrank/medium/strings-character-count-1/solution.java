import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();
        int[] count=new int[26];
        for(char ch: word.toCharArray()){
            count[ch-'a']++;
        }
        int max=0;
        for(int i=0;i<26;i++){
            if(count[i]>max){
                max=count[i];
            }
        }
        System.out.println(max);
    }
}
