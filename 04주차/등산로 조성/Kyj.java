import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			answer = Integer.MIN_VALUE;
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] arr = new int[n][n];
			int max = Integer.MIN_VALUE;
			ArrayList<Point> li = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
					if (max < arr[i][j]) {
						li.clear();
						li.add(new Point(i, j));
						max = arr[i][j];
					} else if (max == arr[i][j]) {
						li.add(new Point(i, j));
					}
				}
			}
			//
			for (int i = 0; i < li.size(); i++) {
				dfs(li.get(i), arr, 0, new boolean[n][n], false, k);
			}
			System.out.println("#" + tc + " " + (answer + 1));

		}
	}

	private static void dfs(Point s, int[][] arr, int cnt, boolean[][] visited, boolean dig, int k) {
//		System.out.println(s.x + " " + s.y);
		int n = arr.length;
		visited[s.x][s.y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = s.x + dx[i];
			int ny = s.y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				continue;
			}
			if (visited[nx][ny])
				continue;
			visited[nx][ny] = true;
			if (dig == false) {
				for (int j = 1; j <= k; j++) {
					if (arr[s.x][s.y] > arr[nx][ny] - j) {
						arr[nx][ny] -= j;
						dfs(new Point(nx, ny), arr, cnt + 1, visited, true, k);
						arr[nx][ny] += j;
					}
				}
			}
			if (arr[s.x][s.y] > arr[nx][ny]) {
				dfs(new Point(nx, ny), arr, cnt + 1, visited, dig, k);
			}
			visited[nx][ny] = false;
		}

		answer = Math.max(cnt, answer);
	}
}
