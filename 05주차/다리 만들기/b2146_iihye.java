import java.awt.Point;
import java.io.*;
import java.util.*;

public class b2146 {
	
	static class Island{
		int r;
		int c;
		int dis;
		
		public Island(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}
	}
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static int islandNum;
	private static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 지도의 크기
		map = new int[N][N]; // 지도
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][N]; // 방문 배열
		islandNum = 0; // 섬의 개수
		
		// 섬의 개수 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) { // 섬이 있고 방문 전이면
					islandNum += 1;
					makeLand(i, j, islandNum+1); // 같은 섬이면 map[i][j] 값을 바꿈
				}
			}
		}
		
		// 섬의 외곽에서 다른 섬의 외곽까지 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] >= 2) { // 섬이 있고 방문 전인 섬이면
					visited = new boolean[N][N]; // 방문 배열
					buildBridge(i, j, map[i][j]);
				}
			}
		}
		
		// 출력
		System.out.println(ans);
	}
	
	private static void buildBridge(int r, int c, int num) {
		Queue<Island> q = new LinkedList<Island>();
		q.offer(new Island(r, c, 0));
		visited[r][c] = true;
		int islandNum = map[r][c];
		
		while(!q.isEmpty()) {
			Island p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				// 범위 내에 있고 방문 전이며 자기 섬이 아니면
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] != islandNum) { 
					visited[nr][nc] = true;
					if(map[nr][nc] == 0) { // 바다면 거리 증가해서 위치 추가
						q.offer(new Island(nr, nc, (p.dis + 1)));
					} else { // 다른 섬이면 정답 구하기
						ans = Math.min(ans, p.dis);
					}
				}
			}
		}
	}

	// r : 가로, c : 세로, num : 섬의 번호
	private static void makeLand(int r, int c, int num) {
		Queue<Point> q = new LinkedList<Point>();
		visited[r][c] = true;
		map[r][c] = num;
		q.offer(new Point(r, c));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				// 범위 내 && 방문 전 && 섬이면
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					map[nr][nc] = num; // 섬 넘버링하기
					q.offer(new Point(nr, nc));
				}
			}
		}
	}

}
