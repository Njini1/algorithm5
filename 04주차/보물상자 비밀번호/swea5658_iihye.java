import java.io.*;
import java.util.*;

public class swea5658 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("swea5658_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int t = 1; t <= T; t++) {
			// 1. 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // N개의 숫자
			int K = Integer.parseInt(st.nextToken()); // K번째로 큰 수
			List<String> list = new ArrayList<String>();
			String str = br.readLine();
			for (int n = 0; n < N; n++) { // 리스트에 한 글자씩 넣기
				list.add(String.valueOf(str.charAt(n)));
			}
			for (int i = 0; i < N/4; i++) { // 초반 N/4개는 리스트에 한 번 더 넣어줌
				list.add(list.get(i));
			}
			
			// 2. 가능한 비밀 번호 구하기
			Set<Integer> set = new TreeSet<Integer>(Collections.reverseOrder()); // 중복 제거. 내림차순 정렬.
			for (int i = 0; i < list.size()-(N/4); i++) { // N/4 개씩 끊어서 비밀번호 생성
				StringBuilder sb = new StringBuilder();
				for (int j = i; j < i + (N/4); j++) {
					sb.append(list.get(j));
				}
				set.add(Integer.parseInt(sb.toString(), 16));
			}
			Integer[] ans = set.toArray(new Integer[set.size()]);
			
			// 3. 비밀 번호 중 최대값 구하기
			System.out.println("#" + t + " " + ans[K-1]);			
		}
	}
}
