import java.util.*;

public class swea5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int ans = 0; // 자른 개수
			int stick = 0; // 막대기 개수
			
			String s = sc.next();
			for(int i = 0; i < s.length()-1; i++) { // 2개씩 살펴봄
				if(s.charAt(i) == '(' && s.charAt(i+1) == ')') { // 레이저
					ans += stick; // 막대기 잘림
					i++; // 레이저는 다음을 보지 않아도 됨
				} else if(s.charAt(i) == '(') { // 막대기 시작
					stick++; // 막대기 추가
				} else { // 막대기 끝
					stick--; // 막대기 하나 감소
					ans++; // 끝났으니 추가
				}
			}
            ans++; // 마지막 막대기 추가
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
