import java.util.Scanner;

public class B1182 {
    // 각 정수를 포함한다, 제외한다 경우의 수로 부분수열을 조합한다
    
    public static int N, S, cnt;
    public static int[] numbers;

    public static void main(String[] args) {
        initialize();
        addNumbers(1, 0);
        if(S == 0) {
            cnt--;
        }
        System.out.println(cnt);
    }

    // 초기화
    public static void initialize() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        S = scanner.nextInt();
        numbers = new int[N+1];
        for(int i = 1; i<=N; i++) {
            numbers[i] = scanner.nextInt();
        }
    }

    public static void addNumbers(int numbersIndex, int addResult) {
        if(numbersIndex > N) {
            if(addResult == S) {
                cnt++;
            }
            return;
        }
        addNumbers(numbersIndex + 1, addResult);
        addNumbers(numbersIndex + 1, addResult + numbers[numbersIndex]);
    }
}
