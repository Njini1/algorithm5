import java.util.Scanner;

public class Syj {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int L = sc.nextInt();

    int[] p = new int[N + 1];
    int idx = 1;
    int count = 0;
    p[1] = 1;
    while (p[idx] != M) {
      if (p[idx] % 2 == 1) { // 홀수면 시계방향
        idx = idx + L > N ? (idx + L) - N : idx + L;
      } else {
        idx = idx - L > 0 ? idx - L : N - (L - idx);
      }
      p[idx] += 1;
      count++;
    }
    System.out.println(count);
    sc.close();
  }
}