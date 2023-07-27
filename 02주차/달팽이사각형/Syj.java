import java.io.IOException;
import java.util.Scanner;

public class Syj {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    if (N < 0 || N > 101) {
      System.out.println("INPUT ERROR!");
      System.exit(0);
    }

    int[] dx = { 0, 1, 0, -1 }; // 우하좌상
    int[] dy = { 1, 0, -1, 0 };
    int x = 0, y = 0;
    int[][] map = new int[N][N];
    int count = 0;
    int value = 1;
    map[0][0] = value;

    while (value < N * N) {
      int nx = x + dx[count % 4];
      int ny = y + dy[count % 4];

      // 범위밖을 나가거나 값이 이미 있는 경우 count++에 x, y값 바꿔줌
      if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0) {
        count++;
        continue;
      }
      // 위에 해당하지 않을경우 값을 넣어줌
      map[nx][ny] = ++value;
      x = nx;
      y = ny;

    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }

}