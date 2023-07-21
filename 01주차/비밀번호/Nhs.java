import java.util.Scanner;
import java.util.Stack;

public class Nhs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String str = sc.next();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if (stack.isEmpty() || stack.peek() != c) {
					stack.push(c);
				} else {
					stack.pop();
				}

			}
			System.out.printf("#%d ",tc);
			for(char c : stack) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

}
