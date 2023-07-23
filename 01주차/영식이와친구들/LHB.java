import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] count = new int[N];
		int max = 0;
		int round = -1;
		int receiver = 0;
		
		while (max < M) {
			count[receiver] += 1;
			if (count[receiver] > max) max = count[receiver];
			if (count[receiver] % 2 != 0) receiver = (receiver + L) % N;
			else {
				if (receiver >= L) receiver -= L;
				else receiver = receiver - L + N;
			}
			round++;
		}
		System.out.println(round);
	}

}
