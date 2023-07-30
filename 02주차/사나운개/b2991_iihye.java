import java.util.*;

public class b2991 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt(); // 공격적
		int B = sc.nextInt(); // 쉼
		int C = sc.nextInt(); // 공격적
		int D = sc.nextInt(); // 쉼
		
		for(int i = 0; i < 3; i++) {
			int temp = sc.nextInt();
			int ans = 0;
			
			if((temp % (A+B) > 0) && (temp % (A+B) <= A)) { // 첫번째 개의 공격
				ans++;
			}
			
			if((temp % (C+D) > 0) && (temp % (C+D) <= C)) { // 두번째 개의 공격
				ans++;
			}
			
			System.out.println(ans);
		}
		
	}

}
