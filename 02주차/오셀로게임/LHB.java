import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            int half = N / 2;
            map[half - 1][half - 1] = 2;
            map[half - 1][half] = 1;
            map[half][half - 1] = 1;
            map[half][half] = 2;
             
            int M = sc.nextInt();
            int[] d1 = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] d2 = {-1, 0, 1, -1, 1, -1, 0, 1};
            for (int i = 0; i < M; i++) {
                int row = sc.nextInt() - 1;
                int column = sc.nextInt() - 1;
                int cur_player = sc.nextInt();
                int next_player = 0;
                if (cur_player == 1) next_player = 2;
                else next_player = 1;
                map[row][column] = cur_player;
                 
                for (int j = 0; j < 8; j++) {
                    int weight = 2;
                    boolean flag = false;
                    if (row + d1[j] >= 0 && row + d1[j] < N && column + d2[j] >= 0 && column + d2[j] < N && map[row + d1[j]][column + d2[j]] == next_player) {
                        while (row + d1[j] * weight >= 0 && row + d1[j] * weight < N && column + d2[j] * weight >= 0 && column + d2[j] * weight < N) {
                            if (map[row + d1[j] * weight][column + d2[j] * weight] == cur_player) {
                                flag = true;
                                break;
                            } else if (map[row + d1[j] * weight][column + d2[j] * weight] == 0) {
                                break;
                            }
                            weight++;
                        }
                    }
                    if (flag) {
                        for (int k = 1; k < weight; k++) {
                            map[row + d1[j] * k][column + d2[j] * k] = cur_player;
                        }
                    }
                }
            }
            int black = 0;
            int white = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) black++;
                    else if (map[i][j] == 2) white++;
                }
            }
            System.out.printf("#%d %d %d\n", tc, black, white);
        }
    }
}
