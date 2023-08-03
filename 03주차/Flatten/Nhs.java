import java.util.Scanner;

public class Nhs {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			int[] boxes = new int[100];
			
			for (int i = 0; i < boxes.length; i++) {
				boxes[i] = sc.nextInt();
			}
			int res = flatten(boxes, dump);
			System.out.printf("#%d %d\n", tc, res);
			
		}
	}
	private static int[][] diff(int[] arr) {
		int[][] temp = new int[2][2];
		int max = 0;
		int maxIdx = 0;
		int min = 100;
		int minIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				maxIdx = i;
			}
			if(min > arr[i]) {
				min = arr[i];
				minIdx = i;
			}
		}
		temp[0][0] = max;
		temp[0][1] = maxIdx;
		temp[1][0] = min;
		temp[1][1] = minIdx;
		return temp;
	}
	
	private static int flatten(int[] arr, int d) {
		int[][] diffInfo = diff(arr);
		int max = diffInfo[0][0];
		int maxIdx = diffInfo[0][1];
		int min = diffInfo[1][0];
		int minIdx = diffInfo[1][1];
		
		int res = max-min;
		if(d <= 0 || res <= 1) {
			return res;
		}
		
		arr[maxIdx]--;
		arr[minIdx]++;
		return flatten(arr, d-1);
	}

}
