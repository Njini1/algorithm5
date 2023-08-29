import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Syj {
  static int N, result;
  static int[][] map;
  static int[] dx = { 0, 1, 1 };
  static int[] dy = { 1, 1, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    move(0, 1, 0);
    System.out.println(result);
  }

  private static void move(int x, int y, int status) {
    if (x == N - 1 && y == N - 1) {
      result++;
      return;
    }

    if (status == 0) {
      check(x, y, 0, 2);

    } else if (status == 1) {
      check(x, y, 0, 3);

    } else {
      check(x, y, 1, 3);
    }
  }

  private static void check(int x, int y, int sd, int ed) {
    int nx, ny;
    for (int d = sd; d < ed; d++) {
      nx = x + dx[d];
      ny = y + dy[d];

      if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 1)
        continue;
      if (d == 1 && (x + 1 >= N || map[x + 1][y] == 1 || y + 1 >= N || map[x][y + 1] == 1))
        continue;
      move(nx, ny, d);
    }
  }
}
