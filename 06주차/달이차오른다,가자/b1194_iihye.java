import java.io.*;
import java.util.*;

public class b1194 {
	static class Move {
		int r;
		int c;
		int cnt;
		int key;
		
		Move(){};
		
		public Move(int r, int c, int cnt, int key) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}
	}
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	private static int N;
	private static int M;
	private static char[][] map;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		Move src = new Move();
		
		for (int i = 0; i < N; i++) {
			String str= br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') { // 시작 위치 저장
					src = new Move(i, j, 0, 0);
				}
			}
		}
		
		System.out.println(bfs(src));
	}

	private static int bfs(Move src) {
		Queue<Move> q = new LinkedList<>(); // 큐 생성
		boolean[][][] visited = new boolean[N][M][64]; // 방문 체크
													// key는 2^6=64 가지 가능
		q.offer(src); // 시작 위치 넣기
		visited[src.r][src.c][0] = true; // 방문 처리
		
		// 큐가 빌 때까지 반복
		while(!q.isEmpty()) {
			Move p = q.poll(); // 하나 꺼내기
			
			// 출구를 발견하면
			if(map[p.r][p.c] == '1')
				return p.cnt; // 현재까지 온 거리 return
			
			// 사방탐색
			for (int d = 0; d < dc.length; d++) {
				// 좌표 업데이트
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				// 범위 내 && 벽이 아니고 && 방문 전인 구역이면
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!='#' && !visited[nr][nc][p.key]) {
				
					// case 1) 열쇠를 발견하면
					if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						// 1을 알파벳 순서만큼 밀기 -> 비트 마스킹을 이용하여 key 생성
						int key = 1 << (map[nr][nc] - 'a'); 
						key = p.key | key; // 현재 키와 OR 연산을 통해 키 갱신
						visited[nr][nc][key] = true; // 갱신한 키를 기준으로 방문 처리
						q.offer(new Move(nr, nc, p.cnt + 1, key)); // 큐에 넣기
					} 
					// case 2) 문을 발견하면
					else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
						// 문에 맞는 키를 가지고 있으면
						if((p.key & (1 << (map[nr][nc] - 'A'))) == (int)Math.pow(2, map[nr][nc]-'A')) {
							visited[nr][nc][p.key] = true; // 현재 키 기준으로 방문 처리
							q.offer(new Move(nr, nc, p.cnt+1, p.key)); // 큐에 넣기
						}
					}
					// case 3) 길이면
					else {
						visited[nr][nc][p.key] = true; // 현재 키 기준으로 방문 처리
						q.offer(new Move(nr, nc, p.cnt+1, p.key)); // 큐에 넣기
					}
				}
				
			}
		}
		
		// 큐를 다 돌았지만 출구를 발견하지 못한 경우
		return -1; // -1 return
	}

}
