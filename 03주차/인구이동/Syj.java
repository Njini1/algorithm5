import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Syj {

  static int N, L, R;
  static boolean[][] visit;
  static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
  static int[] dy = { 1, 0, -1, 0 };
  static int[][] map;
  static boolean isAllUnion = true;
  static int sum, result;

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken()); // N * N 크기의 땅
    L = Integer.parseInt(st.nextToken()); // 인구 차이 L명 이상
    R = Integer.parseInt(st.nextToken()); // 인구 차이 R명 이하

    // 나라별 인구수 값 저장
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 연합 나라 구하기
    Stack<Integer[]> union = new Stack<>();
    while (isAllUnion) {
      visit = new boolean[N][N];

      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          if (!visit[r][c]) {
            sum = map[r][c];
            union.push(new Integer[] { r, c });
            visit[r][c] = true;
            findUnion(r, c, union);
            movePeople(union);
          }
        }
      }
      // 연합인 나라가 없을 경우(true) false 값으로 바꿔서 연합 나라 구하는 것 종료
      // 인구이동을 했을 때(isAllUnion 값이 false일때) 결과값 + 1을 하고 계속 연합 나라가 있는 지 탐색위해 true로 변경
      if (!isAllUnion) {
        isAllUnion = true;
        result++;
      } else {
        isAllUnion = false;
      }
    }
    System.out.println(result);

  }

  // 인구이동이 가능한 즉 연합인 나라를 찾음
  // 현재 x y값, union: 연합인 나라의 위치 저장, sum: 연합인 나라의 인구수 합 저장
  private static void findUnion(int x, int y, Stack<Integer[]> union) {
    int nx, ny;

    for (int d = 0; d < dx.length; d++) {
      nx = x + dx[d];
      ny = y + dy[d];

      if (!chkRange(nx, ny))
        continue;
      // 방문하지 않은 곳이면 탐색
      if (!visit[nx][ny]) {
        // 인접한 두 나라의 인구수 차기가 범위 안이면
        int tmp = Math.abs(map[x][y] - map[nx][ny]);
        if (L <= tmp && tmp <= R) {
          visit[nx][ny] = true;
          union.add(new Integer[] { nx, ny });
          sum += map[nx][ny];
          findUnion(nx, ny, union);
        }
      }
    }
  }

  // 연합인 나라들의 인구를 이동
  private static void movePeople(Stack<Integer[]> union) {
    int population = sum / union.size();
    // 인구이동할 연합나라있는 경우(union값이 2이상인경우)
    if (union.size() > 1) {
      isAllUnion = false;
    }
    while (!union.isEmpty()) {
      Integer[] tmp = union.pop();
      map[tmp[0]][tmp[1]] = population;
    }
    union.clear();
  }

  private static boolean chkRange(int nx, int ny) {
    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
      return false;
    }
    return true;
  }
}
