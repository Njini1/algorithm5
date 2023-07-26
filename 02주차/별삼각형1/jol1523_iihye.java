import java.util.Scanner;

public class jol1523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(n > 100 || m < 0 || m > 3) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		switch(m) {
		case 1: // 왼쪽 위에서 아래로 차례로 증가
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2: // 왼쪽 위에서 아래로 차례로 감소
			for(int i = 1; i <= n; i++) {
				for(int j = 0; j < (n-i+1); j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3: // 가운데에서 아래로 차례로 증가
			int left = (n*2-1) / 2;
			int right = (n*2-1) / 2;
			for(int i = 1; i <= n; i++) {
				for(int j = 0; j < (n*2-1); j++) {
					if(j >= left && j <= right) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				left--;
				right++;
				System.out.println();
			}
			break;
		}
	}
}
