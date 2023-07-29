import java.util.*;

public class swea4615 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스의 개수
		int[] dr = {0, 0, -1, 1, -1, -1, 1, 1}; // 팔방탐색
		int[] dc = {-1, 1, 0, 0, -1, 1, -1, 1};
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 보드의 한 변의 길이
			int M = sc.nextInt(); // 돌을 놓는 횟수
			
			int black = 0; // 흑돌
			int white = 0; // 백돌
			
			int[][] map= new int[N][N]; // 보드
			map[(N / 2) - 1][(N / 2) - 1] = 2; // 처음 돌의 배치(흑돌:1 백돌:2)
			map[(N / 2)][(N / 2) - 1] = 1;
			map[(N / 2) - 1][N / 2] = 1;
			map[N / 2][N / 2] = 2;
	
			for(int m = 0; m < M; m++) { // 돌을 놓는 횟수만큼 반복
				int r = sc.nextInt()-1; // 돌을 놓을 위치
				int c = sc.nextInt()-1;
				int stone = sc.nextInt(); // 돌의 색
				
				// 현재 위치 돌 놓기
				map[r][c] = stone;
				
				// 다른 돌 색 바꾸기
				for(int d = 0; d < 8; d++) { // 방향
					int nr = r + dr[d]; // 팔방탐색
					int nc = c + dc[d];
					
					boolean check = false; // 같은 돌인지 확인함
					
					while(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 0) { // 범위 내에 있고 빈 자리가 아니면
						if(map[nr][nc] == stone) { // 같은 돌이면 탐색 중단
							check = true;
							break;
						}
						nr += dr[d]; // 같은 돌이 아니면 다음 칸으로
						nc += dc[d];
					}
					
					while(check) { // 같은 돌이면
						if(nr == r && nc == c) { // 자기 자신으로 되돌아올 때까지
							break;
						}
						map[nr][nc] = stone; // 자기 돌로 바꾸기
						nr -= dr[d]; // 이전 칸으로
						nc -= dc[d];
					}
				}
			}
			
			// 돌 개수 구하기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						black++;
					} else if(map[i][j] == 2) {
						white++;
					}
				}
			}
			
			System.out.printf("#%d %d %d\n", t, black, white);
		}
	}
}
