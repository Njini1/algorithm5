import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			String command = st.nextToken();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ArrayDeque<Integer> q = new ArrayDeque<>();
			boolean merged = false;
			if (command.equals("left")) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++)  {
						if (map[i][j] == 0) continue;
						else if (!merged && !q.isEmpty() && q.getLast() == map[i][j]) {
							q.pollLast();
							q.offer(map[i][j] * 2);
							merged = true;
						} else {
							q.offer(map[i][j]);
							merged = false;
						}
					}
					for (int j = 0; j < N; j++) {
						if (!q.isEmpty()) map[i][j] = q.poll();
						else map[i][j] = 0;
					}
				}
			} else if (command.equals("right")) {
				for (int i = 0; i < N; i++) {
					for (int j = N - 1; j >= 0; j--)  {
						if (map[i][j] == 0) continue;
						else if (!merged && !q.isEmpty() && q.getLast() == map[i][j]) {
							q.pollLast();
							q.offer(map[i][j] * 2);
							merged = true;
						} else {
							q.offer(map[i][j]);
							merged = false;
						}
					}
					for (int j = N - 1; j >= 0; j--) {
						if (!q.isEmpty()) map[i][j] = q.poll();
						else map[i][j] = 0;
					}
				}
			} else if (command.equals("up")) {
				for (int j = 0; j < N; j++) {
					for (int i = 0; i < N; i++)  {
						if (map[i][j] == 0) continue;
						else if (!merged && !q.isEmpty() && q.getLast() == map[i][j]) {
							q.pollLast();
							q.offer(map[i][j] * 2);
							merged = true;
						} else {
							q.offer(map[i][j]);
							merged = false;
						}
					}
					for (int i = 0; i < N; i++) {
						if (!q.isEmpty()) map[i][j] = q.poll();
						else map[i][j] = 0;
					}
				}
			} else if (command.equals("down")) {
				for (int j = 0; j < N; j++) {
					for (int i = N - 1; i >= 0; i--)  {
						if (map[i][j] == 0) continue;
						else if (!merged && !q.isEmpty() && q.getLast() == map[i][j]) {
							q.pollLast();
							q.offer(map[i][j] * 2);
							merged = true;
						} else {
							q.offer(map[i][j]);
							merged = false;
						}
					}
					for (int i = N - 1; i >= 0; i--) {
						if (!q.isEmpty()) map[i][j] = q.poll();
						else map[i][j] = 0;
					}
				}
			}

			System.out.printf("#%d\n", tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
