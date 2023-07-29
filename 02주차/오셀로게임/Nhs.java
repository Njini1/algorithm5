import java.util.Scanner;

public class Nhs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
		int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			int init = N/2 - 1;  // 돌 초기위치
			map[init][init] = 2;
			map[init][init+1] = 1;
			map[init+1][init] = 1;
			map[init+1][init+1] = 2;
			
			for(int i=0; i<M; i++) {
				int x = sc.nextInt() -1;
				int y = sc.nextInt() -1;
				
				int type = sc.nextInt();
				
				map[x][y] = type;
				
				for(int j=0; j<8; j++) {
					for(int k=1; k<=N; k++) {
						int nx = x+dx[j]*k;
						int ny = y+dy[j]*k;
						
						if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
							if(map[nx][ny] == 0) break;
							
							if(map[nx][ny] == map[x][y]) {
								for(int l=k; l>=1; l--) {
									nx -= dx[j];
									ny -= dy[j];
									
									map[nx][ny] = type;
								}
							}
						} 
					}

					
				}
				
			}
			
			int white = 0;
			int black = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1) {
						black++;
					}else if(map[i][j] == 2) {
						white++;
					}
				}
			}
			System.out.printf("#%d %d %d\n", tc, black, white);
			
		}
	}

}
