import java.util.*;

public class swea6958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스의 개수
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 대회에 참여한 사람의 수
			int M = sc.nextInt(); // 문제의 개수
			
			int winner = 0; // 1등한 사람의 수
			int winScore = 0; // 문제의 수
			
			for(int n = 0; n < N; n++) {
				int temp = 0; // 점수
				for(int m = 0; m < M; m++) {
					temp += sc.nextInt();
				}
				
				if(temp > winScore) { // 현재 1등보다 많이 풀었으면
					winScore = temp;
					winner = 1;
				} else if(temp == winScore) { // 현재 1등과 똑같이 풀었으면
					winner++;
				}
			}
			
			System.out.println("#" + t + " " + winner + " " + winScore);
		}
	}
}
