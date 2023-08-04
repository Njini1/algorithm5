import java.util.Scanner;
public class Nhs {
	static String stick;
	static int cnt, temp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		stick = sc.next();
		
		
		cnt = 0;
		temp = 0;
		for (int i = 0; i < stick.length(); i++) {
			if(stick.charAt(i) == '(') {
				temp++;
			} else {
				temp--;
				if(stick.charAt(i-1) == '(') {
					cnt += temp;
				} else {
					cnt++;
				}
			}

		}
		System.out.println(cnt);
		
	}

}
