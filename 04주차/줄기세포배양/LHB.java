import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, K, count;
	static int[][][] grid;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			grid = new int[N + K * 2][M + K * 2][];
			count = 0;
			for (int i = K; i < K + N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = K; j < K + M; j++) {
					int power = Integer.parseInt(st.nextToken());
					if (power != 0)	{
						grid[i][j] = new int[] {power, 2, 0};
						count++;
					}
				}
			}
			
			for (int h = 1; h <= K; h++) {
				for (int i = 0; i < N + K * 2; i++) {
					for (int j = 0; j < M + K * 2; j++) {
						if (grid[i][j] == null) continue;
						else if (grid[i][j][1] == 0) continue;
						else if (grid[i][j][1] == 1) {
							if (h == grid[i][j][2] + grid[i][j][0] + 1) {
								for (int d = 0; d < 4; d++) {
									if (i + dr[d] < 0 || i + dr[d] >= N + K * 2 || j + dc[d] < 0 || j + dc[d] >= M + K * 2) continue;
									if (grid[i + dr[d]][j + dc[d]] == null) {
										grid[i + dr[d]][j + dc[d]] = new int[] {grid[i][j][0], 2, h};
										count++;
									} else {
										if (grid[i + dr[d]][j + dc[d]][2] == h && grid[i][j][0] > grid[i + dr[d]][j + dc[d]][0]) {
											grid[i + dr[d]][j + dc[d]][0] = grid[i][j][0];
										}
									}
								}
							}
							if (h == grid[i][j][2] + grid[i][j][0] * 2) {								
								grid[i][j][1] = 0;
								count--;
							}
						} else if (grid[i][j][1] == 2) {
							if (h == grid[i][j][2] + grid[i][j][0]) {
								grid[i][j][1] = 1;
							}
						}
					}
				}
			}
			System.out.printf("#%d %d\n", tc, count);
		}
	}

}
