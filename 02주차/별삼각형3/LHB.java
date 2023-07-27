import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        if (n > 100 || n % 2 == 0) {
            System.out.println("INPUT ERROR!");
            return;
        }
		
		int half = n / 2;
		int weight = 0;
		for (int i = 0; i < n; i++) {
			if (i <= half) weight++;
			else weight--;
			
			for (int j = 0; j < weight - 1; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int j = 0; j < (weight - 1) * 2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
