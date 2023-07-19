import java.util.Scanner;

class Yj {

  public static String Look(String s) {
    return s
      .replaceAll("[CEFGHIJKLMNSTUVWXYZ]", "0")
      .replaceAll("[ADOPQR]", "1")
      .replace("B", "2");
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int tc = 1; tc < T + 1; tc++) {
      String a = sc.next();
      String b = sc.next();
      a = Look(a);
      b = Look(b);
      System.out.printf("#%d %s\n", tc, a.equals(b) ? "SAME" : "DIFF");
    }
    sc.close();
  }
}
