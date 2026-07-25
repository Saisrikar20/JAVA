package AgeMarksCheck;

import java.util.Scanner;
class AgeMarkChecker{
    static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int age= scan.nextInt();
        int marks= scan.nextInt();
        System.out.println((age>=18)&&(marks>=60));
        scan.close();
    }
}
