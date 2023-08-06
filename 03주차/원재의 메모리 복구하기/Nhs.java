package algorithm;
import java.util.Scanner;

public class Nhs {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int ans=0;
			String num = sc.next();
			int len = num.length();
			
			int[] arr = new int[len];
			
			for(int i=0; i<len; i++) {
				arr[i] = num.charAt(i) -'0';
			}
			
			for(int i=0; i<len; i++) {
				if(arr[i] == 1) {
					for(int j=i+1; j<len; j++) {
						if(arr[j] == 1) {
							arr[j] = 0;
						} else if(arr[j] == 0) {
							arr[j] = 1;
						}
					}
					ans++;
				}
			}
			System.out.println("#"+test_case +" "+ans);

		}
	}

}
