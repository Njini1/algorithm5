import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Syj {
  static int N, M, zeroCnt, result = Integer.MAX_VALUE;
  static int[][] map, copyMap;
  static ArrayList<int[]> virus;
  static int[] sel;
  static Queue<int[]> q = new ArrayDeque<>();
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    ;

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][N];
    virus = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 2) {
        map[i][j] = 0;
          virus.add(new int[] { i, j, 0 });
        } else if (map[i][j] == 0) {
          zeroCnt++;
        }
      }
    }

    sel = new int[M];
    combination(0, 0);
    if (result == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(result);
    }
  }

  private static void combination(int idx, int k) {
    if (k == M) {
      copyMap = new int[N][N];
      for (int i = 0; i < N; i++) {
        System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
      }
      
       for (int i = 0; i < M; i++) {
		int[] tmp = virus.get(sel[i]);
		copyMap[tmp[0]][tmp[1]] = 2;
		q.add(new int[] {tmp[0], tmp[1], 0});
	}

      spread(zeroCnt + virus.size() - M);
      return;
    }

    for (int i = idx; i < virus.size(); i++) {
      sel[k] = i;
      combination(i + 1, k + 1);
    }
  }

  private static void spread(int cnt) {
	  int[] v = new int[] {};
	  int x, y;
    while (!q.isEmpty()) {
      v = q.poll();

      for (int d = 0; d < 4; d++) {
        x = v[0] + dx[d];
        y = v[1] + dy[d];

        if (x < 0 || x >= N || y < 0 || y >= N || copyMap[x][y] != 0)
          continue;

        if (copyMap[x][y] == 0) {
        	cnt--;
        	copyMap[x][y] = v[2] + 1;
          q.add(new int[] { x, y, copyMap[x][y] });
        }
      }
    }
    if (cnt == 0) {
      result = Math.min(result, v[2]);
      return;
    }
  }
}