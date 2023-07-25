import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        if (n > 100) {
            System.out.println("INPUT ERROR!");
            return;
        }
		int m = sc.nextInt();
		
		if (m == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (m == 2) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (m == 3) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < (i + 1) * 2 - 1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else {
            System.out.println("INPUT ERROR!");
        }
	}

}
