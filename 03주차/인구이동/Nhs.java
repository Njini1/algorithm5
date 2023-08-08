// 해결하지 못해 정답코드 참고하며 풀었습니다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Nhs {
	
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,L,R,population[][],ans;
	static boolean t, flag, v[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		population = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*
		for(int[] arr : population) {
			System.out.println(Arrays.toString(arr));
		}
		*/
		ans = 0;
		while (ans<=2000) {
			// 전체 순회하면서 미방문 -> 연합처리
			v = new boolean[N][N];
			flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!v[i][j]) { // 미방문 시에
						t = bfs(i,j); // 연합이 있다면 true
						if (t) {
							flag = true;
						}
					}
				}
			}
			if (!flag) break; // 이동이 없었다면 탈출
			ans++;
		}
		
		System.out.println(ans);
		
	}
	private static boolean bfs(int si, int sj) {
		ArrayDeque<Point> q = new ArrayDeque<Point>();
		ArrayList<Point> li = new ArrayList<Point>(); // 같은 연합 리스트
		q.add(new Point(si, sj)); // 큐에 초기 데이터 삽입
		v[si][sj] = true; // 방문처리
		li.add(new Point(si, sj)); // 연합에 추가
		int sum = population[si][sj]; // 연합 인구수 합계
		
		while(!q.isEmpty()) {
			Point cur = q.removeFirst();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				//범위체크, 미방문 체크
				if(0>nx || nx >= N || 0>ny || ny>=N || v[nx][ny]) continue;
				
				int diff = Math.abs(population[cur.x][cur.y] - population[nx][ny]);
				
				// 조건(인구차이 체크) 
				if(L <= diff && diff <= R) {
					q.add(new Point(nx, ny));
					v[nx][ny] = true;
					li.add(new Point(nx, ny));
					sum += population[nx][ny];
				}
				
			}
			
		}
		if(li.size() == 1) return false; // 연합 없으면 false 리턴
		
		for(Point p : li) {
			population[p.x][p.y] = sum / li.size(); 
		}
		
		return true;
	}
	

}
