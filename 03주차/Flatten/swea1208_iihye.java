import java.util.*;

public class swea1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테스트 케이스의 개수
		
		for(int t = 1; t <= T; t++) {
			int dump = sc.nextInt(); // 덤프 횟수
			int[] boxes = new int[100]; // 상자들
			for(int i = 0; i < 100; i++) {
				boxes[i] = sc.nextInt();
			}
			
			for(int d = 0; d < dump; d++) {
				Arrays.sort(boxes);
				boxes[0]++;
				boxes[99]--;
			}
			
			Arrays.sort(boxes);
			System.out.printf("#%d %d\n", t, boxes[99]-boxes[0]);
		}
	}
}
