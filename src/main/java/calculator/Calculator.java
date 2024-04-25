package calculator;

public class Calculator {
    public double calculate (int a, int b, char op) throws CalculateException {
        double result = 0; // 정확한 값을 출력하기 위한 double

        //연산자 조건을 switch로 나눔
        switch (op) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '/' -> {
                if (a == 0) {
                    throw new CalculateException("두번째 숫자는 0이 될 수 없습니다. "); // 출력이 안됨..
                }
                else {
                    result = (double) a / b;
                }
            }
            case '*' -> result = a * b;
            case '%' -> result = a % b;
            default -> throw new CalculateException("Unknown operator");
        }

        return result;
    }

}
