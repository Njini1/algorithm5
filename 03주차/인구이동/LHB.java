import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, L, R;
	static int[][] map;
	static boolean[][] isVisited;
	static ArrayList<int[]> list;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		boolean isMoved = true;
		while (isMoved) {
			isMoved = false;
			isVisited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!isVisited[i][j]) {
						int sum = bfs(i, j);
						if (list.size() > 1) {
							int avg = sum / list.size();
							for (int k = 0; k < list.size(); k++) {
								map[list.get(k)[0]][list.get(k)[1]] = avg;
							}
							isMoved = true;
						}
					}
				}
			}
			count++;
		}
		System.out.println(count - 1);
	}
	
	public static int bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		list = new ArrayList<>();
		q.offer(new int[] {x, y});
		list.add(new int[] {x, y});
		isVisited[x][y] = true;
		
		int sum = map[x][y];
		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int i = 0; i < 4; i++) {
				int next_x = current[0] + dr[i];
				int next_y = current[1] + dc[i];
				if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= N) {
					continue;
				} else {
					if (!isVisited[next_x][next_y]) {
						int diff = Math.abs(map[current[0]][current[1]] - map[next_x][next_y]);
						if (diff >= L && diff <= R) {
							q.offer(new int[] {next_x, next_y});
							list.add(new int[] {next_x, next_y});
							sum += map[next_x][next_y];
							isVisited[next_x][next_y] = true;
						}
					}
				}
			}
		}
		return sum;
	}

}
