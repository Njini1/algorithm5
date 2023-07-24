import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		boolean tag_mode = false;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '<') {
				while (!stack.empty()) {
					System.out.print(stack.pop());
				}
				tag_mode = true;
				System.out.print('<');
			} else if (c == '>') {
				tag_mode = false;
				System.out.print('>');
			} else {
				if (tag_mode) {
					System.out.print(c);
				} else {
					if (c == ' ') {
						while (!stack.empty()) {
							System.out.print(stack.pop());
						}
						System.out.print(' ');
					} else {
						stack.add(c);
					}
				}
			}
		}
		while (!stack.empty()) {
			System.out.print(stack.pop());
		}
	}

}
