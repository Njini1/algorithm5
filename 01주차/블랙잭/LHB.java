package baekjoon2798;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		int last = 0;
		Arrays.sort(nums);
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int cur = nums[i] + nums[j] + nums[k];
					if (cur <= M && cur > last) {
						last = cur;
					}
				}
			}
		}
		System.out.println(last);
	}

}
