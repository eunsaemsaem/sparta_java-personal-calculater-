package calculator.operator;

import calculator.ArithmeticCalculator;
import calculator.CalculateException;

public class DivideOperator implements Operators {
    @Override
    public double operate(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("알 수 없는 연산자입니다."); //calculateException은 오류가 나는 이유?
        }
        return (double) a / b;
    }
}
