import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static int temp, temp2;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String binary = br.readLine();
			String ternary = br.readLine();
			Integer.parseInt(binary, 2);
			flag = false;
			int b_int = 0;
			int t_int = 0;
			for (int i = 0; i < binary.length(); i++) {
				if (binary.charAt(i) == '1') {
					b_int += 1 << (binary.length() - i - 1);
				}
			}
			for (int i = 0; i < ternary.length(); i++) {
				if (ternary.charAt(i) == '1') {
					t_int += Math.pow(3, ternary.length() - i - 1);
				} else if (ternary.charAt(i) == '2') {
					t_int += Math.pow(3, ternary.length() - i - 1) * 2;
				}
			}
			for (int i = 0; i < binary.length(); i++) {
				if (binary.charAt(i) == '0') {
					temp = b_int + (1 << (binary.length() - i - 1));
				} else {
					temp = b_int - (1 << (binary.length() - i - 1));
				}
				for (int j = 0; j < ternary.length(); j++) {
					int t = (int)Math.pow(3, ternary.length() - j - 1);
					if (ternary.charAt(j) == '0') {
						temp2 = t_int + t;
						if (temp == temp2) flag = true;
						temp2 = t_int + t * 2;
						if (temp == temp2) flag = true;
					} else if (ternary.charAt(j) == '1') {
						temp2 = t_int + t;
						if (temp == temp2) flag = true;
						temp2 = t_int - t;
						if (temp == temp2) flag = true;
					} else {
						temp2 = t_int - t;
						if (temp == temp2) flag = true;
						temp2 = t_int - t * 2;
						if (temp == temp2) flag = true;
					}
				}
				if (flag) break;
			}
			System.out.printf("#%d %d\n", tc, temp);
		}
	}

}
