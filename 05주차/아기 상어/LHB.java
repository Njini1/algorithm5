import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, shark[], time, shark_level, shark_exp;
	static int[][] map;
	static Queue<Integer> fishes;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		shark_level = 2;
		shark_exp = 0;
		fishes = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) shark = new int[] {i, j};
				else if (map[i][j] != 0) fishes.add(map[i][j]);
			}
		}
		
		time = 0;
		while (!fishes.isEmpty()) {
			int target = fishes.poll();
			if (target >= shark_level) break;
			int cur_time = hunt();
			if (cur_time == 0) break;
			else time += cur_time;
		}
		
		System.out.println(time);
	}

	private static int hunt() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[N][N];
		q.offer(new int[] {shark[0], shark[1], 0});
		isVisited[shark[0]][shark[1]] = true;
		int[] cur = null;
		List<int[]> preys = new LinkedList<>();
		while (!q.isEmpty()) {
			cur = q.poll();
			if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] != 9 && map[cur[0]][cur[1]] < shark_level) {
				preys.add(cur);
			}
			for (int i = 0; i < 4; i++) {
				if (cur[0] + dr[i] < 0 || cur[0] + dr[i] >= N || cur[1] + dc[i] < 0 || cur[1] + dc[i] >= N) continue;
				if (!isVisited[cur[0] + dr[i]][cur[1] + dc[i]] && map[cur[0] + dr[i]][cur[1] + dc[i]] <= shark_level) {
					q.offer(new int[] {cur[0] + dr[i], cur[1] + dc[i], cur[2] + 1});
					isVisited[cur[0] + dr[i]][cur[1] + dc[i]] = true;
				}
			}
		}
		preys.sort((o1, o2) -> {
			if (o1[2] != o2[2]) return o1[2] - o2[2];
			if (o1[0] != o2[0]) return o1[0] - o2[0];
			return o1[1] - o2[1];});
		if (!preys.isEmpty()) {
			cur = preys.get(0);
			shark_exp++;
			if (shark_exp == shark_level) {
				shark_level++;
				shark_exp = 0;
			}
			map[shark[0]][shark[1]] = 0;
			map[cur[0]][cur[1]] = 9;
			shark[0] = cur[0];
			shark[1] = cur[1];
			return cur[2];
		}
		return 0;
	}

}
