import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        int[] alphabet = {2, 3, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1};
        for(int test_case = 1; test_case <= T; test_case++) {
            String str1 = sc.next();
            String str2 = sc.next();
             
            if (str1.length() != str2.length()) {
                System.out.printf("#%d DIFF\n", test_case);
                continue;
            }
             
            boolean isSame = true;
            for (int i = 0; i < str1.length(); i++) {
                int alpha1 = alphabet[str1.charAt(i) - 'A'];
                int alpha2 = alphabet[str2.charAt(i) - 'A'];
                if (alpha1 != alpha2) {
                    isSame = false;
                    break;
                }
            }
             
            if (isSame) System.out.printf("#%d SAME\n", test_case);
            else System.out.printf("#%d DIFF\n", test_case);
        }
    }
}