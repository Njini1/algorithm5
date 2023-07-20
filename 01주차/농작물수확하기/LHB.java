package swea2805;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
    	System.setIn(new FileInputStream("src/swea2805/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
            	String str = sc.next();
            	for (int j = 0; j < N; j++) {
            		map[i][j] = str.charAt(j) - '0';
            	}
            }
        	
            int half = N / 2;
            int start = half;
            int count = 1;
            int sum = 0;
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < count; j++) {
            		sum += map[i][start + j];
            	}
            	if (i < half) {
            		start -= 1;
            		count += 2;
            	}
            	else {
            		start += 1;
            		count -= 2;
            	}
            }
        	System.out.printf("#%d %d\n", test_case, sum);
        }
    }
}