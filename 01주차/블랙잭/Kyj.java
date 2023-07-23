import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] cards = new int[n];
		for(int i = 0; i<n;i++) {
			cards[i] = sc.nextInt();
		}
		int answer = 0;
		for(int i = 0; i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					int sum = cards[i]+cards[j]+cards[k];
					if(sum<=m) {
						answer = Math.max(answer, sum);
					}
				}
			}
		}
		System.out.println(answer);
	}
}
