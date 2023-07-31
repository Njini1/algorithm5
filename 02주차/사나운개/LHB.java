import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int P = sc.nextInt();
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int p = 0;
		int m = 0;
		int n = 0;
		if (P % (A + B) > 0 && P % (A + B) <= A) p++;
		if (P % (C + D) > 0 && P % (C + D) <= C) p++;
		if (M % (A + B) > 0 && M % (A + B) <= A) m++;
		if (M % (C + D) > 0 && M % (C + D) <= C) m++;
		if (N % (A + B) > 0 && N % (A + B) <= A) n++;
		if (N % (C + D) > 0 && N % (C + D) <= C) n++;
		
		System.out.println(p);
		System.out.println(m);
		System.out.println(n);
	}

}
