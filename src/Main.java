import java.util.Scanner;
public class Main{
    static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int age= scan.nextInt();
        int marks= scan.nextInt();
        System.out.println((age>=18)&&(marks>=60));
        scan.close();
    }
}
