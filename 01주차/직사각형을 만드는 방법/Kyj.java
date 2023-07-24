import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int answer = 0;
    for(int i = 1; i<=n;i++){
      int tmp = 0;
      for(int j = 1; j<=i;j++){
        if(i%j==0){
          tmp++;
        }
      }
      answer+=Math.ceil(((double)tmp/2));
    }
    System.out.println(answer);
  }
}
