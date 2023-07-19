import java.util.Scanner;
import java.util.Arrays;

public class Swea7272 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		char[] one_hole = "ADOPQR".toCharArray();

		for (int tc = 1; tc <= T; tc++) {
			char[] first = sc.next().toCharArray();
			char[] second = sc.next().toCharArray();
			
			
			if (first.length != second.length) {
				System.out.println("#"+tc+" "+"DIFF");
				continue;
			}
			
			for (int i = 0; i < first.length; i++) {
				boolean is_one_hole = false;
				if (first[i] == 'B') {
					first[i] = 2;
				} else {
					for (int j = 0; j < one_hole.length; j++) {
						if (first[i] == one_hole[j]) {
							first[i] = 1;
							is_one_hole = true;
							break;
						}
					}
					if (!is_one_hole) first[i] = 0;
				}
				is_one_hole = false;
				if (second[i] == 'B') {
					second[i] = 2;
				} else {
					for (int j = 0; j < one_hole.length; j++) {
						if (second[i] == one_hole[j]) {
							second[i] = 1;
							is_one_hole = true;
							break;
						}
					}
					if (!is_one_hole) second[i] = 0;
				}
			}
			if (Arrays.equals(first, second)) {
				System.out.println("#"+tc+" "+"SAME");
			} else {
				System.out.println("#"+tc+" "+"DIFF");
			}
			
			
		}
		
		sc.close();
	}

}
