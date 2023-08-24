import java.io.*;
import java.util.*;

public class swea1949 {

	private static int N;
	private static int K;
	private static int[][] map;
	private static boolean[][] v;
	private static int peak;
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도의 한 변의 길이
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
			map = new int[N][N]; // 지도 정보
			v = new boolean[N][N]; // 방문 배열
			peak = 0; // 가장 높은 봉우리
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					peak = Math.max(peak, map[i][j]); // 가장 높은 봉우리 찾기
				}
			}
			ans = 0;
			
			// 가장 높은 봉우리에서 dfs 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == peak) {
						v[i][j] = true;
						dfs(i, j, 1, 1);
						v[i][j] = false;
					}
				}
			}
			
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	// r : 가로, c : 세로, cnt : 몇 번째로 방문했는지, cut : 자른 횟수(1회만 가능)
	private static void dfs(int r, int c, int cnt, int cut) {
		int temp = map[r][c]; // 현재 위치의 봉우리 값
		
		for (int d = 0; d < 4; d++) { // 사방탐색
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) { // 범위 내에 있고 방문 전이면
				if(map[nr][nc] < temp) { // 현재보다 낮은 지형이면
					v[nr][nc] = true; // 방문
					dfs(nr, nc, cnt+1, cut);
					v[nr][nc] = false; // 복구
				} else if(cut == 1) { // 현재보다 높은 지형이면서 깎을 수 있으면 깎기
					for (int i = 1; i <= K; i++) {
						if(map[nr][nc] - i < temp) {
							map[nr][nc] -= i; // 자르기
							dfs(nr, nc, cnt+1, cut-1); // 방문하고 자르기
							map[nr][nc] += i; // 복구							
						}
					}
				}
			}
		}
		
		if(cnt > ans) {
			ans = cnt;
		}
	}

}
