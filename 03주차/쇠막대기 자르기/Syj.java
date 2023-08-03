import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Syj {
  static String stick;
  static int N;
   
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
      int T = Integer.parseInt(br.readLine());
      boolean isRaiser; 
      Stack<Character> stack = new Stack<>();
      int result;
 
      for (int tc = 1; tc <= T; tc++) {
          stick = br.readLine();
          result = 0;
          isRaiser = false;
 
          for (int i = 0; i < stick.length(); i++) {
               
              if (stick.charAt(i) == '(') {
                  if (isRaiser) {
                      isRaiser = false;
                  }
                  stack.add('(');
              } else { // ')'일때
                  stack.pop();
                  if (!isRaiser) {
                      //레이저임
                      result += stack.size();
                      isRaiser = true;
                  } else {
                      //스택에 마지막에 있는 막대기의 끝임
                      result += 1;
                  }
              }
          }
          System.out.println("#" + tc + " " + result);
      }
       
  }
 
}
