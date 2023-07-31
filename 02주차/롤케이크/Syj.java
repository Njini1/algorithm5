import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Syj {
  static int M; //자르는 횟수
  static int result = 0; //자른 케이크 조각수
  static List<Integer> mulTen; //10이 아닌 10의 배수 숫자 저장
  static int notMulTen = 0; //10의 배수가 아닌 숫자 저장

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine(), " ");

    mulTen = new ArrayList<>();

    // 롤케이크 길이 값 받기
    for (int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(st.nextToken());

      if (tmp == 10) {
        // 10이면 자를 필요없으므로 결과값에 + 1
        result++;
      } else if (M != 0 && tmp == 20) {
        // 롤케이크 길이 중 20이 1번에 2개의 케이크를 가질 수 있기 때문에 우선으로 자름, M이 0일 때는 자를 수 없움
        result += 2;
        M--;
      } else if (tmp < 10) {
        // 10보다 작으면 자를 수 없으므로 저장x
        continue;
      } else if (tmp % 10 == 0) {
        // 10의 배수 저장
        mulTen.add(tmp);
      } else {
        // 10의 배수가 아닌 나머지를 10으로 나눈 값을 저장(한번 나눌때 한 개의 조각이 생김)
        notMulTen += tmp / 10;
      }
    }

    // 자를 수 있는 케이크가 있는 지 검사
    chkCut();
    // 10의 배수 길이인 케이크를 작은 순부터 검사 -> 케이크를 모두 10으로 잘랐을 때 자른 횟수보다 +1이 됨 => ex) 30을 2번
    // 나누면 3개, 50을 2번 나누면 2개
    Collections.sort(mulTen);
    // 10의 배수 케이크 자르는 메서드
    chkMultipleTen(mulTen);
    chkCut();
    // 10의 배수가 아닌 케이크들을 자를 수 있는 총 횟수보다 M이 작으면 M만큼 자름, 아니면 총 횟수만큼 자름(한번 자르면 1개의 조각)
    result += notMulTen <= M ? notMulTen : M;

    // 모든 롤케이크가 10보다 작은 경우 0출력
    // 자를 수 있는 최대 횟수를 다 안썼을 경우 이때까지 저장된 자른 케이크 값
    System.out.println(result);
  }

  // 자를 수 있는 횟수를
  private static void chkCut() {
    if (M == 0 || (mulTen.isEmpty() && notMulTen == 0)) {
      System.out.println(result);
      System.exit(0);
    }
  }

  private static void chkMultipleTen(List<Integer> list) {
    int tmp;
    for (Integer num : list) {
      tmp = num / 10 - 1;
      // 롤케이크 길이를 10으로 자를 수 있는 횟수가 M보다 작거나 같을 경우 자를 수 있는 만큼 자름
      if (M >= tmp) {
        M -= tmp;
        result += tmp + 1;
      } else {
        result += M;
        M = 0;
      }
    }
  }

}
