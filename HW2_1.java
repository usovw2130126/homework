import java.io.*;
import java.util.Scanner;

public class HW2_1 {
    public static void main(String args[])throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入n：");
        int m=Integer.parseInt(sc.nextLine());
        System.out.println("費氏數列第"+m+"項數的值為"+fib(m));
    }
    public static long fib(int n){
        if(n==1)
            return 1;
        else if (n==2)
            return 1;
        else
            return fib(n-1)+fib(n-2);
    }
}
