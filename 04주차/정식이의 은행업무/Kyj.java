import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Set<Integer> p1 = new HashSet<Integer>();
			Set<Integer> p2 = new HashSet<Integer>();
			String s1 = sc.next();
			String s2 = sc.next();
			int bin = Integer.parseInt(s1, 2);
			// 2진수
			for (int i = 0; i < s1.length(); i++) {
				p1.add(bin ^ (1 << i));
			}
			// 3진수
			for (int i = 0; i < s2.length(); i++) {
				StringBuilder sb = new StringBuilder(s2);
				for (int j = 0; j < 3; j++) {
					sb.setCharAt(i, (char) ('0' + j));
					p2.add(Integer.parseInt(sb.toString(), 3));
				}
			}
			p2.remove(Integer.parseInt(s2, 3));
			// 교집합
			p1.retainAll(p2);
			for (Integer answer : p1) {
				System.out.println("#" + tc + " " + answer);
			}
		}
	}
}
