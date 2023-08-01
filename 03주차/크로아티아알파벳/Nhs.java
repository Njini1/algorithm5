import java.util.Scanner;
public class Nhs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
				
		String str = sc.next();
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		int cnt=0;

		for(String ele : arr) {
			while(str.contains(ele)) {
				str = str.replaceFirst(ele, " ");
				cnt++;
			}
		}
		for(int i=0; i<str.length(); i++) {
			char temp = str.charAt(i);
			if(temp != ' ') cnt++;
		}
		
		System.out.println(cnt);
	}

}
