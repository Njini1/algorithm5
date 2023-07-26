import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Syj {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        try {
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());        	
        } catch(NumberFormatException e) {
        	System.exit(0);
        }

        if (N < 0 || N > 101 || M < 1 || M > 3) {
            System.out.println("INPUT ERROR!");
            System.exit(0);
        }
        switch (M) {        
        case 1:
        	star1();
        	break;
        case 2:
        	star2();
        	break;
        case 3:
        	star3();
        	break;
        }
    }
    private static void star1() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
    private static void star2() {
        for (int i = 0; i < N; i++) {
            for (int j = N - i; j > 0; j--) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
    private static void star3() {
        for (int i = 1; i <= N; i++) {
            for (int a = N - i; a > 0; a--) {
                System.out.print(' ');
            }
            for (int b = 0;b < i*2 - 1; b++) {
                System.out.print('*');
            }
            

        System.out.println();
    }
    }
}
