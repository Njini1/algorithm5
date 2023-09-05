import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int T, N, M, R, C, L, map[][];
    static boolean visited[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] blocks = {
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 0, 1, 0}
    };
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.printf("#%d %d\n", tc, bfs());
        }
         
    }
     
    private static int bfs() {
        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {R, C, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_block = map[cur[0]][cur[1]];
            if (cur[2] > L) {
                return cnt;
            }
            if (!visited[cur[0]][cur[1]]) {
                visited[cur[0]][cur[1]] = true;
                cnt++;
            }
            for (int d = 0; d < 4; d++) {
                int[] next_d = {1, 0, 3, 2};
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                int nd = next_d[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                int next_block = map[nr][nc];
                if (!visited[nr][nc] && blocks[cur_block][d] == 1 && blocks[next_block][nd] == 1) {
                    q.offer(new int[] {nr, nc, cur[2] + 1});
                }
            }
        }
        return cnt;
    }
     
}
