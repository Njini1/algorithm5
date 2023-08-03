import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int sum = 0;
			int cur = 0;
			int idx = 0;
			while (idx < str.length()) {
				if (idx + 1 < str.length() && str.charAt(idx) == '(' && str.charAt(idx + 1) == ')') {
					sum += cur;
					idx += 2;
				} else if (str.charAt(idx) == '(') {
					cur++;
					idx++;
				} else {
					sum++;
					cur--;
					idx++;
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}

}
