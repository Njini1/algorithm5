import java.util.*;

public class b11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 사람의 수
		int[] P = new int[N]; // 인출하는데 걸리는 시간
		for(int i = 0; i < N; i++) {
			P[i] = sc.nextInt();
		}
		int ans = 0;
		
		Arrays.sort(P);	// 정렬
		for(int i = 0; i < N; i++) { // 시간의 합
			ans += P[i] * (N-i);
		}
		
		System.out.println(ans);
	}
}
