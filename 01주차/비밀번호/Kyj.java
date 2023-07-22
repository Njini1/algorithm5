import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int len = sc.nextInt();
            String numArr = sc.next();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                int cur = numArr.charAt(i) - '0';
                if (stack.empty()) {
                    stack.push(cur);
                } else if (stack.peek() == cur) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
            System.out.printf("#%d ", tc);
            for (int n : stack) {
                System.out.print(n);
            }
            System.out.println();
        }
    }
}
