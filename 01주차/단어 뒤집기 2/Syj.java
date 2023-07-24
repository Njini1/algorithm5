import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Syj {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    Deque<Character> deque = new LinkedList<>();
    boolean isTag = false;

    for (int i = 0; i < str.length(); i++) {

      if (str.charAt(i) == '<') {
        popWord(deque); // '<'나오기 전 단어 뒤집기
        isTag = true;
        deque.add(str.charAt(i));
      } else if (str.charAt(i) == '>') {
        // 1. '>'이 들어올경우 태그이므로 앞에서 뽑아냄
        deque.add('>');
        while (!deque.isEmpty()) {
          System.out.print(deque.poll());
        }
        isTag = false;
      } else if (!isTag && str.charAt(i) == ' ') {
        // 2.태그가 아니고 단어일때
        popWord(deque);
        System.out.print(" ");
      } else {
        deque.add(str.charAt(i));
      }
    }
    popWord(deque);
  }

  private static void popWord(Deque<Character> deque) {
    while (!deque.isEmpty()) {
      System.out.print(deque.pollLast());
    }
  }
}
