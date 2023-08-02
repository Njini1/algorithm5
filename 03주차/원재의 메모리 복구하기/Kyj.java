import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] memory = sc.next().toCharArray();
			char prev = '0';
			int answer = 0;
			for (int i = 0; i < memory.length; i++) {
				if (memory[i] != prev) {
					answer++;
				}
				prev = memory[i];
			}
			System.out.printf("#%d %d\n",tc,answer);
		}
	}
}
