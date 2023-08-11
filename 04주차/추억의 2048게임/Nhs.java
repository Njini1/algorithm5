import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nhs {
	
	private static int T, N, map[][];
	private static boolean check[][];
	private static String S;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = st.nextToken();
			
			map = new int[N][N];
			check = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			switch (S) {
			case "left":
				for (int i = 0; i < N; i++) {
					for (int j = 1; j < N; j++) {
						if (map[i][j] != 0) {
							int now = map[i][j];
							for(int k = j-1; k >=0; k--) {
								if(map[i][k] != 0) {
									if(map[i][k] == now && !check[i][k]) {
										check[i][k] = true;
										map[i][j] = 0;
										map[i][k] += now;
										break;										
									} else {
										map[i][j] = 0;
										map[i][k+1] = now;
										break;
									}
								} else {
									if(k==0) {
										map[i][j] = 0;
										map[i][k] = now;
										break;										
									}
								}
								
							}
						}
					}
				}
				break;
			case "right":
				for (int i = N-1; i >= 0; i--) {
					for (int j = N-2; j >= 0; j--) {
						if (map[i][j] != 0) {
							int now = map[i][j];
							for(int k = j+1; k <N; k++) {
								if(map[i][k] != 0) {
									if(map[i][k] == now && !check[i][k]) {
										check[i][k] = true;
										map[i][j] = 0;
										map[i][k] += now;
										break;										
									} else {
										map[i][j] = 0;
										map[i][k-1] = now;
										break;
									}
								} else {
									if(k==N-1) {
										map[i][j] = 0;
										map[i][k] = now;
										break;										
									}
								}
								
							}
						}
					}
				}
				break;
			case "up":
				for (int i = 0; i < N; i++) {
					for (int j = 1; j < N; j++) {
						if (map[j][i] != 0) {
							int now = map[j][i];
							for(int k = j-1; k >=0; k--) {
								if(map[k][i] != 0) {
									if(map[k][i] == now && !check[k][i]) {
										check[k][i] = true;
										map[j][i] = 0;
										map[k][i] += now;
										break;										
									} else {
										map[j][i] = 0;
										map[k+1][i] = now;
										break;
									}
								} else {
									if(k==0) {
										map[j][i] = 0;
										map[k][i] = now;
										break;										
									}
								}
								
							}
						}
					}
				}
				break;
			case "down":
				for (int i = N-1; i >= 0; i--) {
					for (int j = N-2; j >= 0; j--) {
						if (map[j][i] != 0) {
							int now = map[j][i];
							for(int k = j+1; k < N; k++) {
								if(map[k][i] != 0) {
									if(map[k][i] == now && !check[k][i]) {
										check[k][i] = true;
										map[j][i] = 0;
										map[k][i] += now;
										break;										
									} else {
										map[j][i] = 0;
										map[k-1][i] = now;
										break;
									}
								} else {
									if(k==N-1) {
										map[j][i] = 0;
										map[k][i] = now;
										break;										
									}
								}
								
							}
						}
					}
				}
				break;

			default:
				break;
			}
			System.out.println("#"+tc);
			print(map);
			
		}
	}

	private static void print(int[][] map2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	

}
