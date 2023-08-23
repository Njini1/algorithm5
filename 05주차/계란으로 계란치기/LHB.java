import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, S[], W[], answer;
	static boolean broken[];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		W = new int[N];
		answer = 0;
		broken = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			W[i] = Integer.parseInt(st.nextToken());
		}
		
		break_egg(0, 0);
		System.out.println(answer);
	}

	private static void break_egg(int n, int cnt) {
		if (n == N) {
			return;
		}
		if (broken[n]) {
			break_egg(n + 1, cnt);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!broken[i] && i != n) {
				int temp = 0;
				S[n] -= W[i];
				S[i] -= W[n];
				if (S[n] <= 0) {
					broken[n] = true;
					temp++;
				}
				if (S[i] <= 0) {
					broken[i] = true;
					temp++;
				}
				if (cnt + temp > answer) answer = cnt + temp;
				break_egg(n + 1, cnt + temp);
				broken[i] = false;
				broken[n] = false;
				S[i] += W[n];
				S[n] += W[i];				
			}
		}
	}
	
}
