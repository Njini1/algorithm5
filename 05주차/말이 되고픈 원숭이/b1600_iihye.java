import java.awt.Point;
import java.io.*;
import java.util.*;

public class b1600 {
	
	static class Monkey{
		int r, c, cnt, k;
		
		Monkey(int r, int c, int cnt, int k) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
	}
	
	static int[] hr = {-1, -2, -2, -1, 1, 2, 2, 1}; // 말이 이동할 수 있는 범위
	static int[] hc = {-2, -1, 1, 2, -2, -1, 1, 2};
	
	static int[] dr = {-1, 0, 1, 0}; // 원숭이가 이동할 수 있는 범위
	static int[] dc = {0, 1, 0, -1};
	
	private static int K;
	private static int W;
	private static int H;
	private static int[][] map;
	private static boolean[][][] visited;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		K = Integer.parseInt(br.readLine()); // 움직일 수 있는 횟수
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로 길이
		H = Integer.parseInt(st.nextToken()); // 세로 길이
		
		map = new int[H][W]; // 격자판
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[H][W][K+1]; // 방문 배열
		ans = Integer.MAX_VALUE; // 최대값으로 초기화
		bfs(0, 0); // bfs로 탐색
		
		if(ans == Integer.MAX_VALUE) { // ans가 최대값이면
			System.out.println(-1); // -1  출력
		} else {					// ans가 최대값이 아닌 다른 수이면
			System.out.println(ans); // 그 ans 값을 출력
		}
		
	}

	private static void bfs(int r, int c) {
		Queue<Monkey> q = new LinkedList<Monkey>(); // 큐 생성
		q.offer(new Monkey(r, c, 0, K)); // (r, c) 좌표에서 cnt = 0인 상태로 시작. 말은 움직이지 않았으므로 K 그대로 넣음.
		visited[r][c][K] = true; // K일 때 (r, c) 방문 처리
		
		while(!q.isEmpty()) { // 큐가 비어 있을 때까지 반복
			Monkey p = q.poll(); // 하나 꺼내서 확인
			
			if(p.r == H-1 && p.c == W-1) { // 움직인 위치가 마지막 좌표이면
				ans = Math.min(p.cnt, ans); // p.cnt와 ans 중 최소값 저장
				return;
			}
			
			// 원숭이는 원래 능력으로 dr, dc로 움직이거나 말처럼 hr, hc로 움직일 수 있음
			
			// 1) 원숭이 원래 능력으로 움직이기
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 0 && !visited[nr][nc][p.k]) {
					visited[nr][nc][p.k] = true;
					q.add(new Monkey(nr, nc, p.cnt + 1, p.k));
				}
			}
			
			// 2) 말처럼 움직이기
			if(p.k > 0) { // 말처럼 움직일 수 있는 횟수가 남아 있으면
				for (int d = 0; d < 8; d++) {
					int nr = p.r + hr[d];
					int nc = p.c + hc[d];
					if(nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 0 && !visited[nr][nc][p.k-1]) {
						visited[nr][nc][p.k-1] = true;
						q.offer(new Monkey(nr, nc, p.cnt + 1, p.k-1));
					}
				}
			}
		}
	}

}
