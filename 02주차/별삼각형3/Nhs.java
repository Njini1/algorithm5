import java.util.Scanner;
public class Nhs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	
		if(0 > n || 100 < n || n%2==0) {
			System.out.println("INPUT ERROR!");
			return;
		}

		for(int i=0; i<n; i++) {
			if(i <= n/2) {
				for(int j=0; j<i; j++) {
					System.out.print(" ");
				}
				for(int j=0; j<i*2 + 1; j++) {
					System.out.print("*");
				}
			}else {
				for (int j = 0; j < n-i-1; j++) {
					System.out.print(" ");
				}
				for (int j=0; j<(n-i)*2-1; j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
	}
}
