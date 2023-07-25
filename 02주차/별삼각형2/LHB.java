import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        if (n > 100 || n % 2 == 0) {
            System.out.println("INPUT ERROR!");
            return;
        }
		int m = sc.nextInt();
		
		int half = n / 2;
		int weight = 0;
		if (m == 1) {
			for (int i = 0; i < n; i++) {
				if (i <= half) weight++;
				else weight--;
				for (int j = 0; j < weight; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (m == 2) {
			for (int i = 0; i < n; i++) {
				if (i <= half) weight++;
				else weight--;
				for (int j = 0; j < half - weight + 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < weight; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (m == 3) {
			for (int i = 0; i < n; i++) {
				if (i <= half) weight++;
				else weight--;
				for (int j = 0; j < weight - 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < (half - weight + 1) * 2 + 1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (m == 4) {
			for (int i = 0; i < n; i++) {
				if (i <= half) {
					weight++;
					for (int j = 0; j < weight - 1; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < half + 2 - weight; j++) {
						System.out.print("*");
					}
				} else {
					weight--;
					for (int j = 0; j < half; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < half - weight + 2; j++) {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		} else {
            System.out.println("INPUT ERROR!");
        }
	}
	
}
