import java.util.Scanner;

public class Nhs {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] scores = new int[N];
			int max = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				int temp = 0;
				for (int j = 0; j <M; j++) {
					temp += sc.nextInt();
				}
				scores[i] += temp;
				if(scores[i] > max) max = scores[i];
			}
			for(int i=0; i<N; i++) {
				if(max == scores[i]) cnt++;
			}
			System.out.printf("#%d %d %d\n", tc, cnt, max);
		}
	}

}
