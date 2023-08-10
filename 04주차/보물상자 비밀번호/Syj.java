import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
 
public class Syj {
    static int N, K;
  
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); //숫자의 개수
            K = Integer.parseInt(st.nextToken()); //크기 순서
            String input = br.readLine();
            if (K == 0) {
                System.out.println("#" + tc + " 0");
                continue;
            }
             
            Set<Integer> pw = new TreeSet<>(Collections.reverseOrder());
            int size = N/4;
            int tmp = 0;
            for (int i = 0; i < input.length(); i++) {
                try {
                    tmp = Integer.parseInt(input.substring(i, i + size), 16);
                }catch(StringIndexOutOfBoundsException e) {
                    tmp = Integer.parseInt(input.substring(i) + input.substring(0, i + size - input.length()), 16);
                }
                pw.add(tmp);
            }
 
            int idx = 0;
            for (Integer p : pw) {
                if (++idx == K) {
                    System.out.println("#" + tc + " " + p);
                }
                 
            }
 
        }
    }
  }
