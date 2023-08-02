import java.util.*;

public class Solution {
	static final int LENGTH = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[LENGTH];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 0; i < n; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[arr.length - 1]--;
			}
			Arrays.sort(arr);
			System.out.printf("#%d %d\n", tc, (arr[arr.length - 1] - arr[0]));
		}
	}
}
