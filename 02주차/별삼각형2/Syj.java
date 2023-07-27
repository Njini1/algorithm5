import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Syj {
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    if (N % 2 == 0 || N < 0 || N > 101 || M < 1 || M > 4) {
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
    case 4:
    	star4();
    	break;
    }

  }

  private static void star1() {
    int k = 0;
    for (int i = 0; i < N; i++) {
      k += i <= N / 2 ? 1 : -1;
      for (int j = 0; j < k; j++) {
        System.out.print('*');
      }

  System.out.println();
}
  }

  private static void star2() {
    int k = N/2;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j <= N/2; j++) {
    	  System.out.print(j < k ? ' ' : '*');
      }
      k += i < N / 2 ? -1 : 1;
  System.out.println();
    }
  }

  private static void star3() {
	  int k = 0;
	  for (int i = 0; i < N; i++) {
		  for (int j = 0; j <= N - k - 1; j++) {
			  System.out.print(j < k ? ' ' : '*');
		  }
		  k += i < N / 2 ? 1 : -1;
		  System.out.println();
	  }
  }
  
  private static void star4() {
    int k = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i <= N / 2 && j <= N / 2) {
            System.out.print(j < k ? ' ' : '*');
        } else {
          if (j >= N / 2) {
            System.out.print(j <= k ? '*' : ' ');
          } else {
            System.out.print(" ");
          }
        }
      }
      k++;
      System.out.println();
    }
  }
}
