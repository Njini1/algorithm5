import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String numbers = br.readLine();
			numbers += numbers.substring(0, N / 4 - 1);
			Set<Integer> hs = new HashSet<>();
			for (int i = 0; i < N; i++) {
				hs.add(Integer.parseInt(numbers.substring(i, i + N / 4), 16));
			}
			Integer[] passwords = hs.toArray(new Integer[hs.size()]);
			Arrays.sort(passwords, (o1, o2) -> {return o2 - o1;});
			System.out.printf("#%d %d\n", tc, passwords[K - 1]);
		}
	}

}
