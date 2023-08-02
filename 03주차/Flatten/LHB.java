import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int[] boxes = new int[100];
    static int N;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
            }
            System.out.printf("#%d %d\n", test_case, dump(1));
        }
    }
     
    public static int dump(int num) {
        int min_v = 101;
        int max_v = 0;
        int min_idx = -1;
        int max_idx = -1;
        for (int i = 0; i < 100; i++) {
            if (boxes[i] < min_v) {
                min_v = boxes[i];
                min_idx = i;
            }
            if (boxes[i] > max_v) {
                max_v = boxes[i];
                max_idx = i;
            }
        }
        //basis
        if (num > N || max_v - min_v <= 1) 
            return max_v - min_v;
        //inductive
        boxes[min_idx]++;
        boxes[max_idx]--;
        return dump(num + 1);
    }
 
}
