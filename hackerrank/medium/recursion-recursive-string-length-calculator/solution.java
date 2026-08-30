import java.io.*;
import java.util.*;

public class Solution {

    static int stringLength(String str, int index) {
        if (index == str.length()) {
            return 0;
        }

        return 1 + stringLength(str, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(stringLength(str, 0));
    }
}
