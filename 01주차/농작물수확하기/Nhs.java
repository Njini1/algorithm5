import java.util.Scanner;

public class Nhs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();			
			int[][] map = new int[N][N];
			
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				String temp = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = (int) temp.charAt(j) -'0';
				}
			}
			

			for (int i = 0; i < N/2; i++) {
				for (int j = N/2 - i; j <= N/2 +i; j++) {
					sum += map[i][j];
				}
			}
			
			for (int i = N/2; i >= 0; i--) {
				for (int j = N/2 - i; j <= N/2 + i; j++) {
					sum += map[N-i-1][j];
				}
			}
			System.out.printf("#%d %d", tc, sum);
			System.out.println();
		}
		
		sc.close();
	}

}