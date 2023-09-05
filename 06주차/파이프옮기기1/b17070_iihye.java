import java.io.*;
import java.util.*;

public class b17070 {
	
	static int[] dr = {0, 1, 1}; // 오른쪽, 아래, 대각선
	static int[] dc = {1, 0, 1};
	
	static boolean[][] status = {{true, false, true}, // 현재 -> 움직임
								{false, true, true},
								{true, true, true}};
	
	private static int N;
	private static int[][] map;
	private static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 집의 크기
		map = new int[N][N]; // 격자판 
		cnt = 0; // 마지막 좌표까지 도달하는 개수
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 0); // 0, 1 에서 가로로 배치
		
		System.out.println(cnt);
	}

	private static void dfs(int r, int c, int idx) {
		// basis part
		if(r == N-1 && c == N-1) { // 마지막 좌표에 도달하면 cnt를 1 증가하고 끝냄
			cnt++;
			return;
		}
		
		// inductive part
		for (int d = 0; d < dc.length; d++) { // 세 방향 탐색
			if(status[idx][d]) { // 이동 가능하면
				int nr = r + dr[d]; // 좌표 업데이트
				int nc = c + dc[d];
				// 가능한 좌표이고 갈 수 있는 곳이면
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][c] == 0 && map[r][nc] == 0 && map[nr][nc] == 0) {
					dfs(nr, nc, d);
				}
			}		
		}
	}
}
