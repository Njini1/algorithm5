import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Syj {
  static int N, result;
  static int[][] eggs;
  static boolean isBroken;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    eggs = new int[N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      eggs[i][0] = Integer.parseInt(st.nextToken());
      eggs[i][1] = Integer.parseInt(st.nextToken());
    }

    hitEgg(0, 0);
    System.out.println(result);
  }

  private static void hitEgg(int idx, int cnt) {
    if (idx == N) {
      result = Math.max(result, cnt);
      return;
    }
    if (eggs[idx][0] <= 0) {
      hitEgg(idx + 1, cnt);
      return;
    }

    isBroken = true;
    for (int j = 0; j < N; j++) {
      if (idx == j)
        continue;

      if (eggs[j][0] > 0) {
        isBroken = false;
        eggs[idx][0] -= eggs[j][1];
        eggs[j][0] -= eggs[idx][1];
        if (eggs[idx][0] <= 0 && eggs[j][0] <= 0) {
          hitEgg(idx + 1, cnt + 2);
        } else if (eggs[idx][0] <= 0 || eggs[j][0] <= 0) {
          hitEgg(idx + 1, cnt + 1);
        } else {
          hitEgg(idx + 1, cnt);
        }
        eggs[idx][0] += eggs[j][1];
        eggs[j][0] += eggs[idx][1];
      }
    }
    if (isBroken) {
      hitEgg(N, cnt);
    }
  }
}
