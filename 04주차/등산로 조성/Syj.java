import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Syj {

  static int N, K;
  static boolean[][] visit;
  static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
  static int[] dy = { 1, 0, -1, 0 };
  static int[][] map;
  static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken()); // 지도의 한 변의 길이
      K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이

      // 봉우리 높이 값 저장
      map = new int[N][N];
      int sp = 0; // 가장 높은 봉우리, 시작점
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
          sp = Math.max(map[i][j], sp);
        }
      }

      // 등산로 구하기
      result = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] == sp) {
            visit = new boolean[N][N];
            visit[i][j] = true;
            dfs(i, j, false, 1);
          }
        }
      }
      // 결과값 출력
      System.out.printf("#%d %d\n", tc, result);
    }
  }

  // x, y값, flag: 봉우리 깍은 지 여부, cnt: 등산한 거리의 값
  private static void dfs(int x, int y, boolean flag, int cnt) {
    result = Math.max(result, cnt);
    int nx, ny;
    for (int d = 0; d < 4; d++) {
      nx = x + dx[d];
      ny = y + dy[d];

      // 범위 벗어나거나 방문한 곳이면
      if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny])
        continue;

      // 이전에 간 봉우리가 현재의 봉우리보다 클 경우
      visit[nx][ny] = true;
      if (map[x][y] > map[nx][ny]) {
        dfs(nx, ny, flag, cnt + 1);
      } else {
        // 이전에 간 봉우리보다 현재의 봉우리가 크거나 같을 경우 지형을 깎음
        int diff = map[nx][ny] - map[x][y];
        if (diff < K && flag == false) {
          // 이전에 간 봉우리와 현재의 봉우리의 차이가 K보다 작으면 깎음
          map[nx][ny] = map[nx][ny] - diff - 1; // 지형깎음
          dfs(nx, ny, true, cnt + 1);
          map[nx][ny] += diff + 1; // 원래값으로 복귀
        }
      }
      visit[nx][ny] = false;
    }
  }
}