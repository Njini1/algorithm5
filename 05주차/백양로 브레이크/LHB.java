import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, adj[][], K, result[][];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken());
			adj[u][v] = 1;
			if (b == 0) adj[v][u] = 2;
			else adj[v][u] = 1;
		}
		result = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(result[i], Integer.MAX_VALUE);
			result[i][i] = 0;
		}
		for (int i = 0; i < N; i++) {
			bfs(i);
		}
		K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			sb.append(result[s][d]).append("\n");
		}
		System.out.println(sb);
		
	}
	
	private static void bfs(int s) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {s, 0});
		int[] cnt = new int[N];
		Arrays.fill(cnt, Integer.MAX_VALUE);
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < N; i++) {
				if (adj[cur[0]][i] == 0) continue;
				if (cnt[i] > cur[1] && adj[cur[0]][i] == 1) {
					q.offer(new int[] {i, cur[1]});
					cnt[i] = cur[1];
					if (result[s][i] > cur[1]) result[s][i] = cur[1];
				}
				else if (cnt[i] > cur[1] + 1 && adj[cur[0]][i] == 2) {
					q.offer(new int[] {i, cur[1] + 1});
					cnt[i] = cur[1] + 1;
					if (result[s][i] > cur[1] + 1) result[s][i] = cur[1] + 1;
				}
			}
		}
	}

}
