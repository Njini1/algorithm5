import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int answer = 0;
		int cutting = 0;
		ArrayList<Integer> cake1 = new ArrayList<>();
		ArrayList<Integer> cake2 = new ArrayList<>();
		// 입력받기
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			if (tmp == 10) {
				answer++;
			} else if (tmp % 10 == 0) {
				cake1.add(tmp);
			} else {
				cake2.add(tmp);
			}
		}
		Collections.sort(cake1);
		//
		for (Integer c : cake1) {
			if (cutting == m)
				break;
			if (cutting + (c / 10 - 1) > m) {
				if ((m - cutting) == (c / 10 - 1)) {
					answer += c / 10;
					cutting = m;
					continue;
				}
				answer += m - cutting;
				cutting = m;
			} else {
				cutting += c / 10 - 1;
				answer += c / 10;
			}
		}

		for (Integer c : cake2) {
			if (cutting == m)
				break;
			if (cutting + c / 10 > m) {
				answer += m - cutting;
				cutting = m;
			} else {
				cutting += c / 10;
				answer += c / 10;
			}
		}
		System.out.println(answer);
	}
}
