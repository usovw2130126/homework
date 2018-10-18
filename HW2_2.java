import java.io.*;
import java.util.Scanner;

public class HW2_2 {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入n：");
       int n =sc.nextInt();

            System.out.println("費氏數列第"+n+"項數的值為"+fib(n));
        }


         public static long fib(int n){
             long num[]=new long[n];
             num[0]=1;
             if (n>1){
                num[1]=1;
                for (int i=2;i< n;i++)
                    num[i]=num[i-1]+num[i-2];
            }
            return num[n-1];
        }
    }
