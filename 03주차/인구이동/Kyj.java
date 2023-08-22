import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while (true) {
            boolean isChanged = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j]) continue;
                    isChanged |= bfs(new Point(i, j));
                }
            }
            if (!isChanged) break;
            day++;
        }
        System.out.println(day);

    }

    private static boolean bfs(Point s) {
        int unionCnt = 1;
        int sum = arr[s.x][s.y];
        ArrayList<Point> li = new ArrayList<>();
        Queue<Point> q = new ArrayDeque<>();
        visited[s.x][s.y] = true;
        li.add(s);
        q.add(s);
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                int diff = Math.abs(arr[nx][ny] - arr[p.x][p.y]);
                if (diff < L || diff > R) continue;
                unionCnt++;
                sum += arr[nx][ny];
                li.add(new Point(nx, ny));
                q.offer(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
        if (unionCnt > 1) {
            int avg = sum / unionCnt;
            for (Point p : li) {
                arr[p.x][p.y] = avg;
            }
            return true;
        } else {
            return false;
        }
    }
}
