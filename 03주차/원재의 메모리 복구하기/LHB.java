import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
     
    static String memory;
    static int count;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            memory = br.readLine();
            count = 0;
            int idx = 0;
            int target = 1;
            find_target(idx, target);
            System.out.printf("#%d %d\n", tc, count);
        }
    }
 
    private static void find_target(int idx, int target) {
        if (idx >= memory.length()) {
            return;
        }
        try {
            while (memory.charAt(idx) - '0' != target) {
                idx++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return;
        }
        count++;
        find_target(idx, (target + 1) % 2);
    }
 
}
