import java.io.*;
import java.util.*;

public class swea4366 {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream(new File("input.txt")));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			String ans = ""; // 원래 송금하기로 한 금액
			String bin = sc.next(); // 2진수
			String tir = sc.next(); // 3진수
			
			ArrayList<String> binary = new ArrayList<String>(); // 2진수 후보 배열
			ArrayList<String> tirnary = new ArrayList<String>(); // 3진수 후보 배열
			StringBuilder temp = null;
			
			// 2진수에서 0, 1로 바꾸기
			for (int i = 0; i < bin.length(); i++) {
				temp = new StringBuilder(bin);
				if(bin.charAt(i) == '0') { // 0이면
					temp.setCharAt(i, '1'); // 1로
				} else { 					// 1이면
					temp.setCharAt(i, '0'); // 0으로
				}
				binary.add(String.valueOf(Integer.parseInt(temp.toString(), 2))); // 10진수로 변환 후 저장
			}
			
			// 3진수에서 0, 1, 2로 바꾸기
			for (int i = 0; i < tir.length(); i++) {
				temp = new StringBuilder(tir);
				if(tir.charAt(i) == '0') { // 0이면 1, 2로
					temp.setCharAt(i, '1');
					tirnary.add(String.valueOf(Integer.parseInt(temp.toString(), 3)));
					temp.setCharAt(i, '2');
					tirnary.add(String.valueOf(Integer.parseInt(temp.toString(), 3)));
				} else if(tir.charAt(i) == '1') { // 1이면 0, 2로
					temp.setCharAt(i, '0');
					tirnary.add(String.valueOf(Integer.parseInt(temp.toString(), 3)));
					temp.setCharAt(i, '2');
					tirnary.add(String.valueOf(Integer.parseInt(temp.toString(), 3)));
				} else { // 2이면 0, 1로
					temp.setCharAt(i, '0');
					tirnary.add(String.valueOf(Integer.parseInt(temp.toString(), 3)));
					temp.setCharAt(i, '1');
					tirnary.add(String.valueOf(Integer.parseInt(temp.toString(), 3)));
				}
			}
			
			for (int i = 0; i < binary.size(); i++) {
				for (int j = 0; j < tirnary.size(); j++) {	
					if(binary.get(i).equals(tirnary.get(j))) { // 같으면 ans에 저장
						ans = binary.get(i);
						break;
					}
				}
			}
			
			System.out.println("#" + t + " " + ans); // 출력
		}

	}

}
