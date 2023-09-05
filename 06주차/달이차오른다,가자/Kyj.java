import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kyj {
    static int N, M;
    static char[][] arr;
    static boolean[][][] visited;
    static int mx = 0;
    static int my = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M][64];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                // 민식이 위치라면
                if (arr[i][j] == '0') {
                    mx = i;
                    my = j;
                }
            }
        }
        System.out.println(bfs() ? min : -1);
    }

    private static boolean bfs() {
        boolean flag = false;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(mx, my, 0, 0));
        visited[mx][my][0] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int dist = p.dist;
                int keyStatus = p.keyStatus;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                //벽이라면
                if (arr[nx][ny] == '#') continue;
                //열쇠라면
                if ('a' <= arr[nx][ny] && arr[nx][ny] <= 'f') {
                    //열쇠 추가
                    keyStatus = p.keyStatus | 1 << (arr[nx][ny] - 'a');
                }
                //벽이라면
                else if ('A' <= arr[nx][ny] && arr[nx][ny] <= 'F') {
                    //열쇠가 없다면
                    if ((keyStatus & 1 << (arr[nx][ny] - 'A')) == 0) continue;
                }
                //출구라면
                else if (arr[nx][ny] == '1') {
                    flag = true;
                    min = Math.min(min, p.dist + 1);
                    continue;
                }
                if (visited[nx][ny][keyStatus]) continue;
                q.offer(new Point(nx, ny, dist + 1, keyStatus));
                visited[nx][ny][keyStatus] = true;
            }
        }
        return flag;
    }

    static class Point {
        int x, y, dist, keyStatus;

        public Point(int x, int y, int dist, int keyStatus) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.keyStatus = keyStatus;
        }
    }
}
