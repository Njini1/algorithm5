	
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Syj {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
 
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      int N = Integer.parseInt(br.readLine());
 
      Integer[] input = new Integer[N];
      int sum = 0;
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        input[j] = Integer.parseInt(st.nextToken());
        sum += input[j];
      }
 
      Arrays.sort(input, Collections.reverseOrder());
      for (int i = 0; i < N / 3; i++) {
        sum -= input[2 + i * 3];
      }
      System.out.printf("#%d %d\n", tc, sum);
    }
  }
}
