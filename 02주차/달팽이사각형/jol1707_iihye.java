import java.util.*;

public class jol1707 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 정사각형의 크기
		if(n < 0 || n > 100) { // 범위를 벗어나면 return
			return;
		}
		int[][] arr = new int[n][n]; // 배열 생성
		boolean[][] visited = new boolean[n][n]; // 방문 여부 확인
		
		int[] dr = {0, 1, 0, -1}; // 오른쪽->아래->왼쪽->위
		int[] dc = {1, 0, -1, 0};
		int idx = 0; // 방향
		
		int cnt = 1; // 배열의 값
		int r = 0; // 좌표값
		int c = 0;
		
		arr[r][c] = cnt++; // 초기값 설정
		visited[r][c] = true;
		
		while(idx < 4) {
			if(cnt > n*n) { // 마지막 숫자까지 채우면 종료
				break;
			}
			
			int nr = r + dr[idx]; // 좌표 값
			int nc = c + dc[idx];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) { // 경계값 확인
				arr[nr][nc] = cnt++;
				visited[nr][nc] = true;
				r = nr;
				c = nc;				
			} else { // 방향 전환
				idx++; 
			}
			
			if(idx == 4) { // 4 이면 처음 방향으로
				idx = 0;
			}
		}
		
		for(int i = 0; i < n; i++) { // 출력
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
