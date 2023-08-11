import java.io.*;
import java.util.*;

public class swea4050 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 옷의 벌 수
			ArrayList<Integer> prices = new ArrayList<>(); // 옷의 가격
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				prices.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(prices, Collections.reverseOrder()); // 내림차순 정렬
			
			for (int i = 0; i < prices.size(); i++) {
				if((i+1) % 3 > 0) { // 3번째가 아닐 때만 값에 더하기
					ans += prices.get(i);
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
