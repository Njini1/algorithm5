import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Syj {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        String m;
        char pre;
        int result;
        for (int tc = 1; tc <= T; tc++) {
            m = br.readLine();
            pre = '0';
            result = 0;
            for (int i = 0; i < m.length(); i++) {
                if (pre != m.charAt(i)) {
                    result++;
                }
                pre = m.charAt(i);
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
