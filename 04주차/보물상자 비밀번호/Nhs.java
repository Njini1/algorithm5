import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
 
public class Nhs {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
       
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1;tc<=T;tc++) {
            List<Character> list = new ArrayList<>();
            List<String> result = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken())/4; //숫자개수
            int K = Integer.parseInt(st.nextToken()); //k번째수
            
            String num = br.readLine();
            for(int i=0;i<num.length();i++) list.add(num.charAt(i));
            
            for (int i = 0; i < N; i++) { // 생성 가능한 수 찾기
                String temp = "";
                int count = 0;
                for (int j = 0; j < num.length(); j++) {
                    temp += list.get(j);
                    count++;
                    if (count == N) {
                        if (!result.contains(temp)) { // 중복 아니면 결과 리스트에 추가
                            result.add(temp);
                        }
                        temp = "";
                        count = 0;
                    }
                }
                char c = list.remove(list.size() - 1); // 리스트 회전
                list.add(0, c);
            }
            
            Collections.sort(result, Collections.reverseOrder()); // 정렬
            

            System.out.printf("#%d %d\n", tc, Integer.parseInt(result.get(K-1),16));

            
        }
 
    }
 
}
