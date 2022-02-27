import java.util.Scanner;

public class B15651 {
    private static Integer[] selected;
    private static int N, M;
    private static StringBuffer stringBuffer;

    public static void main(String[] args) {
        // 1부터 N까지 자연수 중에서 M개를 고른 수열
        // 수열이니까...담는 배열을 생성해야 될 것 같다 -> 1부터 시작하니까, 배열의 갯수는 M + 1
        // 같은 수 여러번 선택 가능
        // 1 <= M <= N <= 7
        // 수열은 사전 순으로 증가하는 순서로 출력

        initializeData();
        selectNumber(1);
        System.out.println(stringBuffer.toString());
    }

    // 초기화
    public static void initializeData() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        selected = new Integer[M + 1];
        stringBuffer = new StringBuffer();
    }

    public static void selectNumber(int selectedIndex) {
        // 모든 수열이 선택된 경우 출력
        if(selectedIndex > M) {
            for(int i = 1; i <= M; i++) {
                stringBuffer.append(selected[i]).append(" ");
            }
            stringBuffer.append("\n");
        } else {
            for(int i = 1; i <= N; i++) {
                selected[selectedIndex] = i;
                selectNumber(selectedIndex + 1);
                selected[selectedIndex] = 0;
            }
        }
    }
}
