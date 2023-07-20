
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.io.*;

public class Syj {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      int N = Integer.parseInt(br.readLine());
      int[][] farm = new int[N][N];

      // 농장 값 채우기
      for (int r = 0; r < N; r++) {
        String v = br.readLine();
        for (int c = 0; c < N; c++) {
          farm[r][c] = v.charAt(c) - '0';
        }
      }

      /*
       * 각 가로줄에서 해당 규칙만큼 더함 1 + 3 + 5 + ..+ (N / 2) + .. + 3 + 1
       * start: farm의 첫번쨰 가로줄에서 더하기 시작하는 위치
       * last: 더해야하는 마지막 숫자의 인덱스 + 1
       * count: farm의 첫번쨰 가로줄에서 더해야하는 숫자 개수
       * l
       */
      int result = 0;
      int start = N / 2;
      int last = 0;
      int count = 1;

      for (int r = 0; r < N; r++) {
        last = start + count;
        for (int s = start; s < last; s++) {
          result += farm[r][s];
        }
        // 중간행보다 위에 있는 행이면 시작인데스는 - 1하고, 더해야하는 개수는 +2
        if (r < N / 2) {
          start--;
          count += 2;
        } else {
          start++;
          count -= 2;
        }
      }
      System.out.println("#" + tc + " " + result);
    }

  }
}