import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.*;


class PointWithDist {
    int x, y, dist;

    public PointWithDist(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

}

public class Kyj {
    static int N;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int Num = 2;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = st.nextToken().charAt(0) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0 || arr[i][j] > 1) continue;
                numbering(new Point(i, j));
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j]==0) continue;
                visited = new boolean[N][N];
                bfs(new Point(i, j));
            }
        }
        System.out.println(min);

    }

    private static void numbering(Point s) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(s);
        arr[s.x][s.y] = Num;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (arr[nx][ny] == 0 || arr[nx][ny] > 1) continue;
                arr[nx][ny] = Num;
                q.offer(new Point(nx, ny));
            }
        }
        Num++;
    }

    private static void bfs(Point s) {
        Queue<PointWithDist> q = new ArrayDeque<>();
        q.offer(new PointWithDist(s.x, s.y, 0));
        visited[s.x][s.y] = true;
        while (!q.isEmpty()) {
            PointWithDist p = q.poll();
            if (p.dist >= min) return;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] != 0 && arr[s.x][s.y] != arr[nx][ny]) {
                    min = Math.min(min, p.dist);
                    return;
                }
                q.offer(new PointWithDist(nx, ny, p.dist + 1));
                visited[nx][ny]=true;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
