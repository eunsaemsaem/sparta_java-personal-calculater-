package calculator.operator;

import calculator.ArithmeticCalculator;
import calculator.CalculateException;

public class DivideOperator implements Operators {
    @Override
    public double operate(int a, int b) throws CalculateException {
        if (b == 0) {
            throw new CalculateException("두번째 숫자로 0을 입력할 수 없습니다.");
        }
        return (double) a / b;
    }
}
