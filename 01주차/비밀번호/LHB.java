import java.util.Scanner;
import java.io.FileInputStream;
  
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
  
        for(int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();
            String str = sc.next();
             
            for (int i = 0; i < N - 1; i++) {
                char first = str.charAt(i);
                char second = str.charAt(i + 1);
                if (first == second) {
                    str = str.substring(0, i) + str.substring(i + 2);
                    if (i > 1) i -=2;
                    else i = -1;
                    N -= 2;
                }
            }
            System.out.println("#" + test_case + " " + str);
        }
    }
}