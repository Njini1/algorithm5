package algorithmLab;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Nhs {
	static int T, N, K, ans, map[][];
	static boolean v[][], chance;
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
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			int max = 0;
			for (int i = 0; i < N; i++) { // 지도 정보 입력 & 최대값 찾기
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					max = (max<temp) ? temp : max; 
				}
			}
			
			ArrayList<Point> li = new ArrayList<Point>();
			for (int i = 0; i < N; i++) { // 가장 높은 값들의 좌표 저장
				for (int j = 0; j < N; j++) {
					if(map[i][j] == max) {
						li.add(new Point(i, j));
					}
				}
			}
			
			ans = 0;
			for (int i = 0; i < li.size(); i++) {
				Point loc = li.get(i);
				int x = loc.x;
				int y = loc.y;
				chance = true; // 공사 기회 여부
				v = new boolean[N][N]; // 방문배열
				dfs(x, y, 1); 
			}
			
			System.out.printf("#%d %d\n", tc, ans);
			
			
		}
		
	}
	private static void dfs(int x, int y, int cnt) {
		ans = (ans<cnt) ? cnt : ans; // 최대값 갱신
		v[x][y] = true; // 방문처리
		for (int i = 0; i < 4; i++) { // 4방탐색
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0&&nx<N&&ny>=0&&ny<N&&!v[nx][ny]) { // 범위 체크
				int diff = map[nx][ny] - map[x][y];
				if(chance && diff>=0 && diff < K) { // 현재 좌표와 다음 좌표의 높이차가 K보다 작다면
					chance = false;
					int temp = map[nx][ny]; // 공사 끝나고 백트래킹시 값 되돌리기 위해 임시저장
					map[nx][ny] = map[x][y]-1; // 최소한 적게 깎기 (현재 높이보다 1만큼만 작게)
					dfs(nx, ny, cnt+1); // 공사한 값으로 dfs
					map[nx][ny] = temp; 
					v[nx][ny] = false;
					chance = true; // 모든 경우를 탐색하기 위해 탐색 후 높이값, 공사기회, 방문처리 원상복구
				} else if (map[nx][ny] < map[x][y]){ // 다음 좌표가 더 낮으면
					dfs(nx, ny, cnt+1); // dfs
					v[nx][ny] = false; // 방문처리 복구
				}
			}
		}
		
	}
	
	private static void print(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
