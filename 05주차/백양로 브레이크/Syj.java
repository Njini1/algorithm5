import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Syj{

  static int N, M, D;
  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 건물의 수
    M = Integer.parseInt(st.nextToken()); // 길의 수

    int u, v, b;
    
    map = new int[N+1][N+1];
    
    //N + 1로 초기화
    for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (i == j) {
				map[i][j] = 0;
			} else {
				map[i][j] = N + 1;
			}
		}
	}
    
    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      map[u][v] = 0;
      if (b == 0) { // 일방통행
        map[v][u] = 1;
      } else { //양방향
        map[v][u] = 0;
      }
    }

    for (int k = 1; k <= N; k++) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] > map[i][k] + map[k][j]) {
					map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
	}

    D = Integer.parseInt(br.readLine());
    for (int i = 0; i < D; i++) {
    	st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

		System.out.println(map[u][v]);
	}
    
  }

}