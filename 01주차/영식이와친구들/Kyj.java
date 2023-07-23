import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int answer = 0;
		int[] cnt = new int[n];
		cnt[0] = 1;
		int cur = 0;
		while(cnt[cur]<m) {
			if(cnt[cur]%2==0){
				cur = (cur+n-l)%n;
			}else {
				cur = (cur+l)%n;
			}
			answer++;
			cnt[cur]++;
		}
		System.out.println(answer);
	}
}
