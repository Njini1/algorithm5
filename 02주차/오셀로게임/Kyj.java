import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int black = 2;
            int white = 2;

            int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
            int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
            //보드 초기화
            int[][] board = new int[n][n];
            board[n / 2 - 1][n / 2 - 1] = 2;
            board[n / 2][n / 2] = 2;
            board[n / 2 - 1][n / 2] = 1;
            board[n / 2][n / 2 - 1] = 1;

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                int nx = x;
                int ny = y;
                int color = sc.nextInt();
                board[x][y] = color;
                if (color == 1) {
                    black++;
                } else {
                    white++;
                }
                for (int k = 0; k < 8; k++) {
                    nx += dx[k];
                    ny += dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (board[nx][ny] != 0 && board[nx][ny] != color) {
                        int delta = 1;
                        int nnx = x + dx[k] * delta;
                        int nny = y + dy[k] * delta;
                        if (nny < 0 || nny >= n || nnx < 0 || nnx >= n) {
                            continue;
                        }
                        while (board[nnx][nny] != color) {
                            if (nny < 0 || nny >= n || nnx < 0 || nnx >= n) {
                                break;
                            }
                            if (color == 1) {
                                black++;
                                white--;
                            } else {
                                white++;
                                black--;
                            }
                            board[nnx][nny] = color;
                            nnx = x + dx[k] * delta;
                            nny = y + dy[k] * delta;
                            delta++;
                        }
                    }
                }
            }
            System.out.printf("#%d %d %d", tc, black, white);
        }

    }
}