import java.io.*;
import java.util.*;
/** Integer 정수 캐싱 유의*/
public class swea6109 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("swea6109_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			String command = st.nextToken();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			List<Integer> l = new ArrayList<Integer>();
			
			switch(command) { // command 방향 대로 한 줄 빼기 -> 값이 같으면 연산하기 -> 다시 배열에 넣기
			case "up":
				for(int i = 0; i < N; i++) { // 리스트로 빼기
					l = new ArrayList<Integer>();
					for(int j = 0; j < N; j++) {
						if(map[j][i] > 0) {
							l.add(map[j][i]);
						}
					}
					for(int j = 0; j < l.size(); j++) { // 값이 같으면 연산하기
						if(j+1 < l.size() && l.get(j).equals(l.get(j+1))) {
							int temp = l.get(j);
							l.set(j, temp * 2);
							l.remove(j+1);
						}
					}
					for(int j = 0; j < N; j++) { // 다시 배열에 넣기
						if(j < l.size()) {
							map[j][i] = l.get(j);
						} else {
							map[j][i] = 0;
						}
					}
				}
				break;
			case "down":
				for(int i = 0; i < N; i++) { // 리스트로 빼기
					l = new ArrayList<Integer>();
					for(int j = N-1; j >= 0; j--) {
						if(map[j][i] > 0) {
							l.add(map[j][i]);
						}
					}
					for(int j = 0; j < l.size(); j++) { // 값이 같으면 연산하기
						if(j+1 < l.size() && l.get(j).equals(l.get(j+1))) {
							int temp = l.get(j);
							l.set(j, temp * 2);
							l.remove(j+1);
						}
					}
					for(int j = 0; j < N; j++) { // 다시 배열에 넣기
						if(j < l.size()) {
							map[N-1-j][i] = l.get(j);
						} else {
							map[N-1-j][i] = 0;
						}
					}
				}
				break;
			case "left":
				for(int i = 0; i < N; i++) { // 리스트로 빼기
					l = new ArrayList<Integer>();
					for(int j = 0; j < N; j++) {
						if(map[i][j] > 0) {
							l.add(map[i][j]);
						}
					}
					for(int j = 0; j < l.size(); j++) { // 값이 같으면 연산하기
						if(j+1 < l.size() && l.get(j).equals(l.get(j+1))) {
							int temp = l.get(j);
							l.set(j, temp * 2);
							l.remove(j+1);
						}
					}
					for(int j = 0; j < N; j++) { // 다시 배열에 넣기
						if(j < l.size()) {
							map[i][j] = l.get(j);
						} else {
							map[i][j] = 0;
						}
					}
				}
				break;
			case "right":
				for(int i = 0; i < N; i++) { // 리스트로 빼기
					l = new ArrayList<Integer>();
					for(int j = N-1; j >= 0; j--) {
						if(map[i][j] > 0) {
							l.add(map[i][j]);
						}
					}
					for(int j = 0; j < l.size()-1; j++) { // 값이 같으면 연산하기
						if(j+1 < l.size() && l.get(j).equals(l.get(j+1))) {
							int temp = l.get(j);
							l.set(j, temp * 2);
							l.remove(j+1);
						}
					}
					for(int j = 0; j < N; j++) { // 다시 배열에 넣기
						if(j < l.size()) {
							map[i][N-1-j] = l.get(j);
						} else {
							map[i][N-1-j] = 0;
						}
					}
				}
				break;
			}
			
			System.out.println("#" + t);
			print(map);
		}
	}
	
	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
