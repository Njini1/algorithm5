import java.util.Scanner;
public class Nhs {
	
	public static void sort(int n, int[] arr) {
		for(int i=0; i<n-1; i++) {
			boolean change = false;
			for(int j=0; j<n-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					change = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if(!change) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] time = new int[N];
		for(int i=0; i<N; i++) {
			time[i] = sc.nextInt();
		}
		
		sort(N, time);

		int res = 0 ;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				res += time[j];
			}
		}
		System.out.println(res);
		
	}

}
