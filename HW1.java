import java.util.Scanner;

//質數判斷
public class HW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String sr = "是質數";
        for (int i=2;i<n;i++){
            if (n%i==0){
                sr = "不是質數";
            }
        }
        System.out.println(sr);
    }
}
