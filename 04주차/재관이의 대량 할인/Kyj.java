import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			Integer[] arr = new Integer[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr, (a, b) -> b - a);
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if ((i + 1) % 3 == 0)
					continue;
				else
					sum += arr[i];
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
