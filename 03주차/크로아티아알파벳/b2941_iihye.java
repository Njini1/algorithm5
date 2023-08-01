import java.io.*;

public class b2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String[] cro = {"c=", "c-", "d-", "lj", "nj", "s=", "z="}; // 크로아티아 문자 "dz=" 제외
		StringBuilder sb = new StringBuilder(); // 비교할 문자열 생성
		int ans = str.length(); // 주어진 문자열의 길이에서 2자 이상인 크로아티아 문자 개수 제외
		
		for(int i = 0; i < str.length()-1; i++) { // 문자열 2자씩 비교
			sb.append(str.charAt(i)); // 새로운 문자열로 생성
			sb.append(str.charAt(i+1));
			for(int j = 0; j < cro.length; j++) { // 크로아티아 문자인지 탐색
				if(cro[j].equals(sb.toString())) { // 동일한 문자가 있으면
					ans--; // 2자 짜리 크로아티아 문자이므로 정답에서 제외
					if(i > 0 && str.charAt(i-1) == 'd' && j == cro.length-1) { // z= 인 경우 앞 문자가 d라면
						ans--; // 3자 짜리 크로아티아 문자이므로 정답에서 제외
					}
					i++; // 연속 2자 확인했으므로 다음으로 넘어감
				}
			}
			sb.setLength(0); // 문자열 초기화
		}
		System.out.println(ans);
	}

}
