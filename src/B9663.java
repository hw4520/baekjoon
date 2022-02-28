import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B9663 {

    // 퀸은 위아래, 좌우, 대각선으로 움직이는 말이다
    // 퀸의 rowIndex - 타켓말의 rowIndex의 절대값과 퀸의 columnIndex - 타켓말의 columnIndex의 절대값이 같으면 대각선에 위치하게 된다

    public static int N;
    public static int possibleCnt;
    public static int[] queenRowAndColumn;

    public static void main(String[] args) {
        initialize();
        nQeen(1);
        System.out.println(possibleCnt);
    }

    // 초기화
    public static void initialize() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        queenRowAndColumn = new int[N + 1];
    }

    // 퀸 가능여부 체크
    public static boolean isPossibleQueen(int rowIndex, int columnIndex) {
        for(int row = 1; row < rowIndex; row++) {
            if(queenRowAndColumn[row] == columnIndex) {
                return false;
            }
            if(Math.abs(row - rowIndex) == Math.abs(queenRowAndColumn[row] - columnIndex)) {
                return false;
            }
        }
        return true;
    }

    public static void nQeen(int rowIndex) {
        if(rowIndex > N) {
            possibleCnt++;
            return;
        }
        for(int columnIndex = 1; columnIndex<=N; columnIndex++) {
            if(isPossibleQueen(rowIndex, columnIndex)) {
                queenRowAndColumn[rowIndex] = columnIndex;
                nQeen(rowIndex + 1);
                queenRowAndColumn[rowIndex] = 0;
            }
        }
    }
}
