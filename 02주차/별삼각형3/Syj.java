import java.io.IOException;
import java.util.Scanner;

public class Syj {
  static int N;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    if (N % 2 == 0 || N < 0 || N > 101) {
      System.out.println("INPUT ERROR!");
      System.exit(0);
    }

    int k = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j <= k * 3; j++) {
        System.out.print(j < k ? ' ' : '*');
      }
      k += i < N / 2 ? 1 : -1;
      System.out.println();
    }
    sc.close();

  }

}
