import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] dogs = new int[2][2];
        int[] delivery = new int[3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                dogs[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            delivery[i] = sc.nextInt();
        }
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer = 0;
            for (int j = 0; j < 2; j++) {
                int a = dogs[j][0];
                int d = dogs[j][1];
                int m = delivery[i] % (a + d);
                if (m > 0 && m <= a) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}