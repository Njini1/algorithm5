import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HelloJava {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] time = new int[T];
		for (int i = 0; i < T; i ++) {
			time[i] = Integer.parseInt(st.nextToken());	
		}
		Arrays.sort(time);
		int sum = 0;
		for (int c = 0; c < T; c++) {
			sum += time[c] * (T-c);
		}
		System.out.println(sum);
    }
}
