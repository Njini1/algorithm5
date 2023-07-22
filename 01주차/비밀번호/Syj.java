import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Syj {
  static Node node;
  static Node head;

  static class Node {
    char data;
    Node prev;
    Node next;

    Node(char data) {
      this.data = data;
      this.prev = null;
      this.next = null;
    }
  }

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int tc = 1; tc <= 10; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken());
      char[] value = st.nextToken().toCharArray();

      // 입력값 저장
      head = new Node(value[0]);
      Node tail = head;
      for (int j = 1; j < N; j++) {
        node = new Node(value[j]);
        if (head.next == null) {
          head.next = node;
          node.prev = head;
        } else {
          tail.next = node;
          node.prev = tail;
        }
        tail = node;
      }
      tail = new Node('t');
      tail.prev = node;
      node.next = tail;

      // 같은 값 검색후 삭제
      node = head;
      while (node.next != null) {
        if (node.data == node.next.data) {
          if (node.prev != null) {
            node.prev.next = node.next.next;
            node.next.next.prev = node.prev;
            node = node.prev;
          } else {
            head = node.next.next;
            head.prev = null;
            node = head;
          }
        } else {
          node = node.next;
        }
      }
      // 출력
      String result = "";
      node = head;
      while (node.next != null) {
        result += node.data;
        node = node.next;
      }

      System.out.println("#" + tc + " " + result);
    }
  }
}
