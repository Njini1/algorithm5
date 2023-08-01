import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.next().replaceAll("dz=","*").replaceAll("(c=|c-|d-|lj|nj|s=|z=)","*").length());
	}
}
