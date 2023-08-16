import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Syj {
  static int N, result = Integer.MAX_VALUE;
  static int[][][] map;
  static boolean[][] visit;
  static Queue<int[]> q;
  static int[] dx = { 0, 0, -1, 1 }; // 우 좌 상 하
  static int[] dy = { 1, -1, 0, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine()); // 지도 크기

    // 지도 값 받기
    map = new int[N][N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        map[i][j][0] = Integer.parseInt(st.nextToken()); // 0은 바다, 1은 육지
      }
    }

    // 섬의 그룹 매기기
    int group = 1;
    q = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        // 섬이면서 그룹넘버가 매겨지지 않았을 경우
        if (map[i][j][0] == 1 && map[i][j][1] == 0) {
          map[i][j][1] = group;
          q.add(new int[] { i, j });
          findIsland(group++);
        }
      }
    }

    // 다리 만들기
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        visit = new boolean[N][N];
        if (map[i][j][0] == 1) {
          visit[i][j] = true;
          q.add(new int[] { i, j });
          bfs(map[i][j][1]);
        }
      }
    }

    // 결과 출력
    System.out.println(result);
  }

  private static void bfs(int group) {
    int cnt = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      int nx, ny;
      for (int i = 0; i < size; i++) {
        int[] tmp = q.poll();
        int x = tmp[0];
        int y = tmp[1];
        for (int d = 0; d < 4; d++) {
          nx = x + dx[d];
          ny = y + dy[d];

          // 범위 벗어날 경우
          if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny])
            continue;
          visit[nx][ny] = true;
          // 바다일 경우
          if (map[nx][ny][0] == 0) {
            q.add(new int[] { nx, ny });
            continue;
          }
          // 다른 섬의 육지
          if (map[nx][ny][1] != group) {
            result = Math.min(result, cnt);
            break;
          }
        }
      }
      cnt++;
    }
  }

  // 섬의 그룹넘버 매기기
  private static void findIsland(int group) {
    while (!q.isEmpty()) {
      int[] tmp = q.poll();
      int x = tmp[0];
      int y = tmp[1];
      int nx, ny;
      for (int d = 0; d < 4; d++) {
        nx = x + dx[d];
        ny = y + dy[d];

        // 범위 벗어나거나 바다인 경우
        if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny][0] == 0)
          continue;

        // 바다이면서 섬의 그룹넘버가 비어있을경우
        if (map[nx][ny][1] == 0) {
          map[nx][ny][1] = group;
          q.add(new int[] { nx, ny });
        }
      }
    }
  }
}