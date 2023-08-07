import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] scores = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += Integer.parseInt(st.nextToken());
                }
                scores[i] = sum;
            }
             
            Arrays.sort(scores);
            int count = 1;
            for (int i = N - 1; i > 0; i--) {
                if (scores[i] == scores[i - 1])
                    count++;
                else break;
            }
                         
            System.out.printf("#%d %d %d\n", tc, count, scores[N - 1]);
        }
    }
 
}
