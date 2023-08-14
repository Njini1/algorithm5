import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Syj {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      String tmp = br.readLine();
      int a = Integer.parseInt(tmp, 2);
      StringBuilder c = new StringBuilder(br.readLine());
      // String c = br.readLine();
      // String tmp2 = br.readLine();
      // int b = Integer.parseInt(tmp2, 3);
      // System.out.println(b);

      List<Integer> list1 = new ArrayList<>();
      // 이진수를 10진수로
      // System.out.println(a ^ (1 << 1));
      for (int i = 0; i < tmp.length(); i++) {
        list1.add(a ^ 1 << i);
      }

      List<Integer> list2 = new ArrayList<>();
      // 삼진수를 10진수로
      for (int i = 0; i < c.length(); i++) {
        char t = c.charAt(i);
        switch (c.charAt(i)) {
          case '0':
            c.setCharAt(i, '1');
            list2.add(Integer.parseInt(String.valueOf(c), 3));
            c.setCharAt(i, '2');
            list2.add(Integer.parseInt(String.valueOf(c), 3));
            break;
          case '1':
            c.setCharAt(i, '0');
            list2.add(Integer.parseInt(String.valueOf(c), 3));
            c.setCharAt(i, '2');
            list2.add(Integer.parseInt(String.valueOf(c), 3));
            break;
          case '2':
            c.setCharAt(i, '1');
            list2.add(Integer.parseInt(String.valueOf(c), 3));
            c.setCharAt(i, '0');
            list2.add(Integer.parseInt(String.valueOf(c), 3));
            break;
        }
        c.setCharAt(i, t);
      }
      list1.retainAll(list2);

      System.out.println("#" + tc + " " + list1.get(0));

    }
  }
}
