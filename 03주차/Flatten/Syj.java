import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Syj {
  static int[] box = new int[100];
  static int N;
 
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int result = 0;
 
    for (int tc = 1; tc <= 10; tc++) {
      N = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < 100; i++) {
        box[i] = Integer.parseInt(st.nextToken());
      }
 
      Arrays.sort(box);
      for (int i = 0; i < N; i++) {
        box[box.length - 1]--;
        box[0]++;
        Arrays.sort(box);
        result = box[box.length - 1] - box[0];
        if (result <= 1) {
          break;
        }
      }
      System.out.println("#" + tc + " " + result);
    }
 
  }
 
}
