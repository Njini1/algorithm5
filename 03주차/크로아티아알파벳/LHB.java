import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int count = 0;
		while (str.length() > 0) {
			try {
				if (str.charAt(0) == 'c' && (str.charAt(1) == '=' || str.charAt(1) == '-')) {
					str = str.substring(2);
				} else if (str.charAt(0) == 'd' && str.charAt(1) == 'z' && str.charAt(2) == '=') {
					str = str.substring(3);
				} else if (str.charAt(0) == 'd' && str.charAt(1) == '-') {
					str = str.substring(2);
				} else if (str.charAt(0) == 'l' && str.charAt(1) == 'j') {
					str = str.substring(2);
				} else if (str.charAt(0) == 'n' && str.charAt(1) == 'j') {
					str = str.substring(2);
				} else if (str.charAt(0) == 's' && str.charAt(1) == '=') {
					str = str.substring(2);
				} else if (str.charAt(0) == 'z' && str.charAt(1) == '=') {
					str = str.substring(2);
				} else {
					str = str.substring(1);
				}
			} catch (StringIndexOutOfBoundsException e) {
				str = str.substring(1);
			}
			count++;
		}
		System.out.println(count);
	}

}
