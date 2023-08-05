import java.util.*;

public class swea1873 {
	public static final char UP = '^';
	public static final char DOWN = 'v';
	public static final char LEFT = '<';
	public static final char RIGHT = '>';
	public static final char GROUND = '.';
	public static final char WALL = '*';
	public static final char STEEL = '#';
	public static final char WATER = '-';

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int H = sc.nextInt(); // 높이
			int W = sc.nextInt(); // 너비
			char[][] map = new char[H][W]; // 게임 맵
			
			int r = 0; // 포차의 좌표
			int c = 0; 
			
			for(int h = 0; h < H; h++) {
				String str = sc.next();
				for(int w = 0; w < W; w++) {
					map[h][w] = str.charAt(w);
					// 포차면 좌표 저장
					if(map[h][w] == LEFT || map[h][w] == RIGHT || map[h][w] == UP || map[h][w] == DOWN) {
						r = h;
						c = w;
					}
				}
			}
			int N = sc.nextInt(); // 사용자가 넣을 입력의 개수
			String str = sc.next(); // 길이가 N인 문자열
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			
			for(int s = 0; s < N; s++) {
				switch(str.charAt(s)) {
				case 'U': // up
					if(r-1 >= 0 && r-1 < H && map[r-1][c] == GROUND ) { // 위쪽으로 갔을 때 평지라면
						map[r--][c] = GROUND ; // 평지로 만들기
					}
					map[r][c] = UP; // 포차 위쪽 방향으로 변경
					break;
					
				case 'D': // down
					if(r+1 >= 0 && r+1 < H && map[r+1][c] == GROUND) { // 아래쪽으로 갔을 때 평지라면
						map[r++][c] = GROUND ; // 평지로 만들기
					}
					map[r][c] = DOWN; // 아래쪽 방향으로 변경
					break;
					
				case 'L': // left
					if(c-1 >= 0 && c-1 < W && map[r][c-1] == GROUND) { // 왼쪽으로 갔을 때 평지라면
						map[r][c--] = GROUND ; // 평지로 만들기
					}
					map[r][c] = LEFT; // 왼쪽 방향으로 변경
					break;
					
				case 'R': // right
					if(c+1 >= 0 && c+1 < W && map[r][c+1] == GROUND) { // 오른쪽으로 갔을 때 평지라면
						map[r][c++] = GROUND ; // 평지로 만들기
					}
					map[r][c] = RIGHT; // 오른쪽 방향으로 변경
					break;
					
				case 'S': // shoot
					int d = -1;
					
					switch(map[r][c]) {
					case(UP):
						d = 0;
						break;
						
					case(DOWN):
						d = 1;
						break;
						
					case(LEFT):
						d = 2;
						break;
						
					case(RIGHT):
						d = 3;
						break;
						
					default:
						break;
					}
					
					int nr = r + dr[d];
					int nc = c + dc[d];
					while(true) {
						if(nr >= 0 && nr < H && nc >= 0 && nc < W) {
							if(map[nr][nc] == WALL) { // 벽돌이면 땅으로 만들기
								map[nr][nc] = GROUND;
								break;
							} else if(map[nr][nc] == STEEL) { // 강철이면 멈춤
								break;
							} else { // 나머지는 직진
								nr += dr[d];
								nc += dc[d];
							}
						} else {
							break;
						}
					}
					break;
					
				default:
					break;
				}
			}
			
			// 출력
			System.out.printf("#%d ", t);
			for(int h = 0; h < H; h++) {
				for(int w = 0; w < W; w++) {
					System.out.printf("%c", map[h][w]);
				}
				System.out.println();
			}
		}
	}

}
