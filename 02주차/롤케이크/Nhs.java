import java.util.Arrays;
import java.util.Scanner;

public class Nhs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] cake = new int[N];

        for (int i = 0; i < N; i++) {
        	cake[i] = sc.nextInt();
        }

        // 10으로 나누어떨어지는 케이크 찾기
        int tenTimes = 0;
        for (int i = 0; i < N; i++) {
            if (cake[i] % 10 == 0) {
            	tenTimes++;
            }
        }

        // 10으로 나누어떨어지는 케이크 따로 관리
        int[] tenTimesCakes = new int[tenTimes];
        int evenCakesIndex = 0;
        for (int i = 0; i < N; i++) {
            if (cake[i] % 10 == 0) {
            	tenTimesCakes[evenCakesIndex] = cake[i];
                evenCakesIndex++;
            }
        }
        // 정렬
        Arrays.sort(tenTimesCakes);
        
        int cnt = 0;

        // 10으로 떨어지는 케이크 먼저 카운트
        for (int i = 0; i < tenTimes; i++) {
            while (tenTimesCakes[i] > 10) {
                if (M <= 0) break;

                tenTimesCakes[i] -= 10;
                M--;
                cnt++;
            }
            if (tenTimesCakes[i] == 10) {
                cnt++;
            }
        }

        // 기회 남아있으면 나머지 케이크도 진행
        if(M>0) {        	
        	for (int i = 0; i < N; i++) {
        		if (cake[i] % 10 == 0) continue;
        		while (cake[i] > 10) {
        			if (M <= 0) break;
        			
        			cake[i] -= 10;
        			M--;
        			cnt++;
        		}
        	}
        }

        System.out.println(cnt);
    }
}
