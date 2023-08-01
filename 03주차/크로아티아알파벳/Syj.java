import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Syj {
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String data = br.readLine();
    String[] alphas = { "dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z=" };
    int result = 0;
    String tmp = "";
    for (String alpha : alphas) {
      if (data.contains(alpha)) {
        tmp = data.replace(alpha, " ");
        result += (data.length() - tmp.length()) / (alpha.length() - 1);
        data = tmp;
      }
    }
    data = data.replace(" ", "");
    System.out.println(result + data.length());
  }
}
