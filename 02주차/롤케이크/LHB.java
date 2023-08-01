import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int count = 0;
		List<Integer> cakes1 = new ArrayList<>();
		List<Integer> cakes2 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int cake = sc.nextInt();
			if (cake < 10) {
				continue;
			} else if (cake == 10) {
				count++;
			} else if (cake % 10 == 0) {
				cakes1.add(cake);
			} else if (cake > 10) {
				cakes2.add(cake);
			}
		}
		Collections.sort(cakes1);
		while (M > 0 && !cakes1.isEmpty()) {
			if (cakes1.get(0) == 20) {
				cakes1.remove(0);
				count += 2;
				M--;
			} else {
				cakes1.set(0, cakes1.get(0) - 10);
				count += 1;
				M--;
			}
		}
		while (M > 0 && !cakes2.isEmpty()) {
			if (cakes2.get(0) < 20) {
				cakes2.remove(0);
				count += 1;
				M--;
			} else {
				cakes2.set(0, cakes2.get(0) - 10);
				count += 1;
				M--;
			}
		}
		System.out.println(count);
	}

}
