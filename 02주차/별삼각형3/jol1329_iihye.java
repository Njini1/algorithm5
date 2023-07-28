import java.util.*;

public class jol1329 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(!(n > 0 && n <= 100 && n % 2 == 1)) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		int stars = 1;
		int blanks = 0;
		
		for(int i = 0; i < n; i++) {
			for(int b = 0; b < blanks; b++) {
				System.out.print(" ");
			}
			if(i < (n/2)) {
				for(int j = 0; j < n; j++) {
					if(j < stars) {
						System.out.print("*");
					}
				}
				stars += 2;
				blanks++;
			}
			else {
				for(int j = 0; j < n; j++) {
					if(j < stars) {
						System.out.print("*");
					}
				}
				stars -= 2;
				blanks--;
			}
			System.out.println();
		}
	}

}
