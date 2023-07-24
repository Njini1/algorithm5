import java.util.Scanner;
public class Nhs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int cnt = 0;
		
		for(int i=1; i<=num; i++) {
			for(int j=i; j*i<=num; j++) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
