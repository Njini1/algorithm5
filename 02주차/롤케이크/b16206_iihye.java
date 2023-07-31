import java.util.*;

public class b16206 {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt(); // 롤케이크의 개수
	static int M = sc.nextInt(); // 자를 수 있는 최대 횟수
	static int cnt = 0; // 10개짜리 롤케이크의 개수

	public static void main(String[] args) {
		int[] arr = new int[N]; // 롤케이크의 길이
		for(int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}
		
		// 10의 배수에 대해 처리하기
		Arrays.sort(arr); // 정렬
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 10) { // arr[i]가 10인 경우
				cnt++; // 조각 추가
				arr[i] = 0; // 더 이상 자를 수 없으니 0으로 만들기
			} else if(arr[i] % 10 == 0){ // arr[i]가 10보다 큰 10의 배수인 경우
				cut(arr[i]); // 조각 추가
				arr[i] = 0; // 더 이상 자를 수 없으니 0으로 만들기
			}
		}
		
		// 나머지 처리하기
		Arrays.sort(arr); // 정렬
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 10 && M > 0) { // 10보다 커서 자를 수 있고, M이 남아 있는 경우
				cut(arr[i]); // 자르기
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void cut(int cake) {
		if(M == 0) { // 자를 횟수가 없으면 그만
			return;
		} else { // 자를 횟수가 있으면
			cake -= 10; // 케이크 자르기
			M--; // 횟수 감수 감소
			cnt++; // 조각 추가
			
			if(cake > 10) { // 남은 길이가 10보다 길면 한 번 더 자름
				cut(cake);
			} else if(cake == 10) { // 남은 길이가 10이면 조각 추가
					cnt++; 
					return;
			} else { // 남은 길이가 10보다 작으면 그만
				return; 
			}
		}
	}

}
