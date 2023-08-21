import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Nhs {
	static int N, type, ans=Integer.MAX_VALUE, map[][];
	static boolean v[][];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input.txt")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());;
			}
		}
		type = 2;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					dfs(i,j);	
					type++; // 각 섬마다 다른 수 부여 (2부터 시작, 1과 0은 탐색에 활용 중이기 때문)
				}
			}
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0) { // 바다가 아닌 경우 bfs
					v = new boolean[N][N];
					bfs(i, j, map[i][j], 0);
				}
			}
		}
		System.out.println(ans-2); // bfs에서 거리계산할 때 현재위치, 도착위치도 거리에 포함했기 때문에 2 빼주기
	}

	private static void bfs(int x, int y, int now, int dist) { // x, y좌표, 현재 섬, 다른 섬까지의 거리
		ArrayDeque<Point> q = new ArrayDeque<>();
		q.offer(new Point(x, y));
		v[x][y] = true;
		
		while(!q.isEmpty()) {
			dist++;
			int size = q.size();
			
			for(int t=0; t<size; t++) {
				Point loc = q.poll();
				if(map[loc.x][loc.y] != 0 && map[loc.x][loc.y] != now) { // 현재 섬에서 출발하여 다른 섬에 도달했을 때 최단거리 갱신
					ans = (ans>dist) ? dist : ans;
					return;
				}
				for (int i = 0; i < 4; i++) {
					int nx = loc.x + dx[i];
					int ny = loc.y + dy[i];
					if(nx>=0&&nx<N&&ny>=0&&ny<N&&!v[nx][ny]) {// 범위체크
						if(map[nx][ny]==0||map[nx][ny]!=now) { // 바다이거나 자기 섬이 아닌 경우 탐색
							v[nx][ny] = true;
							q.offer(new Point(nx, ny));
						}
					}
				}
			}
		}
		
	}

	private static void dfs(int x, int y) {
		map[x][y] = type;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0&&nx<N&&ny>=0&&ny<N&&map[nx][ny]==1) {
				dfs(nx, ny);
			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
