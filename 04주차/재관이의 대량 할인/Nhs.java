import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.swing.text.AbstractDocument.BranchElement;

public class Nhs {
	private static int T;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Arrays.sort(num,Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); 
			Integer[] arr = new Integer[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, Collections.reverseOrder());
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if((i+1) % 3 ==0) continue;
				sum += arr[i];
			}
			
			System.out.printf("#%d %d\n", tc, sum);
		}
		
	}

}
