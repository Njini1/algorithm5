import java.util.*;

class Main {
    public static void print1(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void print2(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void print3(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j > 0; j--)
                System.out.print(" ");
            for (int j = 0; j < 2 * i + 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n > 100 || n < 0 || m < 0 || m > 3) {
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
        }
    }
}