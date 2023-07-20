import java.util.*;

public class swea7272 {
	public static void main(String[] args) {
		char[] one_dic = {'A', 'D', 'O', 'P', 'Q', 'R'}; // 구멍의 개수가 하나
		char[] two_dic = {'B'};	// 구멍의 개수가 둘
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 받기
		int T = sc.nextInt();

		// 테스트케이스 반복
		for(int t = 1; t <= T; t++) {
			String ans = "";
			
			// 문자열 받기
			char[] arr_a = (sc.next()).toCharArray();
			char[] arr_b = (sc.next()).toCharArray();
			
			int a = 0;
			int b = 0;
			
			// 구멍의 개수
			for(int i = 0; i < arr_a.length; i++) {
				for(int j = 0; j < one_dic.length; j++) {
					if(arr_a[i] == one_dic[j]) {
						a++;
					}
				}
				if(arr_a[i] == two_dic[0]) {
					a = a+2;
				}
			}
				
			for(int m = 0; m < arr_b.length; m++) {
				for(int n = 0; n < one_dic.length; n++) {
					if(arr_b[m] == one_dic[n]) {
						b++;
					}
				}
				if(arr_b[m] == two_dic[0]) {
					b = b+2;
				}
			}
			
			// 구멍의 개수가 같으면 SAME
			if(a == b) {
				ans = "SAME";
			} // 구멍의 개수가 다르면 DIFF
			else {
				ans = "DIFF";
			}
			System.out.printf("#%d %s\n", t, ans);
		}
	}
}
