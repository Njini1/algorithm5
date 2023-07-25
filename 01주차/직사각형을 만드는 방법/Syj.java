import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Syj {
	static int N;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int target = 1; target <= N; target++) {
			result += findDivisor(target, (int)Math.sqrt(target));
		}
    	System.out.println(result);
		
    }
    private static int findDivisor(int target, int maxNum) {
    	int count = 0;
    	for (int i = 1; i <= maxNum; i++) {
    		if (target % i == 0) {
    			count += 1;
    		}
    	}
    	return count;
    }
}
    
