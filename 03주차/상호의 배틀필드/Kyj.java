import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			char[][] arr = new char[h][w];
			int x = 0;
			int y = 0;
			Map<Character, Integer> car = new HashMap<>();
			car.put('^', 0);
			car.put('>', 1);
			car.put('v', 2);
			car.put('<', 3);
			car.put('U', 0);
			car.put('R', 1);
			car.put('D', 2);
			car.put('L', 3);
			Map<Integer, Character> revCar = new HashMap<>();
			revCar.put(0, '^');
			revCar.put(1, '>');
			revCar.put(2, 'v');
			revCar.put(3, '<');
			int dir = -1;
			for (int i = 0; i < h; i++) {
				String tmp = sc.next();
				for (int j = 0; j < w; j++) {
					char c = tmp.charAt(j);
					if (car.get(c) != null) {
						dir = car.get(c);
						x = i;
						y = j;
						c = '.';
					}
					arr[i][j] = c;
				}
			}
			int n = sc.nextInt();
			String cmd = sc.next();
			// input end
			int[] dx = { -1, 0, 1, 0 };
			int[] dy = { 0, 1, 0, -1 };
			int nx = x;
			int ny = y;
			for (int _ = 0; _ < cmd.length(); _++) {
				char c = cmd.charAt(_);
				switch (c) {
				case 'S':
					int bx = nx;
					int by = ny;
					while (true) {
						bx = bx + dx[dir];
						by = by + dy[dir];
						if (bx < 0 || bx >= h || by < 0 || by >= w || arr[bx][by] == '#') {
							break;
						}
						if (arr[bx][by] == '*') {
							arr[bx][by] = '.';
							break;
						}
					}
					break;
				default:
					dir = car.get(c);
					int tx = nx + dx[dir];
					int ty = ny + dy[dir];

					if (!(tx < 0 || tx >= h || ty < 0 || ty >= w || arr[tx][ty] != '.')) {
						nx = tx;
						ny = ty;
					}
					break;
				}
			}
			arr[nx][ny] = revCar.get(dir);
			System.out.print("#" + tc + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		} // tc end
	}
}
