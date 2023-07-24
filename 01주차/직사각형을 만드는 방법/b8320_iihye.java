import java.io.*;
import java.util.Scanner;

public class b8320 {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int ans = 0;

    for(int a = 1; a < n + 1; a++) { // 1 ~ n 까지
        for(int b = a; b < (n / a + 1); b++) { // a ~ (n/a+1)까지
                ans++;
            }
        }

        System.out.println(ans);
    }

}