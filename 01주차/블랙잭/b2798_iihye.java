import java.util.*;

public class b2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 카드의 개수
		int M = sc.nextInt(); // 카드의 합
		int[] cards = new int[N]; // 카드의 숫자
		for(int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		int ans = 0; // M에 가까운 카드의 합
		
		for(int i = 0; i < N-2; i++) {
			for(int j = i+1; j < N-1; j++) {
				for(int k = j+1; k < N; k++) {
					int temp = cards[i] + cards[j] + cards[k]; // 카드의 합
					if(temp <= M && Math.abs(temp-M) < Math.abs(ans-M)) { // M을 넘지 않으면서 차가 작을 때
						ans = temp;
					}
				}
			}
		}
		System.out.printf("%d", ans);
	}
}
