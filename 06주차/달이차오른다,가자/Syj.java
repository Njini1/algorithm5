import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Syj {
  static class Point {
    int r, c, level, keys;

    Point(int r, int c, int level, int keys) {
      this.r = r;
      this.c = c;
      this.level = level;
      this.keys = keys;
    }
  }

  static int N, M, result;
  static char[][] map;
  static boolean[][][] visit;
  static Point sp;
  static int[] dr = { -1, 1, 0, 0 };
  static int[] dc = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // 지도 값 받기
    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = row.charAt(j);
        if (map[i][j] == '0') {
          sp = new Point(i, j, 0, 0); // 시작점
        }
      }
    }

    visit = new boolean[N][M][65]; // 어떤 키를 가지고 있는 지에 대한 방문배열
    System.out.println(move());
  }

  private static int move() {
    Queue<Point> q = new ArrayDeque<>();
    q.add(sp);

    while (!q.isEmpty()) {
      Point tmp = q.poll();

      visit[tmp.r][tmp.c][tmp.keys] = true;

      int nr, nc;
      for (int d = 0; d < 4; d++) {
        nr = tmp.r + dr[d];
        nc = tmp.c + dc[d];

        //범위를 벗어나거나 이미 해당 열쇠의 상태와 같은 상태로 해당 지점을 방문했거나 '#'일경우 다음 값으로
        if (nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc][tmp.keys] || map[nr][nc] == '#')
          continue;

        if (map[nr][nc] == '.' || map[nr][nc] == '0') { //빈칸이거나 시작점이면
          visit[nr][nc][tmp.keys] = true;
          q.add(new Point(nr, nc, tmp.level + 1, tmp.keys));
        } else if ((map[nr][nc] - 'A') >= 0 && (map[nr][nc] - 'A') <= 5) { //문이면
          int value = map[nr][nc] - 'A';
          if ((tmp.keys & (1 << value)) != 0) { //해당 키를 가지고 있다면(비트마스킹 and연산)
            visit[nr][nc][tmp.keys] = true;
            q.add(new Point(nr, nc, tmp.level + 1, tmp.keys));
          }
        } else if ((map[nr][nc] - 'a') >= 0 && (map[nr][nc] - 'a') <= 5) { //열쇠라면
          int value = map[nr][nc] - 'a';
          visit[nr][nc][tmp.keys] = true;
          q.add(new Point(nr, nc, tmp.level + 1, tmp.keys | (1 << value))); //해당 열쇠의 비트를 or연산으로 켬
        } else if (map[nr][nc] == '1') { //도착점에 도착했다면 return
          return tmp.level + 1;
        }
      }
    }
    return -1;
  }
}
