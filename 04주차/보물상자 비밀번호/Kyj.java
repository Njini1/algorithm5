import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
			int N = sc.nextInt();
			int K = sc.nextInt();
			char[] nums = sc.next().toCharArray();
			Deque<Character> dq = new ArrayDeque<>();
			for (char c : nums) {
				dq.add(c);
			}
			// rotate
			for (int rotate = 0; rotate < N / 4; rotate++) {
				for (int i = 0; i < N; i += N / 4) {
					Character[] tmp = new Character[dq.size()];
					dq.toArray(tmp);
					StringBuilder sb = new StringBuilder();
					// make a number
					for (int j = 0; j < N / 4; j++) {
						sb.append(tmp[i + j]);
					}
					int num = Integer.parseInt(sb.toString(), 16);
					if (!heap.contains(num)) {
						heap.offer(num);
					}
				}
				char tmp = dq.pollLast();
				dq.offerFirst(tmp);
			}
			// Find a Kth number
			int answer = 0;
			for (int i = 0; i < K; i++) {
				answer = heap.poll();
			}
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
