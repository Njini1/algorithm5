import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, R, C;
	static int[][] map;
	static int[] dr = {-1, 0, 0, 1, -2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dc = {0, -1, 1, 0, -1, 1, -2, 2, -2, 2, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(go());
		
	}

	private static int go() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, K, 0}); //행, 열, 남은 기회, 동작 횟수
		boolean[][][] isVisited = new boolean[R][C][K + 1];
		isVisited[0][0][K] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == R - 1 && cur[1] == C - 1) return cur[3];
			for (int i = 0; i < 4; i++) {
				if (cur[0] + dr[i] < 0 || cur[0] + dr[i] >= R || cur[1] + dc[i] < 0 || cur[1] + dc[i] >= C) continue;
				if (!isVisited[cur[0] + dr[i]][cur[1] + dc[i]][cur[2]] && map[cur[0] + dr[i]][cur[1] + dc[i]] == 0) {
					q.offer(new int[] {cur[0] + dr[i], cur[1] + dc[i], cur[2], cur[3] + 1});
					isVisited[cur[0] + dr[i]][cur[1] + dc[i]][cur[2]] = true;
				}
			}
			if (cur[2] > 0) {
				for (int i = 4; i < 12; i++) {
					if (cur[0] + dr[i] < 0 || cur[0] + dr[i] >= R || cur[1] + dc[i] < 0 || cur[1] + dc[i] >= C) continue;
					if (!isVisited[cur[0] + dr[i]][cur[1] + dc[i]][cur[2] - 1] && map[cur[0] + dr[i]][cur[1] + dc[i]] == 0) {
						q.offer(new int[] {cur[0] + dr[i], cur[1] + dc[i], cur[2] - 1, cur[3] + 1});
						isVisited[cur[0] + dr[i]][cur[1] + dc[i]][cur[2] - 1] = true;
					}
				}
			}
		}
		return -1;
	}

}
