import java.util.*;
import java.awt.Point;
import java.io.*;

public class b16234 {
	private static int N;
	private static int L;
	private static int R;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	private static ArrayList<Point> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 땅의 크기
		L = sc.nextInt(); // L명 이상
		R = sc.nextInt(); // R명 이하
		map = new int[N][N]; // 인구

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int ans = simulation();
		System.out.println(ans);
	}
	
	public static int simulation() {
		int res = 0;
		visited = new boolean[N][N]; // 방문 여부
		
		while(true) { // 인구 이동이 없을 때까지 계속
			boolean move = false; // 인구 이동 확인
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(!visited[i][j]) { // 방문 전이면
						int sum = bfs(i, j);
						if(list.size() > 1) { // 리스트가 비어 있지 않으면
							int avg = sum / list.size(); // 평균 구하기
							for (Point p : list) { // 리스트에 있는 요소들 반복
								map[p.x][p.y] = avg;  // 평균 값으로 넣기
								move = true; // 인구 이동 했음
							}
						}
					}
				}
			}
			
			if(!move) { // 인구 이동이 더 이상 일어나지 않으면
				return res; 
			}
			res++; // 인구 이동 횟수 추가
		}
	}

	public static int bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>(); // bfs 돌릴 큐
		list = new ArrayList<>(); // 같은 인구를 공유할 리스트
		
		queue.offer(new Point(r, c)); // 큐에 추가
		list.add(new Point(r, c)); // 리스트에 추가
		visited[r][c] = true; // 방문 처리
		int sum = map[r][c]; // 합 더하기
		
		while(!queue.isEmpty()) { // 큐가 비어있을 때까지
			Point p = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) { // 범위 내에 있고 방문 전이면
					int diff = Math.abs(map[p.x][p.y] - map[nr][nc]); // 차 구하기
					if(diff >= L && diff <= R) { // 차 범위에 있으면
						queue.offer(new Point(nr, nc)); // 큐에 추가
						list.add(new Point(nr, nc)); // 리스트에 추가
						visited[nr][nc] = true; // 방문 처리
						sum += map[nr][nc]; // 합 더하기
					}
				}
			}
		}
		
		return sum;
	}
}
