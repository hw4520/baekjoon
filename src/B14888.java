import java.util.Scanner;

public class B14888 {
    // N은 수의 개수 -> 2<= N <= 11
    // 임의의 수는 1 <= 수 <= 100
    // N개의 수로 이루어진 수열
    // N-1개의 연산자가 주어짐(덧셈, 뺄셈, 곱셈, 나눗셈 순)
    // 수의 순서는 고정
    // **연산자를 여러 경우의 수로 조합을 해야한다
    // 음수를 양수로 나눌 때의 예외처리 필요
    // +가 1, -가 2, *가 3, /가 4로 가정


    static int N, maxResult, minResult;
    static int[] numbers, operatorCnt, operatorGroup;
    enum OPER_TYPE {
        DEFAULT, ADD, MINUS, MULTI, DIV
    }

    public static void main(String[] args) {
        initializeData();
        insertOperatorGroup(1, numbers[1]);
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    // 초기화
    static void initializeData() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        numbers = new int[N + 1];
        operatorCnt = new int[5];
        operatorGroup = new int[N];
        for(int i = 1; i <= N; i++) {
            numbers[i] = scanner.nextInt();
        }
        for(int i = 1; i <= 4; i++) {
            operatorCnt[i] = scanner.nextInt();
        }
        maxResult = Integer.MIN_VALUE;
        minResult = Integer.MAX_VALUE;
    }

    // 계산하기
    static int calculateNumbers(int firstNumber, int operatorType, int secondNumber) {
        if(operatorType == OPER_TYPE.ADD.ordinal()) {
            return firstNumber + secondNumber;
        }
        if(operatorType == OPER_TYPE.MINUS.ordinal()) {
            return firstNumber - secondNumber;
        }
        if(operatorType == OPER_TYPE.MULTI.ordinal()) {
            return firstNumber * secondNumber;
        }
        if(operatorType == OPER_TYPE.DIV.ordinal()) {
            if(firstNumber < 0) {
                int reverseNum = -firstNumber;
                int reverseResult = reverseNum / secondNumber;
                return -reverseResult;
            } else {
                return firstNumber / secondNumber;
            }

        }
        return 0;
    }

    // 연산자 조합하기
    static void insertOperatorGroup(int groupIndex, int caculatedResult) {
        if(groupIndex > N - 1) {
            maxResult = Math.max(maxResult, caculatedResult);
            minResult = Math.min(minResult, caculatedResult);
        } else {
            for(int operatorType = OPER_TYPE.ADD.ordinal(); operatorType <= OPER_TYPE.DIV.ordinal(); operatorType++) {
                if(operatorCnt[operatorType] == 0) {
                    continue;
                }
                operatorGroup[groupIndex] = operatorType;
                operatorCnt[operatorType]--;
                insertOperatorGroup(groupIndex + 1, calculateNumbers(caculatedResult, operatorGroup[groupIndex], numbers[groupIndex + 1]));
                operatorGroup[groupIndex] = OPER_TYPE.DEFAULT.ordinal();
                operatorCnt[operatorType]++;
            }
        }
    }

}
