import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            Integer[] clothes = new Integer[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                clothes[i] = Integer.parseInt(st.nextToken());
            }
             
            Arrays.sort(clothes, (o1, o2) -> {return o2 - o1;});
            int sum = 0;
            for (int i = 0; i < N / 3; i++) {
                sum += clothes[i * 3];
                sum += clothes[i * 3 + 1];
            }
            if (N % 3 == 2) {
                sum += clothes[N - 1];
                sum += clothes[N - 2];
            } else if (N % 3 == 1) {
                sum += clothes[N - 1];
            }
            System.out.printf("#%d %d\n", tc, sum);
        }
    }
 
}
