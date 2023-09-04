import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, r, c;
	static char map[][];
	static boolean visited[][][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j];
				if (map[i][j] == '0') {
					map[i][j] = '.';
					r = i;
					c = j;
				}
			}
		}
		visited = new boolean[N][M][1 << 6];
		System.out.println(bfs());
		
	}
	
	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c, 0, 0});
		visited[r][c][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (map[cur[0]][cur[1]] == '1') return cur[3];
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				int key = cur[2];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] == '.' && !visited[nr][nc][key]) {
					q.offer(new int[] {nr, nc, key, cur[3] + 1});
					visited[nr][nc][key] = true;
				} else if (map[nr][nc] == '#') {
					continue;
				} else if ((map[nr][nc] >= 'a' && map[nr][nc] <= 'f') && !visited[nr][nc][key | (1 << (map[nr][nc] - 'a'))]) {
					key = key | (1 << (map[nr][nc] - 'a'));
					q.offer(new int[] {nr, nc, key, cur[3] + 1});
					visited[nr][nc][key] = true;
				} else if ((map[nr][nc] >= 'A' && map[nr][nc] <= 'F') && !visited[nr][nc][key] && (key & (1 << (map[nr][nc] - 'A'))) != 0) {
					q.offer(new int[] {nr, nc, key, cur[3] + 1});
					visited[nr][nc][key] = true;
				} else if (map[nr][nc] == '1'){
					q.offer(new int[] {nr, nc, key, cur[3] + 1});
					visited[nr][nc][key] = true;
				}
			}
		}
		return -1;
	}

}
