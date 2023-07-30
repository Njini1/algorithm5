import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n;
        int x = 0;
        int y = -1;
        int num = 1;
        int[][] arr = new int[n][n];
        while (m > 0) {
            for (int i = 0; i < m; i++) {
                arr[x][++y] = num++;
            }
            m--;
            for(int i = 0; i<m;i++){
                arr[++x][y] = num++;
            }
            for(int i = 0;i<m;i++){
                arr[x][--y] = num++;
            }
            m--;
            for(int i = 0; i<m;i++){
                arr[--x][y] = num++;
            }
        }
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}