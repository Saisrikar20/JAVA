
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int product = 1;

        if(n == 2) {
            product = 1;
        }
        else if(n == 3) {
            product = 2;
        }
        else {
            while(n > 4) {
                product *= 3;
                n -= 3;
            }
            product *= n;
        }

        System.out.print(product);
        sc.close();
    }
}
