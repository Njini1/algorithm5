import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Syj {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
 
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken()); // 사람수
      int M = Integer.parseInt(st.nextToken()); // 문제수
 
      int max = 0; // 가장 많이 맞힌 문제수
      int isSolve, sovleCount; // isSolve: 0이면 문제 못맞힘, 1이면 문제맞힘 / sovleCount: 문제 맞힌 수
      int firstCount = 0; // 1등인 사람 수
      for (int i = 0; i < N; i++) {
        sovleCount = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < M; j++) {
          isSolve = Integer.parseInt(st.nextToken());
          if (isSolve == 1) {
            sovleCount++;
          }
        }
        if (sovleCount > max) {
          max = sovleCount;
          firstCount = 1;
        } else if (sovleCount == max) {
          firstCount++;
        }
      }
      System.out.println("#" + tc + " " + firstCount + " " + max);
    }
 
  }
}
