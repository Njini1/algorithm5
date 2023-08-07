import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] arr = new int[n][m];
			int people = 0;
			int score = 0;
			for (int i = 0; i < n; i++) {
				int tmp = 0;
				for (int j = 0; j < m; j++) {
					arr[i][j] = sc.nextInt();
					tmp += arr[i][j];
				}
				if (score < tmp) {
					score = tmp;
					people = 1;
				} else if (score == tmp) {
					people++;
				}
			}
			System.out.printf("#%d %d %d\n", tc, people, score);
		}
	}
}
