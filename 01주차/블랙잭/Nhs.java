import java.util.Scanner;

public class Nhs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] cards = new int[N];
		
		for(int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		
		int max = 0;
		
		for(int i=0; i<N-2; i++) {
			for(int j=i+1; j<N-1; j++) {
				for(int k=j+1; k<N; k++) {
					int temp = cards[i] + cards[j] + cards[k];
					if (temp > max && temp <= M) max = temp;
				}
			}
		}
		System.out.println(max);
		
	}

}