import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int r = 0, c = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];
            for (int i = 0; i < H; i++) {
                char[] temp = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    map[i][j] = temp[j];
                    if (temp[j] == '^' || temp[j] == 'v' || temp[j] == '<' || temp[j] == '>') {
                        r = i;
                        c = j;
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            String commands = br.readLine();
             
            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };
            for (int i = 0; i < N; i++) {
                switch (commands.charAt(i)) {
                case 'U':
                    if (r - 1 >= 0 && map[r - 1][c] == '.') {
                        map[r--][c] = '.';
                    }
                    map[r][c] = '^';
                    break;
                case 'D':
                    if (r + 1 < H && map[r + 1][c] == '.') {
                        map[r++][c] = '.';
                    }
                    map[r][c] = 'v';
                    break;
                case 'L':
                    if (c - 1 >= 0 && map[r][c - 1] == '.') {
                        map[r][c--] = '.';
                    }
                    map[r][c] = '<';
                    break;
                case 'R':
                    if (c + 1 < W && map[r][c + 1] == '.') {
                        map[r][c++] = '.';
                    }
                    map[r][c] = '>';
                    break;
                case 'S':
                    int d = -1;
                    int missile_r = r, missile_c = c;
                    switch (map[r][c]) {
                    case '^':
                        d = 0;
                        break;
                    case 'v':
                        d = 1;
                        break;
                    case '<':
                        d = 2;
                        break;
                    case '>':
                        d = 3;
                        break;
                    }
                    while (missile_r >= 0 && missile_r < H && missile_c >= 0 && missile_c < W) {
                        if (map[missile_r][missile_c] == '*') {
                            map[missile_r][missile_c] = '.';
                            break;
                        } else if (map[missile_r][missile_c] == '#') {
                            break;
                        }
                        missile_r += dr[d];
                        missile_c += dc[d];
                    }
                }
            }
            System.out.printf("#%d ", tc);
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
 
}
