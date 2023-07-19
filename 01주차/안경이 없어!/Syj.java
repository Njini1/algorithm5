import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Syj {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String noBlank = "CEFGHIJKLMNSTUVWXYZ"; // 구멍이 없는 문자
    String oneBlank = "ADOPQR"; // 구멍 하나인 문자
    String twoBlank = "B"; // 구멍 두개인 문자
    int T = Integer.parseInt(br.readLine());

    for (int test_case = 1; test_case <= T; test_case++) {
      String result = "DIFF"; // 결과값
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String[] s1 = st.nextToken().split(""); // 비교할 문자1
      String[] s2 = st.nextToken().split(""); // 비교할 문자2

      if (s1.length == s2.length) { // 비교할 문자열의 길이가 같으면 검사함, 다르면 result 값의 초기값인 DIFF로 출력
        for (int i = 0; i < s1.length; i++) { // 두 문자열 비교
          if ((noBlank.contains(s1[i]) && noBlank.contains(s2[i])) // 두 문자열의 각 자리에 있는 값이 같은 곳에 포함되어있으면 SAME
              || (oneBlank.contains(s1[i]) && oneBlank.contains(s2[i]))
              || (twoBlank.contains(s1[i]) && twoBlank.contains(s2[i]))) {
            result = "SAME";
          } else {
            result = "DIFF"; // 각 자리의 문자가 다른 곳에 포함되어있으면 DIFF로 저장하고 break
            break;
          }
        }
      }
      System.out.println("#" + test_case + " " + result);
    }
  }
}