import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class swea1289 {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("swea1289_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 개수
		for(int t = 1; t <= T; t++) {
			String str = sc.next(); // 비트
			char temp = '0';
			int ans = 0;
			for(int s = 0; s < str.length(); s++) {
				if (temp != str.charAt(s)) {
					ans++;
					temp = str.charAt(s);
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
