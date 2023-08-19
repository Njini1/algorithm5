import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] map1, isVisited;
	static int[][] map2;
	static int N, island_num, answer;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Set<int[]> coasts;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map1 = new boolean[N][N];
		isVisited = new boolean[N][N];
		map2 = new int[N][N];
		island_num = 1;
		coasts = new HashSet<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				if (st.nextToken().equals("1")) {
					map1[i][j] = true;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!map1[i][j]) continue;
				if (isVisited[i][j]) continue;
				find_island(i, j);
				island_num++;
			}
		}
		
		answer = N * 2 - 2;
		for (int[] coast: coasts) {
			isVisited = new boolean[N][N];
			int cur = make_bridge(map2[coast[0]][coast[1]], coast);
			if (cur != -1 && cur < answer) answer = cur;
		}
		
		System.out.println(answer);
	}

	private static void find_island(int r, int c) {
		map2[r][c] = island_num;
		isVisited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			if (r + dr[i] < 0 || r + dr[i] >= N || c + dc[i] < 0 || c + dc[i] >= N) continue;
			if (!map1[r + dr[i]][c + dc[i]]) coasts.add(new int[] {r, c});
			if (map1[r + dr[i]][c + dc[i]] && !isVisited[r + dr[i]][c + dc[i]]) find_island(r + dr[i], c + dc[i]);
		}
	}
	
	private static int make_bridge(int island, int[] coast) {
		Queue<int[]> s = new ArrayDeque<>();
		s.offer(new int[] {coast[0], coast[1], 0});
		while (!s.isEmpty()) {
			int[] cur = s.poll();
			if (cur[2] >= answer) return -1;
			for (int i = 0; i < 4; i++) {
				if (cur[0] + dr[i] < 0 || cur[0] + dr[i] >= N || cur[1] + dc[i] < 0 || cur[1] + dc[i] >= N) continue;
				if (map2[cur[0] + dr[i]][cur[1] + dc[i]] != 0 && map2[cur[0] + dr[i]][cur[1] + dc[i]] != island) {
					return cur[2];
				}
				if (map2[cur[0] + dr[i]][cur[1] + dc[i]] == 0 && !isVisited[cur[0] + dr[i]][cur[1] + dc[i]]) {
					s.offer(new int[] {cur[0] + dr[i], cur[1] + dc[i], cur[2] + 1});
					isVisited[cur[0] + dr[i]][cur[1] + dc[i]] = true;
				}
			}
		}
		return -1;
	}

}
