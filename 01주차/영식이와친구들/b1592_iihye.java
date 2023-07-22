import java.util.*;

public class b1592 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 자리의 수
		int M = sc.nextInt(); // 공 받은 횟수
		int L = sc.nextInt(); // 다음 공 받는 사람
		
		int[] arr = new int[N]; // 원형
		
		int idx = 0; // 현재 공의 위치
		int ans = -1; // 공 던진 횟수
		boolean flag = false; // M번 받았는지 여부
		
		while(true) {
			
			for(int i = 0; i < arr.length; i++) { // M번 받았는지 확인
				if (arr[i] == M) {
					flag = true;
				}
			}
			if (flag == true) { // true이면 반복문 종료
				break;
			}
			
			arr[idx]++; // idx번째 공 받은 횟수 추가
			
			if(arr[idx] % 2 == 1) { // 홀수번이면
				idx = idx + L; // 시계 방향으로 L번째
			} else { // 짝수번이면
				idx = idx - L; // 반시계 방향으로 L번째
			}
			
			if(idx < 0) { // 0보다 작으면
				idx += N; // N 더하기
			} else if (idx >= N){ // N보다 크거나 같으면
				idx -= N; // N 빼기
			}
			
			ans++; // 공 던진 횟수 추가
		}
		System.out.printf("%d", ans);
	}
}
