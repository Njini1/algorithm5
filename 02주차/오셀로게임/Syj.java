//4615. 재미있는 오셀로 게임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Syj {
  static int N, M;
  static int[][] map;
  static int x, y, value;
  static int[] dx = { -1, 1, 0, 0, -1, 1, 1, -1 }; // 상 하 좌 우 우상 우하 좌하 좌상
  static int[] dy = { 0, 0, -1, 1, 1, 1, -1, -1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= T; tc++) {
      st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      map = new int[N][N]; // B: 1, W: 2
      int mid = N / 2;

      map[mid][mid] = 2;
      map[mid - 1][mid - 1] = 2;
      map[mid - 1][mid] = 1;
      map[mid][mid - 1] = 1;

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;
        value = Integer.parseInt(st.nextToken());

        // 빈 공간이 아니면 다음 공간으로 넘어감
        if (map[x][y] != 0) {
          continue;
        }

        // 돌 놓기
        layStone(x, y);

        // 결과 출력
        int[] result = { 0, 0, 0 };
        for (int a = 0; a < N; a++) {
          for (int b = 0; b < N; b++) {
            result[map[a][b]] += 1;
          }
        }
        System.out.println("#" + tc + " " + result[1] + " " + result[2]);
      }
    }
  }

  // 범위 체크
  private static boolean chkRange(int nx, int ny) {
    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
      return false;
    }
    return true;
  }

  // 돌 놓기
  private static void layStone(int x, int y) {
    // 놓을 위치 옆에 다른 색 돌이 있는 지 확인
    for (int d = 0; d < dx.length; d++) {
      int nx = x + dx[d];
      int ny = y + dy[d];

      if (!chkRange(nx, ny)) {
        continue;
      }

      // 옆에 다른색이 있으면
      if (map[nx][ny] != 0 && value != map[nx][ny]) {
        chkBetweenStone(nx, ny, d);
      }
    }
  }

  // 사이에 있는 돌인지 확인
  private static void chkBetweenStone(int nx, int ny, int d) {
    while (true) {
      nx += dx[d];
      ny += dy[d];

      // 범위를 벗어나거나 자신의 돌 상대편 돌 0과 같은 경우(ex - 1 2 0)
      if (!chkRange(nx, ny) || map[nx][ny] == 0) {
        return;
      }

      // 돌을 놓을 위치와 자신의 돌 사이에 상대편 돌이 있을 경우
      if (map[nx][ny] == value) {
        // 사이에 있는 돌을 value로 바꿈
        while ((nx != x) || (ny != y)) {
          nx -= dx[d];
          ny -= dy[d];
          map[nx][ny] = value;
        }
        return;
      }
      // 사이에 있는 돌이 여러개인 경우 계속 탐색
    }
  }
}
