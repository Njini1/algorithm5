import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, map[][], answer;
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
		move(1, 2, 0);
		System.out.println(answer);
		
	}
	
	private static void move(int er, int ec, int dir) {
		if (er == N && ec == N) {
			answer++;
			return;
		}
		int start = 0;
		int end = 3;
		if (dir == 0) end--;
		else if (dir == 2) start++;
		for (int i = start; i < end; i++) {
			int nr = er + dr[i];
			int nc = ec + dc[i];
			if (nr > N || nc > N) continue;
			if (i == 1 && (map[er + 1][ec] == 1 || map[er][ec + 1] == 1)) continue;
			if (map[nr][nc] == 1) continue;
			move(nr, nc, i);
		}
	}

}
