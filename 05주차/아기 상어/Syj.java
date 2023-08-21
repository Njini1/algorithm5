import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Syj{
  static class Point implements Comparable<Point> {
    int x, y, level;

    Point() {
      this.level = 0;
    };

    Point(int x, int y, int level) {
      this.x = x;
      this.y = y;
      this.level = level;
    }

    @Override
    public int compareTo(Point o) {
      if (o.level == this.level) {
        if (o.x == this.x) {
          return this.y - o.y; //오름차순
        }
        return this.x - o.x;
      }
      return this.level - o.level;
    }
  }

  static int N, result;
  static int[][] map;
  static int dx[] = { -1, 0, 0, 1 }; // 상 좌 우 하
  static int dy[] = { 0, -1, 1, 0 };
  static int sharkSize, eatCnt;
  static int[] fishCnt = new int[7];
  static boolean[][] visit;
  static PriorityQueue<Point> q = new PriorityQueue<>();
  static PriorityQueue<Point> tmpQ = new PriorityQueue<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // map의 크기, (2 ≤ N ≤ 20)

    // map값 받기, 0: 빈 칸, 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기, 9: 아기 상어의 위치
    Point target = new Point();
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 9) {
          target.x = i;
          target.y = j;
        } else if (map[i][j] != 0) {
          fishCnt[map[i][j]]++;
        }
      }
    }

    sharkSize = 2;
    eatCnt = 0;
    q = new PriorityQueue<Point>();
    map[target.x][target.y] = 0; // 상어가 움직이므로
    q.add(new Point(target.x, target.y, target.level));
    int fish = 0;
    for (int i = 1; i < sharkSize; i++) {
      fish += fishCnt[i];
    }
    visit = new boolean[N][N];
    visit[target.x][target.y] = true;
    eat(fish);
    System.out.println(result);
  }

  private static void eat(int fish) {
    Point tmp;
    int x, y, nx, ny, level;
    while (!q.isEmpty()) {
      if (fish == 0)
        return;
      int size = q.size();
      for (int i = 0; i < size; i++) {
		
    	  tmp = q.poll();
    	  x = tmp.x;
    	  y = tmp.y;
    	  level = tmp.level;
    	  for (int d = 0; d < 4; d++) {
    		  nx = x + dx[d];
    		  ny = y + dy[d];
    		  
    		  // 범위를 벗어나거나 상어의 크기보다 물고기의 크기가 크면(지나갈 수 없으므로) 다음 값으로 넘어감
    		  if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] > sharkSize || visit[nx][ny])
    			  continue;
    		  
    		  visit[nx][ny] = true;
    		  
    		  if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
    			  tmpQ.add(new Point(nx, ny, level + 1));
    		  } else {
    			  // 탐색한 위치가 0인 빈칸이거나 상어 크기와 같은 크기의 물고기라면 q에 넣음
    			  q.add(new Point(nx, ny, level + 1));
    		  }
    	  	}

      }
      if (!tmpQ.isEmpty()) {
    	  Point f = tmpQ.poll();
    	  tmpQ.clear();
    	  map[f.x][f.y] = 0; // 물고기를 먹어서 그 칸은 빈칸
    	  q.clear(); // 먹을 물고기를 찾았으니 x, y주변 탐색은 그만
    	  q.add(f); // 먹은 물고기 위치에서 다시 탐색위에 추가
    	  visit = new boolean[N][N];
    	  visit[f.x][f.y] = true;
    	  fish--;
    	  eatCnt++;
    	  result = f.level;
    	  // 먹은 개수와 상어 크기가 같으면 상어 크기 + 1하고 먹은 개수 0으로 초기화
    	  if (eatCnt == sharkSize) {
    		  if (sharkSize <= 6) {
    			  fish += fishCnt[sharkSize]; // 먹을 수 있는 물고기 수를 더함
    		  }
    		  sharkSize++;
    		  eatCnt = 0;
    	  }
      }
    }
  }
}