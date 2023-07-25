import java.util.Scanner;
public class Nhs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(0 > n || 100 < n) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		switch(m) {
			case 1:
				for(int i=0; i<n; i++) {
					for(int j=0; j<=i; j++) {
						System.out.println("*");
					}
					System.out.println();
				}
				break;
			case 2:
		          for(int i=0;i<n;i++){
		                for(int j=i;j<n;j++){
		                    System.out.print("*");
		                }
		                System.out.println();
		          }
		          break;
			case 3:
				for(int i=0;i<n;i++){
	                for(int j=i;j<n-1;j++){
	                    System.out.print(" ");
	                }
	                for(int j=0;j<i*2+1;j++){
	                    System.out.print("*");
	                }
	                System.out.println();
	            }
				break;
			default:
				System.out.println("INPUT ERROR!");
		}
	}

}
