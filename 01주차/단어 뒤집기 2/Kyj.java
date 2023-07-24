import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        int s = -1;
        int e = -1;
        for (int i = 0; i < str.length(); i++) {
            if (chars[i] == '<') {
                if (s != -1) {
                    e = i - 1;
                    for (int a = 0; a < (e - s + 1) / 2; a++) {
                        char tmp = chars[s + a];
                        chars[s + a] = chars[e - a];
                        chars[e - a] = tmp;
                    }
                    s = -1;
                    e = -1;
                }
                do {
                    i++;
                } while (chars[i] != '>');

            } else if (chars[i] == ' ') {
                if (s != -1) {
                    e = i - 1;
                    for (int a = 0; a < (e - s + 1) / 2; a++) {
                        char tmp = chars[s + a];
                        chars[s + a] = chars[e - a];
                        chars[e - a] = tmp;

                    }
                    s = -1;
                    e = -1;
                }
            } else {
                if (s == -1) {
                    s = i;
                }
            }
        }

        if (s != -1) {
            e = chars.length - 1;
            for (int a = 0; a < (e - s + 1) / 2; a++) {
                char tmp = chars[s + a];
                chars[s + a] = chars[e - a];
                chars[e - a] = tmp;
            }
            s = -1;
            e = -1;
        }
        System.out.println(chars);
    }

}
