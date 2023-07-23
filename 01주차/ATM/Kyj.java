import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int answer = 0;
		int acc = 0;
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			acc += arr[i];
			answer += acc;
		}
		System.out.println(answer);
	}
}