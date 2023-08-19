import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Syj {
  static class Point {
    int r, c, level, cnt;

    public Point(int r, int c, int level, int cnt) {
      this.r = r;
      this.c = c;
      this.level = level;
      this.cnt = cnt;
    }

  }

  static int K, W, H, result = Integer.MAX_VALUE;
  static int[][] map;
  static Point sp, ep;
  static int[] dr = { 0, 0, -1, 1 };
  static int[] dc = { 1, -1, 0, 0 };
  static Queue<Point> q;
  static boolean[][][] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    K = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    map = new int[H][W];
    for (int i = 0; i < H; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < W; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    sp = new Point(0, 0, 0, K);
    q = new ArrayDeque<Point>();
    q.add(sp);
    visit = new boolean[H][W][K + 1];
    move();

    System.out.println(result == Integer.MAX_VALUE ? -1 : result);
  }

  private static void move() {
    int nr, nc;
    while (!q.isEmpty()) {
      Point tmp = q.poll();
      if (tmp.r == H - 1 && tmp.c == W - 1) {
        result = Math.min(result, tmp.level);
      }

      for (int d = 0; d < 4; d++) {
        nr = tmp.r + dr[d];
        nc = tmp.c + dc[d];

        if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1 || visit[nr][nc][tmp.cnt])
          continue;

        visit[nr][nc][tmp.cnt] = true;
        q.add(new Point(nr, nc, tmp.level + 1, tmp.cnt));
      }

      if (tmp.cnt != 0) {
        for (int d = 0; d < 4; d++) {
          nr = tmp.r + dr[d] * 2;
          nc = tmp.c + dc[d] * 2;

          if (nr < 0 || nr >= H || nc < 0 || nc >= W)
            continue;

          int t1, t2;
          if (d == 0 || d == 1) {
            t1 = 2;
            t2 = 4;
          } else {
            t1 = 0;
            t2 = 3;
          }
          for (int d2 = t1; d2 < t2; d2++) {
            int nr2 = nr + dr[d2];
            int nc2 = nc + dc[d2];
            if (nr2 < 0 || nr2 >= H || nc2 < 0 || nc2 >= W || map[nr2][nc2] == 1 || visit[nr2][nc2][tmp.cnt - 1])
              continue;
            visit[nr2][nc2][tmp.cnt - 1] = true;
            q.add(new Point(nr2, nc2, tmp.level + 1, tmp.cnt - 1));
          }
        }
      }
    }
  }

}
