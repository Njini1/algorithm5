package algorithm;
import java.util.Scanner;

public class Nhs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] count = new int[N];
		
		int now = 0;
		
		while (true) {
			count[now] += 1;
			if (count[now] >= M) break;
			
			if (count[now] % 2 != 0) {
				now = (now + L) % N;
			}else {
				if (now - L < 0) {
					now = N + now - L;
				}else {
					now -= L;
				}
			}
		}
		int res = 0;
		for(int ele : count) {
			res += ele;
		}
		System.out.println(res-1);
		
	}

}
