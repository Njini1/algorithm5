import java.util.Scanner;

public class Nhs {
	static Scanner sc = new Scanner(System.in);
	static int a = sc.nextInt();
	static int b = sc.nextInt();
	static int c = sc.nextInt();
	static int d = sc.nextInt();
	
	private static int check(int t) {
		int atk = 0;
		
		if(t%(a+b) <= a && t%(a+b) > 0) {
			atk++;
		}
		if(t%(c+d) <= c && t%(c+d) > 0) {
			atk++;
		}
		
		return atk;
	}
	
	public static void main(String[] args) {

		int p = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println(check(p));
		System.out.println(check(m));
		System.out.println(check(n));
	}
}