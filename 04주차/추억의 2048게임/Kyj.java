import java.util.*;

class Tile {
	int number;
	boolean isMerged;

	Tile(int number, boolean isMerged) {
		this.number = number;
		this.isMerged = isMerged;
	}
}

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String cmd = sc.next();
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}

			if (cmd.equals("up")) {
				board = up(board);
			} else if (cmd.equals("down")) {
				board = down(board);
			} else if (cmd.equals("left")) {
				board = left(board);
			} else {
				board = right(board);
			}
			System.out.println("#" + tc);
			print(board);
		}
	}

	private static int[][] up(int[][] board) {
		int N = board.length;
		Deque<Tile> dq = new ArrayDeque<>();
		int[][] board2 = new int[N][N];
		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N; r++) {
				if (board[r][c] == 0)
					continue;
				if (!dq.isEmpty() && dq.peekLast().isMerged == false && dq.peekLast().number == board[r][c]) {
					dq.offerLast(new Tile(dq.pollLast().number * 2, true));
				} else {
					dq.offerLast(new Tile(board[r][c], false));
				}
			}
			int tileCnt = dq.size();
			for (int i = 0; i < tileCnt; i++) {
				board2[i][c] = dq.pollFirst().number;
			}
		}
		return board2;
	}

	private static int[][] down(int[][] board) {
		int N = board.length;
		Deque<Tile> dq = new ArrayDeque<>();
		int[][] board2 = new int[N][N];
		for (int c = 0; c < N; c++) {
			for (int r = N - 1; r >= 0; r--) {
				if (board[r][c] == 0)
					continue;
				if (!dq.isEmpty() && dq.peekLast().isMerged == false && dq.peekLast().number == board[r][c]) {
					dq.offerLast(new Tile(dq.pollLast().number * 2, true));
				} else {
					dq.offerLast(new Tile(board[r][c], false));
				}
			}
			int tileCnt = dq.size();
			for (int i = N - 1; i >= N - tileCnt; i--) {
				board2[i][c] = dq.pollFirst().number;
			}
		}
		return board2;
	}

	private static int[][] left(int[][] board) {
		int N = board.length;
		Deque<Tile> dq = new ArrayDeque<>();
		int[][] board2 = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] == 0)
					continue;
				if (!dq.isEmpty() && dq.peekLast().isMerged == false && dq.peekLast().number == board[r][c]) {
					dq.offerLast(new Tile(dq.pollLast().number * 2, true));
				} else {
					dq.offerLast(new Tile(board[r][c], false));
				}
			}
			int tileCnt = dq.size();
			for (int i = 0; i < tileCnt; i++) {
				board2[r][i] = dq.pollFirst().number;
			}
		}
		return board2;
	}

	private static int[][] right(int[][] board) {
		int N = board.length;
		Deque<Tile> dq = new ArrayDeque<>();
		int[][] board2 = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = N - 1; c >= 0; c--) {
				if (board[r][c] == 0)
					continue;
				if (!dq.isEmpty() && dq.peekLast().isMerged == false && dq.peekLast().number == board[r][c]) {
					dq.offerLast(new Tile(dq.pollLast().number * 2, true));
				} else {
					dq.offerLast(new Tile(board[r][c], false));
				}
			}
			int tileCnt = dq.size();
			for (int i = N - 1; i >= N - tileCnt; i--) {
				board2[r][i] = dq.pollFirst().number;
			}
		}
		return board2;
	}

	private static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
