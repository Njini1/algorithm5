import java.util.*;

public class swea1234 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10; // 테스트 케이스의 개수
		for(int t = 1; t <= T; t++) {
			// 입력
			int n = sc.nextInt(); // 문자의 총 수
			String str = sc.next(); // 문자열
			Stack<Integer> stack = new Stack<>(); // Integer형 스택 선언
			
			// 구현
			for(int i = 0; i < n; i++) {
				int temp = str.charAt(i)-'0'; // 숫자로 변환
				if(stack.empty()) { // 스택이 비어 있으면
					stack.push(temp); // 스택에 push
				} else { // 스택이 비어 있지 않으면
					if(stack.peek() == temp) { // 제일 상단의 값과 현재 값이 같은지 확인
						stack.pop(); // 같으면 pop
					} else { // 같지 않으면
						stack.push(temp); // 스택에 push
					} 
				}
			}
			
			// 출력
			System.out.printf("#%d ", t);
			for(Integer i: stack) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
