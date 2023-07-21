import java.util.Arrays;
import java.util.Scanner;

class Kyj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<T+1;tc++){
            int n = sc.nextInt();
            int[][] farm = new int[n][n];
            for(int i = 0; i<n;i++){
                String[] tmp = sc.next().split("");
                for(int j = 0; j<n;j++){
                    farm[i][j] = Integer.parseInt(tmp[j]);
                }
            }
            int sum = 0;
            for(int i = 0; i<n;i++){
                int len = i<(n/2)?2*i+1:2*(n-i)-1;
                int s = (n/2)-(len/2);
                int e = (n/2)+(len/2);
                for(int j = s; j<=e;j++){
                    sum+=farm[i][j];
                }
            }
            System.out.printf("#%d %d\n",tc,sum);
        }
    }
}
