import java.util.*;

public class swea2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 받기
		int T = sc.nextInt();
		
		// 테스트케이스 반복
		for(int t = 1; t <= T; t++){
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int ans = 0;
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			int left = N / 2;
			int right = N / 2 + 1;
			for(int i = 0; i < (N / 2 + 1); i++) {
				System.out.printf("left ; %d right: %d", left, right);
				for(int j = left; j <= right; j++) {
					System.out.printf("i %d j %d map[i][j] %d\n", i, j, map[i][j]);
					ans += map[i][j];
				}
				left--;
				right++;
			}
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
