import java.util.Scanner;
public class Nhs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(0 > n || 100 < n || n%2==0 || m<1 || m>4) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		switch(m) {
			case 1:
				for(int i=0; i<n/2; i++) {
					for(int j=0; j<=i; j++) {
						System.out.print("*");
					}						
					System.out.println();
				}
				for (int i = n/2; i < n; i++) {
					for (int j = 0; j < n - i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 2:
		          for (int i=0; i<n; i++) {
		        	  if (i<= n/2) {
		        		  for(int j=n/2 - i; j>0; j--) {
		        			  System.out.print(" ");
		        		  }
		        		  for(int j=0; j<=i; j++) {
		        			  System.out.print("*");
		        		  }
		        	  } else {
		        		  for(int j=0; j<i-n/2; j++) {
		        			  System.out.print(" ");
		        		  }
		        		  for(int j=n-i; j>0; j--) {
		        			  System.out.print("*");
		        		  }
		        	  }
		        	  System.out.println();
		          }
		          break;
			case 3:
				for(int i=0; i<n; i++){
					if (i <= n/2) {
						for (int j=1; j<=i; j++) {
							System.out.printf(" ");
						}
						for (int j=n; j>2*i; j--) {
							System.out.printf("*");
						}
						System.out.println();
					}
					if (i>n/2) {
						for (int j=n-i-1; j>0; j--) {
							System.out.printf(" ");
						}
						for (int j=n-1; j<2 * i+1; j++) {
							System.out.printf("*");
						}
						System.out.println();
					}
	            }
				break;
			case 4:
				for (int i = 0; i < n; i++) {
					if (i <= n/2) {
						for (int j=1; j<=i; j++) {
							System.out.printf(" ");
						}
						for (int j=n/2+1; j>i; j--) {
							System.out.printf("*");
						}
						System.out.println();
					}

					if (i > n/2) {
						for (int j=1; j<=n/2; j++) {
							System.out.printf(" ");
						}
						for (int j=n/2-1; j<i; j++) {
							System.out.printf("*");
						}
						System.out.println();
					}
				}
				break;
			default:
				System.out.println("INPUT ERROR!");
		}
	}

}
