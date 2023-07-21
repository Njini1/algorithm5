import java.util.*;

public class swea7272 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		// 입력
		int T = sc.nextInt(); // 테스트케이스의 개수
		for(int t = 1; t <= T; t++) {
			char[] arr_a = (sc.next()).toCharArray(); // 왼쪽 문자열 받기
			char[] arr_b = (sc.next()).toCharArray(); // 오른쪽 문자열 받기
			String ans = "SAME"; // 정답
			
			// 문자열 체크
			if(arr_a.length == arr_b.length) { // 길이가 같으면
				for(int i = 0; i < arr_a.length; i++) {
					int a = -1;
					int b = -1;
					
					// 왼쪽 문자열 변환
					switch(arr_a[i]) {
						case 'B':
							a = 2;
							break;
						case 'A': case 'D': case 'O': case 'P': case 'Q': case 'R':
							a = 1;
							break;
						default:
							a = 0;
							break;
					}
					
					// 오른쪽 문자열 변환
					switch(arr_b[i]) {
						case 'B':
							b = 2;
							break;
						case 'A': case 'D': case 'O': case 'P': case 'Q': case 'R':
							b = 1;
							break;
						default:
							b = 0;
							break;
					}
					
					// 두 문자열이 다르면
					if(a != b) {
						ans = "DIFF";
						break;
					}
				}
			} else { // 길이가 다르면
				ans = "DIFF";
			}
			
			// 출력
			System.out.printf("#%d %s\n", t, ans);
		}
	}
}
