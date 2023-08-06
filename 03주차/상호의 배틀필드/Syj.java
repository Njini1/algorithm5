import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Syj {
  static int H, W, N;
  static char[][] map;
  static int x, y, d;
  static int[] dx = { -1, 1, 0, 0 }; // 위 하 좌 우
  static int[] dy = { 0, 0, -1, 1 };
 
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
 
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      st = new StringTokenizer(br.readLine(), " ");
      H = Integer.parseInt(st.nextToken()); // 높이 H
      W = Integer.parseInt(st.nextToken()); // 넓이 W
 
      // 맵의 값 받기
      map = new char[H][W];
      for (int i = 0; i < H; i++) {
        String tmp = br.readLine();
        for (int j = 0; j < W; j++) {
          map[i][j] = tmp.charAt(j);
          switch (map[i][j]) {
            case '^':
              d = 0;
              x = i;
              y = j;
              break;
            case 'v':
              d = 1;
              x = i;
              y = j;
              break;
            case '<':
              d = 2;
              x = i;
              y = j;
              break;
            case '>':
              d = 3;
              x = i;
              y = j;
              break;
          }
        }
      }
 
      N = Integer.parseInt(br.readLine());// 사용자가 넣을 입력의 개수를 나타내는 정수
      String input = br.readLine(); // 사용자가 넣을 입력
 
      for (int i = 0; i < N; i++) {
        switch (input.charAt(i)) {
          case 'U': // 위쪽
            d = 0;
            move();
            break;
          case 'D':
            d = 1;
            move();
            break;
          case 'L':
            d = 2;
            move();
            break;
          case 'R':
            d = 3;
            move();
            break;
          case 'S':
            shot();
            break;
        }
      }
 
      // 전차의 최종 목적지
      switch (d) {
        case 0:
          map[x][y] = '^';
          break;
        case 1:
          map[x][y] = 'v';
          break;
        case 2:
          map[x][y] = '<';
          break;
        case 3:
          map[x][y] = '>';
          break;
      }
 
      // 출력
      sb.append("#").append(tc).append(" ");
      for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
          sb.append(map[i][j]);
        }
        sb.append("\n");
      }
 
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
 
  private static void move() {
    int nx = x + dx[d];
    int ny = y + dy[d];
    // 범위 벗어나거나 물, 벽이면 갈 수 없음
    if (!chkRange(nx, ny) || map[nx][ny] == '*' || map[nx][ny] == '#' || map[nx][ny] == '-')
      return;
 
    // 움직임
    map[x][y] = '.';
    x = nx;
    y = ny;
  }
 
  private static void shot() {
    int nx = x;
    int ny = y;
    while (true) {
      nx += dx[d];
      ny += dy[d];
      // 범위벗어나거나 강철로 만들어진 벽 -> 아무일x
      if (!chkRange(nx, ny) || map[nx][ny] == '#')
        return;
      // 벽이 벽돌로 만들어진 벽 -> 벽은 파괴되어 칸은 평지
      if (map[nx][ny] == '*') {
        map[nx][ny] = '.';
        return;
      }
    }
  }
 
  private static boolean chkRange(int x, int y) {
    if (x < 0 || x >= H || y < 0 || y >= W)
      return false;
    return true;
  }
 
}
