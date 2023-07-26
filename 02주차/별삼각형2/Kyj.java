import java.util.*;

class Main {
    public static void print1(int n, int m) {
        for (int i = 0; i < n / 2 + 1; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = n / 2 + 1; i < n; i++) {
            for (int j = n - i; j > 0; j--)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void print2(int n, int m) {
        for (int i = 0; i < n / 2 + 1; i++) {
            for (int j = n / 2 - i; j > 0; j--)
                System.out.print(" ");
            for (int j = 0; j < i + 1; j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < i + 1; j++)
                System.out.print(" ");
            for (int j = n / 2 - i; j > 0; j--)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void print3(int n, int m) {
        for (int i = 0; i < n / 2 + 1; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(" ");
            for (int j = 0; j < n - 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2 - i - 1; j++)
                System.out.print(" ");
            for (int j = 0; j < 2 * (i + 1) + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void print4(int n, int m) {
        for (int i = 0; i < n / 2 + 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (n / 2 + 1) - i; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 2; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n > 100 || n < 0 || m < 1 || m > 4 || n % 2 == 0) {
            System.out.println("INPUT ERROR!");
            return;
        }
        switch (m) {
        case 1:
            print1(n, m);
            break;
        case 2:
            print2(n, m);
            break;
        case 3:
            print3(n, m);
            break;
        case 4:
            print4(n, m);
            break;
        }
    }
}
