import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Syj {
  
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      
      int dog[] = new int[4];
      for (int i = 0; i < 4; i++) {
    	  dog[i] = Integer.parseInt(st.nextToken());
      }
      
      st = new StringTokenizer(br.readLine(), " ");
      int dog1 = (dog[0] + dog[1]);
      int dog2 = (dog[2] + dog[3]);
      for (int i = 0; i < 3; i++) {
    	  int tmp1 = Integer.parseInt(st.nextToken());
    	  int count = 0;
    	  
    	//도착시간 % (a + b) 이 값이 0이 아니고 a보다 같거나 작으면 공격
    	  if ((tmp1 % dog1) != 0 && ((tmp1 % dog1) <= dog[0])) {
    		  count += 1;
    	  }
    	  
    	  if ((tmp1 % dog2) != 0 && ((tmp1 % dog2) <= dog[2])) {
    		  count += 1;
    	  }
    	  System.out.println(count);
      }
    	  
  }

}
