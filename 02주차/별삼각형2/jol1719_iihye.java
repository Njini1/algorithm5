import java.util.*;

public class jol1719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 삼각형의 높이
		int m = sc.nextInt(); // 삼각형의 종류
		if(!(n > 0 && n <= 100 && n % 2 == 1 && m >= 1 && m <= 4)) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		int t, left, right;
		
		switch(m) { 
		case 1: // 왼쪽에서 오른쪽으로 차례로 감소
			t = 1;
			for(int i = 0; i < n; i++) {
				if(i < (n / 2)) { // 윗줄
					for(int j = 0; j < t; j++) {
						System.out.print("*");
					}
					t++;
				} else { // 아랫줄
					for(int j = 0; j < t; j++) {
						System.out.print("*");
					}
					t--;
				}
				System.out.println();
			}
			break;
		case 2: // 오른쪽에서 왼쪽으로 차례로 감소
			t = n / 2;
			for(int i = 0; i < n; i++) {
				if(i < (n / 2)) { // 윗줄
					for(int j = 0; j < t; j++) {
						System.out.print(" ");
					}
					for(int j = t; j < (n / 2 + 1); j++) {
						System.out.print("*");
					}
					t--;					
				} else { // 아랫줄
					for(int j = 0; j < t; j++) {
						System.out.print(" ");
					}
					for(int j = t; j < (n / 2 + 1); j++) {
						System.out.print("*");
					}
					t++;
				}
				System.out.println();
			}
			break;
		case 3: // 위에서 아래로 감소하다가 다시 증가
			t = n / 2;
			left = 0;
			right = n;
			for(int i = 0; i < n; i++) {
				if(i < (n / 2)) { // 윗줄
					for(int j = 0; j < n; j++) {
						if(j >= left && j < right) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
					left++;
					right--;
				} else { // 아랫줄
					for(int j = 0; j < n; j++) {
						if(j >= left && j < right) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
					left--;
					right++;
				}
				System.out.println();
			}
			break;
		case 4: // 대각선으로 감소하면서 다시 증가
			t = n / 2;
			left = 0;
			right = t + 1;
			for(int i = 0; i < n; i++) {
				if(i < (n / 2)) { // 윗줄
					for(int j = 0; j < n; j++) {
						if(j >= left && j < right) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
					left++;
				} else { // 아랫줄
					for(int j = 0; j < n; j++) {
						if(j >= left && j < right) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
					right++;
				}
				System.out.println();
			}
			break;
		}
	}
}
