import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Syj {
  static class Vertex implements Comparable<Vertex> {
    int e, w;

    public Vertex(int e, int w) {
      this.e = e;
      this.w = w;
    }

    @Override
    public int compareTo(Vertex o) {
      return this.w - o.w;
    }

  }

  static int N, M;
  static int[][] map;
  static int[][] adjMatrix;
  static int[] dx = { 0, 0, -1, 1 };
  static int[] dy = { 1, -1, 0, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
	
	//지도 값 받기
    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken()) - 1;
      }
    }
    
    //섬의 번호 매기기
    int group = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          map[i][j] = group;
          findIsland(i, j, group++);
        }
      }
    }

    //다리 연결하기(간선 저장)
    adjMatrix = new int[group][group];
    for (int i = 1; i < group; i++) {
      Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] != -1) {
          connect(i, j, map[i][j]);
        }
      }
    }
    
    //프림 알고리즘
    int result = 0;
    boolean[] visit = new boolean[group];

    PriorityQueue<Vertex> q = new PriorityQueue<>();
    q.add(new Vertex(1, 0));
    int cnt = 0;
    boolean isBridge = false;
    while (!q.isEmpty()) {
      Vertex tmp = q.poll();

      if (visit[tmp.e])
        continue;

      visit[tmp.e] = true;
      result += tmp.w;
      cnt++;
      if (cnt == group - 1) {
        isBridge = true;
        break;
      }

      for (int i = 1; i < group; i++) {
        int next = adjMatrix[tmp.e][i];

        if (!visit[i] && next != Integer.MAX_VALUE) {
          q.add(new Vertex(i, next));
        }
      }
    }
    
    //출력
    if (isBridge) {
      System.out.println(result);
    } else {
      System.out.println(-1);
    }
  }

  private static void connect(int x, int y, int gNum) {
    int nx = x, ny = y;
    for (int d = 0; d < 4; d++) {
      int cnt = 0;
      int value;
      while (true) {
        nx += dx[d];
        ny += dy[d];

        if (nx < 0 || nx >= N || ny < 0 || ny >= M)
          break;

        value = map[nx][ny];
        if (value == gNum)
          break;

        if (value != -1) {
          if (cnt >= 2) {
            adjMatrix[gNum][value] = Math.min(adjMatrix[gNum][value], cnt);
            adjMatrix[value][gNum] = Math.min(adjMatrix[value][gNum], cnt);
          }
          break;
        }
        cnt++;
      }
    }

  }

  private static void findIsland(int x, int y, int group) {
    int nx, ny;
    for (int d = 0; d < 4; d++) {
      nx = x + dx[d];
      ny = y + dy[d];

      if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == -1)
        continue;

      if (map[nx][ny] == 0) {
        map[nx][ny] = group;
        findIsland(nx, ny, group);
      }
    }
  }
}