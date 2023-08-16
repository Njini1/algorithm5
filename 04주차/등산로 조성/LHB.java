import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, K, map[][], max, answer, road;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static List<int[]> peaks;
	static boolean chance, isVisited[][];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			isVisited = new boolean[N][N];
			max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++ ) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max) max = map[i][j];
				}
			}
			
			answer = 0;
			peaks = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) peaks.add(new int[] {i, j});
				}
			}
			for (int[] peak : peaks) {
				road = 0;
				chance = true;
				find_road(peak[0], peak[1]);
			}
			System.out.printf("#%d %d\n", tc, answer);
		}
	}

	private static void find_road(int r, int c) {
		road++;
		isVisited[r][c] = true;
		if (road > answer) {
			answer = road;
		}
		for (int i = 0; i < 4; i++) {
			if (r + dr[i] >= 0 && r + dr[i] < N && c + dc[i] >= 0 && c + dc[i] < N && !isVisited[r + dr[i]][c + dc[i]]) {
				if (map[r + dr[i]][c + dc[i]] < map[r][c]) {
					find_road(r + dr[i], c + dc[i]);
				} else if (chance && map[r + dr[i]][c + dc[i]] - map[r][c] < K) {
					int diff = map[r + dr[i]][c + dc[i]] - map[r][c];
					map[r + dr[i]][c + dc[i]] -= diff + 1;
					chance = false;
					find_road(r + dr[i], c + dc[i]);
					chance = true;
					map[r + dr[i]][c + dc[i]] += diff + 1;
				}
			}
		}
		road--;
		isVisited[r][c] = false;
	}

}
