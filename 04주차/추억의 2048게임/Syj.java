import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Syj {
  static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
  static int[] dc = { 0, 0, -1, 1 };
  static int N;
  static int[][] map, result;
  static Queue<Integer> s1 = new ArrayDeque<>();
  static Queue<Integer> s2 = new ArrayDeque<>();
 
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
 
int T = Integer.parseInt(br.readLine());
for (int tc = 1; tc <= T; tc++) {
  st = new StringTokenizer(br.readLine());
  N = Integer.parseInt(st.nextToken()); //정사각형 크기
  String d = st.nextToken(); //up down left right
 
  // 2048 게임 값 받기
  map = new int[N][N];
  for (int i = 0; i < N; i++) {
    st = new StringTokenizer(br.readLine());
    for (int j = 0; j < N; j++) {
      map[i][j] = Integer.parseInt(st.nextToken());
    }
  }
 //입력된 방향으로 움직임
  result = new int[N][N];
  switch (d) {
    case "up":
      moveUp();
      break;
    case "down":
      moveDown();
      break;
    case "left":
     moveLeft();
      break;
    case "right":
      moveLight();
      break;
  }
   
//출력
  sb.append("#").append(tc).append("\n");
  for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
          sb.append(result[i][j]).append(" ");
      }
      sb.append("\n");
  }
}
bw.write(sb.toString());
bw.flush();
  }
 
/*k: 움직일 방향이 row인지 column인지 0일때는 row, 1일때는 column
 * add: row나 column을 어디 방향으로 옮길지 1이면 증가하는 방향(오른쪽, 아래), -1이면 감소하는 방향(왼쪽, 위)
  */
private static void oneLineChange(int k, int row, int column, int add) {
    while (!s1.isEmpty()) {
      Integer tmp = s1.poll();
      // s2에 비어있다면 -> 합칠 것이 없음 -> s1에서 뺴서 s2로 넣어줌
      if (tmp.equals(0))
        continue;
      if (s2.isEmpty()) {
        s2.add(tmp);
        continue;
      }
      // s2의 마지막 값과 s1에서 뽑아낸 값이 같음 -> 합칠 수 있음
      if (s2.peek().equals(tmp)) {
          result[row][column] = tmp * 2;
        s2.poll();
      } else {
        // s2의 마지막 값과 s1에서 뽑아낸 값이 다름
          result[row][column] = s2.poll();
        s2.add(tmp);
      }
      if (k == 0) {
          row += add;         
      } else {
          column += add;                  
      }
    }
    if (!s2.isEmpty()) {
        result[row][column] = s2.poll();
    }
  }
 
  private static void moveUp() {
 
// N만큼 돌림
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        s1.add(map[j][i]); // 열 한줄씩 검사
      }
      oneLineChange(0, 0, i, 1);
        }
     }
   
  private static void moveDown() {
      for (int i = 0; i < N; i++) {
          for (int j = N-1; j >= 0; j--) {
            s1.add(map[j][i]); // 열 한줄씩 검사
          }
          oneLineChange(0, N - 1, i, -1);
        }
         }
  private static void moveLight() {
      for (int i = 0; i < N; i++) {
        for (int j = N-1; j >= 0; j--) {
            s1.add(map[i][j]);
        }
        oneLineChange(1, i, N - 1, -1);
    }
  }
   
  private static void moveLeft() {
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
              s1.add(map[i][j]);
          }
          oneLineChange(1, i, 0, 1);
      }
  }
}
