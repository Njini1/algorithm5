import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, dist, cnt;

    public Point(int x, int y, int dist, int cnt) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.cnt = cnt;
    }
}

public class Kyj {
    static int K, H, W;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0, -2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dy = {0, 1, 0, -1, -1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = st.nextToken().charAt(0) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0, 0, 0));
        boolean[][][] visited = new boolean[H][W][K + 1];
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if ((p.x >= H - 1) && (p.y >= W - 1)) {
                return p.dist;
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if (visited[nx][ny][p.cnt]) continue;
                if (arr[nx][ny] == 1) continue;
                q.offer(new Point(nx, ny, p.dist + 1, p.cnt));
                visited[nx][ny][p.cnt] = true;
            }
            if (p.cnt >= K) continue;
            for (int i = 4; i < 12; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if (visited[nx][ny][p.cnt + 1]) continue;
                if (arr[nx][ny] == 1) continue;
                q.offer(new Point(nx, ny, p.dist + 1, p.cnt + 1));
                visited[nx][ny][p.cnt + 1] = true;
            }
        }
        return -1;
    }
}
