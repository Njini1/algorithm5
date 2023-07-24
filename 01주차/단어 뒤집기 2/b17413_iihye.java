import java.io.*;
import java.util.*;

public class b17413 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine(); // 읽어오기
		Stack<Character> stack = new Stack<>(); // 스택 선언
		boolean flag = false; // <> 확인
		StringBuilder ans = new StringBuilder(); // 정답 만들 StringBuilder 선언
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i); // 현재 리턴된 문자
			
			if(c == '<') { // < 를 만나면
				while(!stack.isEmpty()) { // stack이 비어있을 때까지
					ans.append(stack.pop()); // stack에 있는거 꺼내서 정답으로
				}
				flag = true; // > 찾아야 함
			} else if(c == '>') { // > 를 만나면
				flag = false; // > 찾음
				ans.append(c); // > 정답으로
				continue;
			}
			
			if(flag == true) { // < 를 만나 순서대로 입력하기
				ans.append(c); 
			} else { 
				if(c == ' ') { // 공백을 만나면
					while(!stack.isEmpty()) { // stack이 비어있을 때까지
						ans.append(stack.pop()); // stack에 있는거 꺼내서 정답으로
					}
					ans.append(c); // 공백 정답으로
					continue;
				} else { // 공백이 아니면
					stack.push(c); // stack에 추가하기
				}
			}
		}
		
		while(!stack.isEmpty()) { // stack에 남아있는 게 있으면
			ans.append(stack.pop()); // stack에 있는거 꺼내서 정답으로
		}
		
		System.out.println(ans);
		
	}

}
