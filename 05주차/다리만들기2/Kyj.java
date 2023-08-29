import java.awt.*;
import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int s, e, w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.w, o.w);
    }
}

public class Kyj {
    static int N, M, distance, ex, ey;
    static int num = 2;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = st.nextToken().charAt(0) - '0';
            }
        }
        // 섬 번호 지정
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bfs(new Point(i, j));
            }
        }
        parent = new int[num - 2];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    distance = 0;
                    ex = 0;
                    ey = 0;
                    if (arr[i][j] == 0) continue;
                    dfs(new Point(i, j), arr[i][j], k, 0);
                    if (distance > 1) {
                        pq.add(new Edge(arr[i][j] - 2, arr[ex][ey] - 2, distance));
                    }
                }
            }
        }
        make();
        int answer = 0;
        int cnt = 0;
        boolean isPossible = false;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (union(e.s, e.e)) {
                answer += e.w;
                if (++cnt == num - 2 - 1) {
                    isPossible = true;
                    break;
                }
            }
        }
        System.out.println(isPossible ? answer : -1);

    }

    private static void make() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parent[aRoot] = bRoot;
        return true;
    }

    private static void bfs(Point s) {
        if (arr[s.x][s.y] != 1) return;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(s);
        arr[s.x][s.y] = num;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (arr[nx][ny] != 1) continue;
                arr[nx][ny] = num;
                q.offer(new Point(nx, ny));
            }
        }
        num++;
    }
    
    private static void dfs(Point s, int origin, int dir, int length) {
        int nx = s.x + dx[dir];
        int ny = s.y + dy[dir];
        // 범위 벗어났다면
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
        // 같은 섬이면
        if (arr[nx][ny] == origin) return;
        // 다른 섬이면
        if (arr[nx][ny] != 0 && arr[nx][ny] != origin) {
            distance = length;
            ex = nx;
            ey = ny;
            return;
        }
        dfs(new Point(nx, ny), origin, dir, length + 1);
    }
}
