import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Syj {
  static int N;
  static int M;
  static int[] cards;
  static int result = 0;

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    cards = new int[N];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    // int result = 0;
    boolean[] visit = new boolean[N];
    combination(3, 0, visit, 0);
    System.out.println(result);
  }

  private static void combination(int r, int start, boolean[] visit, int acc) {
    if (r == 0) {
      if (acc <= M) {
        result = Math.max(result, acc);
        // System.out.println("acc: " + acc + " result: " + result);
      }
      return;
    }
    for (int s = start; s < N; s++) {
      if (!visit[s]) {
        visit[s] = true;
        if (acc + cards[s] <= M) {
          combination(r - 1, start + 1, visit, acc + cards[s]);
        }
        visit[s] = false;
      }
    }
  }
}
