import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] matrix = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		int[] d1 = {0, 1, 0, -1};
		int[] d2 = {1, 0, -1, 0};
		int direction = 0;
		int x = 0;
		int y = -1;
		int num = 1;
		
		while (num <= n * n) {
			int next_x = x + d1[direction];
			int next_y = y + d2[direction];
			if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < n && !visited[next_x][next_y]) {
				x = next_x;
				y = next_y;
				matrix[x][y] = num++;
				visited[x][y] = true;
			} else {
				direction = (direction + 1) % 4;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
