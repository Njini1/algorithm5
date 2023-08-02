import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int answer = 0;
			char[] brackets = sc.next().toCharArray();
			for (int i = 0; i < brackets.length; i++) {
				if (brackets[i] == '(') {
					stack.add(0);
				} else if (brackets[i - 1] == '(') {
					stack.pop();
					answer += stack.size();
				} else {
					stack.pop();
					answer++;
				}

			}
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
